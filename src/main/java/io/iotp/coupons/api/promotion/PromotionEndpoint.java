package io.iotp.coupons.api.promotion;



import io.iotp.coupons.dto.PromotionCodeDto;
import io.iotp.coupons.dto.PromotionFormDto;
import io.iotp.coupons.dto.PromotionForms;
import io.iotp.coupons.entity.PromotionCode;
import io.iotp.coupons.entity.PromotionForm;
import io.iotp.coupons.service.PromotionCodeService;
import io.iotp.coupons.service.PromotionFormService;
import io.iotp.coupons.tool.ReadExcel;
import io.springbootstrap.core.annotation.UserLogConfig;
import io.springbootstrap.core.api.ApiPage;
import io.springbootstrap.core.api.ApiResponseData;
import io.springbootstrap.core.api.BasicEndpoint;
import io.springbootstrap.core.service.EntityDtoMapService;
import io.springbootstrap.core.util.IdConfuseUtils;
import io.swagger.annotations.*;
import org.hashids.Hashids;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/promotion/")
@UserLogConfig(moduleName = "优惠码管理")
@Api(value = "优惠码管理Api")
public class PromotionEndpoint extends BasicEndpoint<PromotionForm, PromotionFormDto> {
    @Autowired
    PromotionFormService promotionFormService;
    @Autowired
    PromotionCodeService promotionCodeService;
    @Autowired
    EntityDtoMapService entityDtoMapService;

    /**
     *  优惠码保存
     */
    @RequestMapping(value = "/{entityId}", method = RequestMethod.POST)
    @ApiOperation(value = "保存／更新 优惠码信息", httpMethod = "POST", tags = "Web端API -- 优惠码信息保存")
    public ApiResponseData savePromotion(@PathVariable @ApiParam(value = "优惠码实体ID", required = true) String entityId,
                                         @RequestParam @ApiParam(value = "优惠码生成数量", required = true) int promotionCount  ,
                                         @RequestBody @ApiParam(value = "优惠码信息", required = true)PromotionForms promotionFormDto,
                                         @RequestParam @ApiParam(value = "生成优惠码的位数",required = true)int activityCode){
        ApiResponseData responseData;
        try {
            responseData = new ApiResponseData();
            Hashids hashids = new Hashids("io spring bootstrap", activityCode);//生成优惠码
            int maxId = this.promotionCodeService.getMaxId();//查询已有的优惠码最大id值
            String shopId = promotionFormDto.getShopId();
            PromotionForm promotionForm = new PromotionForm();
            BeanUtils.copyProperties(promotionFormDto, promotionForm, "id", "shopId");
            long idConfuse =IdConfuseUtils.decodeId(entityId);
            promotionForm.setId(idConfuse);
            if (idConfuse != -1L) {//更新
                PromotionForm promotionForms =promotionFormService.load(idConfuse); //设置不可修改的部分
                promotionForm.setCode(promotionForms.getCode());              //优惠码
                promotionForm.setShopId(promotionForms.getShopId());          //店铺id
                promotionForm.setType(promotionForms.getType());             //优惠码类型
                promotionForm.setCouponId(promotionForms.getCouponId());     //对应优惠卷id
                promotionFormService.save(promotionForm);
                responseData.setData("修改成功");
            } else { //新增
                long curShopId = IdConfuseUtils.decodeId(shopId);//店铺id
                promotionForm.setShopId((int) curShopId);
                promotionForm.setCouponId((int)IdConfuseUtils.decodeId(promotionFormDto.getCouponId()));//设置解混淆后的对应优惠卷id
                promotionForm.setCreated(new Date());//创建日期
                promotionForm.setStatus(0);//优惠码状态(0:正常状态  1：禁用状态)
                if (promotionForm.getType().equals("TY")) {               //通用码
                    String code =hashids.encode(maxId + 1);
                    promotionForm.setCode(code);
                    long id =  this.promotionFormService.save(promotionForm).getId();
                    PromotionCode promotionCode = new PromotionCode();
                    promotionCode.setCode(code);
                    promotionCode.setParentId((int)id);
                    promotionCodeService.save(promotionCode);
                } else if (promotionForm.getType().equals("WY")) {  //唯一码
                    promotionForm.setCode(null);
                    long id = this.promotionFormService.save(promotionForm).getId();//优惠码信息id
                    for (int i = 0; i < promotionCount; i++) {
                        maxId += 1;
                        PromotionCode promotionCode = new PromotionCode();
                        promotionCode.setParentId((int) id);
                        promotionCode.setCode(hashids.encode(maxId));
                        promotionCode.setExchangedAt(null);
                        promotionCodeService.save(promotionCode);
                    }
                }
                responseData.setData("保存成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseData = new ApiResponseData(ApiResponseData.ERROR_CODE, "抱歉，优惠码信息保存失败");
        }
        return  responseData;
    }

    /**
     *  优惠码模版分页信息
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "优惠码模版分页信息", httpMethod = "GET", tags = "Web端API -- 优惠码模版分页信息")
    public ApiResponseData<ApiPage<PromotionFormDto>> promotionFormDtoPage(@ApiParam(value = "分页参数", required = true) @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(required = false) @ApiParam(value = "模糊搜索", required = false)String searchPhrase,@RequestParam(required = false)@ApiParam(defaultValue ="0" ,value = "查询类型  0：所有  1：唯一   2：通用 ")int type){
        Page<PromotionForm> promotionFormPage =  this.promotionFormService.promotionFormPage(pageable,searchPhrase,type);
        Page<PromotionFormDto> promotionFormDtoPage =this.mapToDtoPage(pageable,promotionFormPage);
        return  this.wrapPage(promotionFormDtoPage);
    }

    /**
     *  优惠码模版详细信息
     */
    @RequestMapping(value = "/details／{id}", method = RequestMethod.GET)
    @ApiOperation(value = "优惠码模版详细信息", httpMethod = "GET", tags = "Web端API -- 优惠码模版详细信息")
    public PromotionFormDto getPromotionFormDto(@PathVariable @ApiParam(value = "优惠码模版混淆id",required = true)String id){
        long  decodeId =  IdConfuseUtils.decodeId(id);//转为非混淆id
        PromotionForm promotionForm=this.promotionFormService.load(decodeId);
        return  this.mapToDto(promotionForm);
    }

    /**
     *  某个优惠码模版下优惠码的分页信息   type:{不传：查询所有类型  YDH:查询已兑换类型  WDH:查询未兑换类型}
     */
    @RequestMapping(value = "/promotionCodePage/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "某个优惠码模版下所有优惠码的分页信息", httpMethod = "GET", tags = "Web端API -- 某个优惠码模版下所有优惠码的分页信息")
    public  ApiResponseData<ApiPage<PromotionCodeDto>>promotionFormDtoPage(@ApiParam(value = "分页参数", required = true) @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(required = false) @ApiParam(value = "模糊搜索", required = false)String searchPhrase,@PathVariable(required = true) @ApiParam(value = "优惠码模版id", required = true)String id,@RequestParam(required = false)@ApiParam(value = "不传：查询所有类型  YDH:查询已兑换类型  WDH:查询未兑换类型",required = false)String type){
        long decodeId =IdConfuseUtils.decodeId(id);
        Page<PromotionCode> promotionCodePage=null;
        if(type==null){
            promotionCodePage =  this.promotionCodeService.getPromotionList(decodeId,pageable,searchPhrase);
        }else if(type.equals("YDH")){
            promotionCodePage =  this.promotionCodeService.getPromotionListOrder(decodeId,pageable,searchPhrase);
        }else if(type.equals("WDH")){
            promotionCodePage =  this.promotionCodeService.getPromotionListUnfinished(decodeId,pageable,searchPhrase);
        }
        Page<PromotionCodeDto> promotionCodeDtoPage = entityDtoMapService.mapToDtoPage(pageable, promotionCodePage, PromotionCodeDto.class);
        return  this.wrapPage(promotionCodeDtoPage);
    }

    /**
     *  某个优惠码模版下所有优惠码信息    Excel导出
     */
    @RequestMapping(value = "/exportExcelById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "某个优惠码模版下所有优惠码信息Excel导出", httpMethod = "GET", tags = "Web端API -- 某个优惠码模版下所有优惠码信息Excel导出")
    public ApiResponseData  exportExcel(HttpServletRequest request,HttpServletResponse response,@ApiParam(value = "优惠码模版id", required = true)@PathVariable(required = true) String id ){
        List<PromotionCode> promotionCodeList =this.promotionCodeService.getByPromotionFormId(IdConfuseUtils.decodeId(id));
        String promotionFormName =this.promotionCodeService.getPromotionFormName(IdConfuseUtils.decodeId(id));
        List<PromotionCodeDto> promotionCodeDtoList=entityDtoMapService.mapToDtos(promotionCodeList,PromotionCodeDto.class);
        ApiResponseData   apiResponseData = new ApiResponseData();
        ReadExcel excel = new ReadExcel();
        try {
            excel.readExcel(request,response,promotionCodeDtoList,promotionFormName);
            //excel.readExcel(request, response, promotionCodeDtoList,promotionFormName);
            apiResponseData.setData("导出成功");
        }catch (Exception ex){
            apiResponseData.setErrMsg("导出失败"+ex.getMessage());
        }
        return  apiResponseData;
    }

}

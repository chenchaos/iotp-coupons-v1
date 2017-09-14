package io.iotp.coupons.tool;

import io.iotp.coupons.dto.PromotionCodeDto;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ReadExcel {
    public void readExcel(HttpServletRequest request, HttpServletResponse response,List<PromotionCodeDto> promotionCodeDtoList, String promotionFormName)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");
        OutputStream out = response.getOutputStream();
        //报头用于提供一个推荐的文件名，并强制浏览器显示保存对话框
        //attachment表示以附件方式下载。如果要在页面中打开，则改为 inline
        response.setHeader("Content-Disposition", "attachment; filename=TestExcel1.xls ");
        //创建workbook工作薄
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("优惠码信息");
        //创建第二个工作薄
        Sheet sheet2 = workbook.createSheet();
        //为工作薄起名字
        workbook.setSheetName(1, promotionFormName);
        //设置单元格样式
        HSSFCellStyle hssfCellStyle = (HSSFCellStyle) workbook.createCellStyle();
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中显示
        hssfCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//纵向居中
        //创建行
        Row row = sheet.createRow(0);
        //创建单元格
        Cell cell = row.createCell(0);
        //设置第一行第一格的值
        cell.setCellValue("优惠码");
        //设置单元格的文本居中显示
        cell.setCellStyle(hssfCellStyle);
        //创建单元格
        Cell cell1 = row.createCell(1);
        //设置第一行第一格的值
        cell1.setCellValue("是否已经兑换");
        cell1.setCellStyle(hssfCellStyle);
        //创建单元格
        Cell cell2 = row.createCell(2);
        //设置第一行第一格的值
        cell2.setCellValue("兑换人名称");
        cell2.setCellStyle(hssfCellStyle);
        //创建单元格
        Cell cell3 = row.createCell(3);
        //设置第一行第一格的值
        cell3.setCellValue("兑换时间");
        cell3.setCellStyle(hssfCellStyle);
        for (int i = 1; i <= promotionCodeDtoList.size(); i++) {
            PromotionCodeDto  promotionCodeDto =promotionCodeDtoList.get(i-1);
            //创建行
            Row rows = sheet.createRow(i);
            //创建单元格
            Cell cells = rows.createCell(0);
            //设置第一行第一格的值
            cells.setCellValue(promotionCodeDto.getCode());
            //创建单元格
            Cell cell1s = rows.createCell(1);
            //设置第一行第一格的值
            String isTailoredToChina ="" ;
            if(promotionCodeDto.getExchangedAt()==null){
                isTailoredToChina="未兑换";
            }else{
                isTailoredToChina="已兑换";
            }
            cell1s.setCellValue(isTailoredToChina);
            //创建单元格
            Cell cell2s = rows.createCell(2);
            //设置第一行第一格的值
            if(promotionCodeDto.getUserName()!=null){
                cell2s.setCellValue(promotionCodeDto.getUserName());
            }
            //创建单元格
            Cell cell3s = rows.createCell(3);
            //设置第一行第一格的值
            //设置单元格格式为日期
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(
                    creationHelper.createDataFormat().getFormat("yyyy-MM-dd  hh:mm:ss")
            );
            cell3s.setCellStyle(cellStyle);
            if(promotionCodeDto.getExchangedAt()!=null){
                cell3s.setCellValue(promotionCodeDto.getExchangedAt());
            }
        }
        workbook.write(out);
        //System.out.println("数据写入成功！");
        out.flush();
        out.close();
    }
}

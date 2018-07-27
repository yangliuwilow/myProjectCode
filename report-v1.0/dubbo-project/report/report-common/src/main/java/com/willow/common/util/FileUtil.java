package com.willow.common.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 读取txt文件
     * @param input
     * @return  “1,2,3”
     * @throws Exception
     */
    public static String readTxt(InputStream input)  throws Exception{
        if(input==null){
            return "";
        }
        InputStreamReader insreader = new InputStreamReader(input, "UTF-8");
        BufferedReader bin = new BufferedReader(insreader);
        StringBuffer sbStr=new StringBuffer();
        String line;
        while ((line = bin.readLine()) != null) {
            if(sbStr.length()==0)
                sbStr.append(line);
            else sbStr.append(","+line);
        }
        bin.close();
        insreader.close();
        return sbStr.toString();
    }


    /**
     * 读取 office 2003 excel
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static List<List<Object>> readExcel(MultipartFile file) throws  Exception{
        if(file==null)
            return null;
        String suffix = file.getOriginalFilename().substring
                (file.getOriginalFilename().lastIndexOf("."));
        if(".xlsx".equals(suffix))
            return read2007Excel(file.getInputStream());
        else if(".xls".equals(suffix))
            return read2003Excel(file.getInputStream());
        else {
            return   null;
        }
    }

    /**
     * 读取 office 2003 excel
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static List<List<Object>> read2003Excel(InputStream stream)
            throws Exception {
        List<List<Object>> list = new LinkedList<List<Object>>();
        HSSFWorkbook hwb =null;
        try{
            hwb = new HSSFWorkbook(stream);
            HSSFSheet sheet = hwb.getSheetAt(0);
            Object value = null;
            HSSFRow row = null;
            HSSFCell cell = null;
            // 字符
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
            DecimalFormat dfs = new DecimalFormat("0");
            List<Object> linked =null;
            logger.debug("读取office 2003 excel内容如下：");
            for (int i = sheet.getFirstRowNum(); i <= sheet
                    .getPhysicalNumberOfRows(); i++) {
                row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                linked = new LinkedList<Object>();
                for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                                value =  dfs.format(cell.getNumericCellValue()) ;

                            } else if ("General".equals(cell.getCellStyle()
                                    .getDataFormatString())) {
                                value = dfs.format(cell.getNumericCellValue());
                            } else {
                                value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                        .getNumericCellValue()));
                            }
                            break;
                        case XSSFCell.CELL_TYPE_BOOLEAN:
                            value = cell.getBooleanCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            value = "";
                            break;
                        default:
                            value = cell.toString();
                    }
                    if (value == null || "".equals(value)) {
                        continue;
                    }
                    linked.add(value);

                }
                list.add(linked);
            }
        }catch (Exception e){
            throw  e;
        }finally {
           // hwb.close();
        }
        return list;
    }

    /**
     * 读取Office 2007 excel
     */

    public static List<List<Object>> read2007Excel(InputStream stream)
            throws Exception{

        List<List<Object>> list = new LinkedList<List<Object>>();
        XSSFWorkbook xwb =   null;
        try{
            xwb= new XSSFWorkbook(stream);
            // 读取第一章表格内容
            XSSFSheet sheet = xwb.getSheetAt(0);
            Object value = null;
            XSSFRow row = null;
            XSSFCell cell = null;
            DecimalFormat dfs = new DecimalFormat("0");
            // 字符
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
            List<Object> linked =null;
            for (int i = sheet.getFirstRowNum(),  lastRow=sheet.getPhysicalNumberOfRows(); i <=lastRow ; i++) {
                row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                linked = new LinkedList<Object>();
                for (int j = row.getFirstCellNum(),lastNum=row.getLastCellNum() ;j <=lastNum ; j++) {
                    cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                                value =  dfs.format(cell.getNumericCellValue()) ;

                            } else if ("General".equals(cell.getCellStyle()
                                    .getDataFormatString())) {
                                value = dfs.format(cell.getNumericCellValue());
                            } else {
                                value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                        .getNumericCellValue()));
                            }
                            break;
                        case XSSFCell.CELL_TYPE_BOOLEAN:
                            value = cell.getBooleanCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            value = "";
                            break;
                        default:
                            value = cell.toString();
                    }
                    if (value == null || "".equals(value)) {
                        continue;
                    }
                    linked.add(value);
                }
                list.add(linked);
            }
        }catch (Exception e){
            throw  e;
        }finally {
          //  xwb.close();
        }
        return list;
    }
}

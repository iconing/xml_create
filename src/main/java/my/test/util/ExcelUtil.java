package my.test.util;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ExcelUtil {
    public static LinkedHashMap<String, String> getMap(String excelFilePath) throws Exception{
        InputStream is = new FileInputStream(new File(excelFilePath));
//        Workbook wb = new XSSFWorkbook(is);
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        for (int i = 1; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(2);
            if(null != cell && cell.getStringCellValue() != null && !"".equals(cell.getStringCellValue())) {
                String key = row.getCell(2).getStringCellValue();
                String value = row.getCell(1).getStringCellValue();
                map.put(key, value);
            }
        }
        System.out.println(map);
        return map;
    }
}

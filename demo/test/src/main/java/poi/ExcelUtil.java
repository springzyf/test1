package poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class ExcelUtil {

    public void readExcel(String path) throws IOException, InvalidFormatException {
        File excel = new File(path);
        FileInputStream is = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(is);
        if (workbook != null) {
            //获取一共有多少个工作表
                //获取到工作表
                Sheet sheet = workbook.getSheetAt(0);
                //开始的第一行
                int firstRowNum = sheet.getFirstRowNum();
                for (int j = firstRowNum; j <= sheet.getLastRowNum(); j++) {
                    //进入到每一行，准备遍历每一列数据
                    Row row = sheet.getRow(j);
                    int first = row.getFirstCellNum();
                    for (int k = first; k < row.getPhysicalNumberOfCells(); k++) {
                        Cell cell = row.getCell(k);
                        String value = getCellValue(cell);
                        System.out.println(value);
                    }
                }

        }


    }

    private String getCellValue(Cell cell) {
        String value = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC://数字类型
                value = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING://字符串类型
                value = cell.getStringCellValue();
                break;
            default:

        }

        return value;
    }

    @Test
    public void test1() throws IOException, InvalidFormatException {
        readExcel("D:\\租房信息.xls");
    }

}

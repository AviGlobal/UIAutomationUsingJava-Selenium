package utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ExcelUtils {

    private String filePath;
    private Workbook workbook;
    private Sheet sheet;


    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    public List<Cell> getColumn(Sheet sheet, int colIndex) {
        List<Cell> columnCells = new ArrayList<>();
        for (Row row : sheet) {
            if (row != null) {
                Cell cell = row.getCell(colIndex);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    columnCells.add(cell);
                }
            }
        }
        return columnCells;
    }

    public void setCellData(String data, int rowNum, int colNum) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) row = sheet.createRow(rowNum);

            Cell cell = row.getCell(colNum);
            if (cell == null) cell = row.createCell(colNum);

            cell.setCellValue(data);

            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //You can input the file path, sheet name for reading and iterationg the Sheet
    public List<String> ReadAndPrintCompleteExcel (String filePath, String sheetName) throws IOException {
        List<String> fileData = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = null;
        if (filePath.contains(".xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } else if (filePath.contains(".xls")) {
            workbook = new HSSFWorkbook(fis);
        }
        DataFormatter formatter = new DataFormatter();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            workbook.close();
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file: " + filePath);
        }
        for (Row row : sheet) {
            if (row == null) continue;
            StringBuilder rowData = new StringBuilder();
            for (Cell cell : row) {
                if (cell == null) continue;
                rowData.append(formatter.formatCellValue(cell)).append("\t");
            }
            String rowString = rowData.toString().trim(); // remove trailing tab
            System.out.println(rowString); // print the row
            fileData.add(rowString);
        }
        workbook.close();
        return fileData;
    }



    //You can input the file path, sheet name and first name of the column it will fetch all the data below in that column
    public List<Cell> ReadExcelByColumnName (String filePath, String sheetName, String columnName) throws IOException{
        FileInputStream fis = new FileInputStream(filePath);
        log.info(columnName);
        Workbook workbook = null;
        if (filePath.contains(".xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } else if (filePath.contains(".xls")) {
            workbook = new HSSFWorkbook(fis);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        String columnInSheet = null;
        for (Row row : sheet) {
            for (Cell cell : row) {
                DataFormatter formatter = new DataFormatter();
                columnInSheet = formatter.formatCellValue(cell);
                if(columnName.equals(columnInSheet)){
                    System.out.println(columnInSheet  + "\t");
                    int columnIndex = cell.getColumnIndex();
                    log.info(String.valueOf(columnIndex));
                    return getColumn(sheet,columnIndex);
                }
            }
        }
        workbook.close();
        return null;
    }


    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

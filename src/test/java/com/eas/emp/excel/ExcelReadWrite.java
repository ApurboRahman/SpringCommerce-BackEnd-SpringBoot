package com.eas.emp.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReadWrite {
  public static final String Path_TestData =
      "C:\\Users\\BJIT\\IdeaProjects\\FinalAttendanceProject\\src\\test\\resources\\testData\\signup\\input\\";

  private static final String Path_ResultData =
      "C:\\Users\\BJIT\\IdeaProjects\\FinalAttendanceProject\\src\\test\\resources\\testData\\signup\\result\\";

  public static final String File_TestData = "testData.xlsx";
  private static final String File_ResultData = "resultData.xlsx";
  private static XSSFWorkbook excelWorkBook;
  private static XSSFSheet excelSheet;
  private static XSSFCell cell;
  private static XSSFRow row;

  // This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname
  // as Arguments to this method
  public static void openExcelFile(String path, String sheetName) {
    try {
      FileInputStream excelFile = new FileInputStream(path);
      excelWorkBook = new XSSFWorkbook(excelFile);
      excelSheet = excelWorkBook.getSheet(sheetName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // This method is to read the test data from the Excel cell, in this we are passing parameters as
  // Row num and Col num
  public static String getCellData(int rowNum, int colNum) {
    try {
      cell = excelSheet.getRow(rowNum).getCell(colNum);
      String cellData = cell.getStringCellValue();
      return cellData;
    } catch (Exception e) {
      return "";
    }
  }

  // This method is to write in the Excel cell, Row num and Col num are the parameters
  public static void setCellData(String result, int rowNum, int colNum) {
    row = excelSheet.createRow(rowNum);
    cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
    if (cell == null) {
      cell = row.createCell(colNum);
      cell.setCellValue(result);
    } else {
      cell.setCellValue(result);
    }
    // Write result to excel sheet
    try {
      FileOutputStream fOut = new FileOutputStream(Path_ResultData + File_ResultData);
      excelWorkBook.write(fOut);
      fOut.flush();
      fOut.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package com.excelplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reporting.Reporting;

public class ExcelParser extends Reporting {
	
	public static XSSFWorkbook workbook;
	public static String testcasename;
	
	/**
	 * Create a constructor to load the excel file
	 * @throws IOException 
	 */
	
	public void loadExcel() {
		System.out.println("Loading Excel File....!!!");
		File f=new File("./TestData/TestData.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Excel File Loaded Sucessfully ....!!!");
	}
	
	
	/**
	 * Get Row count of a specific sheet
	 */
	
	public int getRowCount(String sheetname) {
		System.out.println("Getting Row Count");
		System.out.println("Total Row Count :"+workbook.getSheet(sheetname).getLastRowNum());
		return workbook.getSheet(sheetname).getLastRowNum();
	}
	
	/**
	 * Get Column count of a specific sheet
	 */
	
	public int getColCount(String sheetname) {
		System.out.println("Getting Column Count");
		System.out.println("Total Column Count :"+workbook.getSheet(sheetname).getRow(0).getLastCellNum());
		return workbook.getSheet(sheetname).getRow(0).getLastCellNum();
	}
	
	/**
	 * Search for the Test case
	 */
	
	public int searchTestCase(String sheetname,String testcasename,int itr) {
		
		int rowfound=0;
		
		int rows=getRowCount(sheetname);
		
		for(int r=1;r<=rows-1;r++)
		{
			String crnttestcase=workbook.getSheet(sheetname).getRow(r).getCell(0).getStringCellValue();
			
			int crntitr=(int) workbook.getSheet(sheetname).getRow(r).getCell(1).getNumericCellValue();
			
			if(testcasename.equals(crnttestcase) && itr==crntitr )
			{
				rowfound=r;
				break;
			}
			
			
			
		}
		
		System.out.println("The Test Case :"+testcasename+" is found at the row "+(rowfound+1));
		return rowfound;
		
		
	}
	
	
	/**
	 * Search for the column name
	 */
	
	public int searchColumn(String sheetname,String column) {
		
		int colfound=0;
		
		int cols=getColCount(sheetname);
		
		for(int c=1;c<=cols-1;c++)
		{
			String crntcol=workbook.getSheet(sheetname).getRow(0).getCell(c).getStringCellValue();
			
			
			if(crntcol.equals(column) )
			{
				colfound=c;
				break;
			}
			
			
		}
		
		System.out.println("The Column Header :"+column+" is found at the Column number  "+(colfound+1));
		return colfound;
		
		
	}
	
	/**
	 * get data from the cell
	 */
	public String getData(String sheetname,int itr,String column)
	{
		String data="";
		
		int row=searchTestCase(sheetname,testcasename,itr);
		
		int col=searchColumn(sheetname, column);
		
		switch (workbook.getSheet(sheetname).getRow(row).getCell(col).getCellTypeEnum()) {
		case STRING:
			data=workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
			break;
			
		case NUMERIC:
			data=String.valueOf(workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue());
			break;

		default:
			break;
		}
		
		System.out.println("The Data For the TestCase :"+testcasename+ " And the column "+column+ " Is :"+data);
		
		return data;
		
		
		
	}

}

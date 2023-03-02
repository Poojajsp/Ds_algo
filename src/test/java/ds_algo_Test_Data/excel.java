package ds_algo_Test_Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excel {
	
	 public static void writeExcelSheet() throws IOException
	 {
		 XSSFWorkbook workbook= new XSSFWorkbook();
		 XSSFSheet worksheet=workbook.createSheet("sheet 1");
	 int rowNum=0;
	  for(int i=1; i<=10; i++)
		 {		 
			Row row = worksheet.createRow(rowNum++);
		 int columnum=0;
			 for(int j=1; j<=10 ;j++)
			 {
				 Cell cell = row.createCell(columnum++);
				 
				 cell.setCellValue("Row "+i+ " column "+j);
			 }
		 }
	    String userdirectory =  System.getProperty("user.dir");
		String path=userdirectory+"src\\test\\resources\\TestData\\dsalgodata.xlsx";
		File Excelfile=new File(path);
		 FileOutputStream Fos=null;
		 try 
		 {
		 Fos=new FileOutputStream(Excelfile);
			  workbook.write(Fos);
			  workbook.close();
	  }
		 catch(FileNotFoundException e)
		 {
			 e.printStackTrace();
		 }
		 finally 
		 {
			 
			 Fos.close();
		 }
	 }
	 
	 public static void ReadExcelSheet() throws IOException {
		  String userdirectory =  System.getProperty("user.dir");
			String path=userdirectory+"src\\test\\resources\\TestData\\dsalgodata.xlsx";
		 
		// String path="C:/Users/pooja/eclipse-workspace/Ds_algo/src/test/resources/TestData/dsalgodata.xlsx";
			File Excelfile=new File(path);
	 
	 FileInputStream Fis= new FileInputStream(Excelfile);
	 XSSFWorkbook workbook= new XSSFWorkbook(Fis);
	 XSSFSheet sheet= workbook.getSheet("sheet 1");
	 Iterator<Row> row= sheet.rowIterator();
	 
	 while(row.hasNext())
	 {
		 Row currow=row.next();
		 Iterator<Cell> cell =currow.cellIterator();
		 while(cell.hasNext())
			 
		 {Cell curcel =cell.next();
		 System.out.print(curcel.getStringCellValue()+" ~ ");
		 }
		 System.out.println();
	 }
	 
			 }
}

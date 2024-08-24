package utility;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviderUtility  {
	
	@DataProvider (name = "getdata")
	public Object[][] getAllData() throws IOException
	{
	 //  String path = System.getProperty("user.dir") + "//userdata.xlsx";
		String path = "./src/test/resources/TestData/TestData.xlsx";
		String sheetName = "Sheet1";
	   
	   ExcelDataReader xl = new ExcelDataReader();
	   int rowcount = xl.getRowCount(path,sheetName );
	   int colcount = xl.cellRowCount(path,sheetName,1);

	   Object data[][] = new String[rowcount][colcount];
	   for(int i =1; i<rowcount;i++)
	   { 
	      for(int j=0; j<colcount; j++)
	       {
	         data[i][j] = xl.getCellData(path,sheetName,i,j);
	         System.out.println(data);
	       } 

	    }
	    return data;
	}

}

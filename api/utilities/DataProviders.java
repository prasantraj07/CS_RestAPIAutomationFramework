package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	
	//Double Array:
	
	@DataProvider(name="AllData")
	public String [][] AllDataProvider()
	{
		
		String fName = System.getProperty("user.dir")+"//TestData//API_TestData.xlsx";
		
		int ttlRowCount = ReadExcelFile.getRowCount(fName, "TestData"); //'TestData' is sheetname
		int ttlColCount = ReadExcelFile.getRowCount(fName, "TestData");
		
		String userData[][] = new String[ttlRowCount-1][ttlColCount];
		
		for(int rowNo = 1; rowNo<ttlRowCount; rowNo++)
		{ 
			for(int colNo = 0; colNo<ttlColCount; colNo++) 
			{
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "TestData", rowNo, colNo);
				
			}
		}
		
		return userData;
	}
	
	//Single Array:
	
	@DataProvider(name="UserNamesData")
	public String [] UserNamesDataProvider()
	{
		
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowCount = ReadExcelFile.getRowCount(fName, "Sheet1");
		//int ttlColCount = ReadExcelFile.getRowCount(fName, "Sheet1");
		
		String userNamesData[] = new String[ttlRowCount-1];
		
		for(int rowNo = 1; rowNo<ttlRowCount; rowNo++)
		{ 
			userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, 1);
		}
		
		return userNamesData;
	}

}

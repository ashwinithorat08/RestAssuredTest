package api.utilities;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testData\\UserData.xlsx";
		//String path="C:\\Users\\ashwini.thorat\\eclipse-workspace\\RestAssureTest\\testData\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String apiData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				apiData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return apiData;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testData\\UserData.xlsx";
		//String path="C:\\Users\\ashwini.thorat\\eclipse-workspace\\RestAssureTest\\testData\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int rownum=xlutil.getRowCount("Sheet1");
	
		String[] apiData=new String[rownum];
			
		
		for(int i=1;i<=rownum;i++) //1
		{
			
				apiData[i-1]=xlutil.getCellData("Sheet1",i,1);
				
		}
		
		return apiData;
	}

}

package Keyword_Engine;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Koneqto_Base.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Koneqto_Eng 
{
	public WebDriver dr;
	public Properties pr;
	public Sheet sh;
	public Workbook wb;
	public Base bs;
	public WebElement elmnt;
	
	public void start_Exce(String Sheet) throws BiffException, IOException
	{
		File f=new File("D:\\fb1.xls");
		wb=Workbook.getWorkbook(f);
		sh=wb.getSheet(0);
		int j=1;
		for(int i=1;i<sh.getRows();i++)
		{
			String locatorType=sh.getCell(j, i).getContents().trim();
			String locatorValue=sh.getCell(j+1, i).getContents().trim();
			String action=sh.getCell(j+2, i).getContents().trim();
			String value=sh.getCell(j+3, i).getContents().trim();
			
			switch (action) {
			
			case "open browser":
				bs=new Base();
				pr=bs.init_Prop();
				if(value.isEmpty() ||value.equals("NA"))
				{
					dr=bs.init_driver(pr.getProperty("chrome"));
					
				}else
				{
					dr=bs.init_driver(value);
				}				
				break;
			case "enter url":
				if(value.isEmpty() ||value.equals("NA"))
				{
					dr.get(pr.getProperty("url"));
				}
				else
				{
					dr.get(value);
				}
				break;
			case "close":
				dr.quit();
				break;
				
			default:
				break;
			}
			
			switch (locatorType) {
			case "id":
				elmnt =dr.findElement(By.id(locatorValue));
				if(action.equalsIgnoreCase("sendkeys"))
				{
					elmnt.clear();
					elmnt.sendKeys(value);
				}else if(action.equalsIgnoreCase("click"))
				{
				 elmnt.click();
				}
				
				
				break;

			default:
				break;
			}
			locatorValue=null;
			
		}
		
		
	}

}

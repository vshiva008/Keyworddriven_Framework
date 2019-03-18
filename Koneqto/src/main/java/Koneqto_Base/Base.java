package Koneqto_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public WebDriver dr;
	public Properties pr;
	
	public WebDriver init_driver(String browser) 
	{
		if(browser.equalsIgnoreCase("chrome"))
		
			/*if(pr.getProperty("headless").equals("yes"))
			{
				ChromeOptions op=new ChromeOptions();
				op.addArguments("--headless");
				dr= new ChromeDriver(op);
			}*/
		
			{
				dr= new ChromeDriver();
			}
		
		return dr;
			
	}
	
	public Properties init_Prop() throws IOException
	{
		pr=new Properties();
		try {
			FileInputStream fi=new FileInputStream("D:\\Shiva\\Koneqto\\src\\main\\java\\Configure\\config.properties");
			pr.load(fi);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}
	 
	
}

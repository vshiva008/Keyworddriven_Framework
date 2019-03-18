package Koneqto_Exe;

import java.io.IOException;

import org.testng.annotations.Test;

import Keyword_Engine.Koneqto_Eng;
import jxl.read.biff.BiffException;

public class Infobyt_Exc 
{
	public Koneqto_Eng kwe;
	@Test
	public void login() throws BiffException, IOException
	{
		kwe=new Koneqto_Eng();
		kwe.start_Exce("Login");
	}
}


package wdMethods;
import org.openqa.selenium.edge.EdgeDriver;


public class Ex1 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\MicrosoftWebDriver.exe");
		EdgeDriver d=new EdgeDriver();
		d.get("http://www.google.co.in");
		
	}

}

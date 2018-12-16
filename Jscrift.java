package chrome;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jscrift
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementsByName('q')[0].value='kalam';");
		//driver.executeScript("document.getElementsByName('q')[0].value='kalam';");
		

	}

}

package wdMethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex15
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("http://www.google.co.in");
		WebElement e=d.findElement(By.name("q"));
		d.executeScript("arguments[0].style.border='2px blue solid';",e);
		File src=d.getScreenshotAs(OutputType.FILE);
		File dest=new File("F://screen.png");
		FileUtils.copyFile(src,dest);
		Thread.sleep(5000);
		d.close();
	}	
}

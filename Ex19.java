package wdMethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ex19
{
	public static void main(String[] args)
	{
		ChromeDriver driver;
		try
		{
			System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://jqueryui.com/slider/");
			driver.switchTo().frame(0);
			WebElement e=driver.findElement(By.xpath("//*[@id='slider']/span"));
			Actions a=new Actions(driver);
			a.dragAndDropBy(e,100,0).build().perform();
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("f://slider.png");
			FileUtils.copyFile(src,dest);	
			a.dragAndDropBy(e,-100,0).build().perform();
			driver.switchTo().defaultContent();
			driver.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}

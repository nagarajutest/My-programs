package wdMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ex18
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver;
		try
		{
			System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			WebElement e=driver.findElement(By.xpath("//*[@id='draggable']/p"));
			WebElement e1=driver.findElement(By.xpath("//*[@id='droppable']"));
			Actions a=new Actions(driver);
			a.dragAndDrop(e, e1).build().perform();
			driver.switchTo().defaultContent();
			driver.close();
		}
		catch(Exception e)
		{
			
		}
		
	}

}

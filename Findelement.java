package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelement 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		
		try
		{
			WebElement e=driver.findElement(By.xpath("(//*[@id='oneway-trip-armForce'])[2]/following-sibling::*[1]"));
			if(e.isDisplayed())
			{
				if(e.isEnabled())
				{
					if(e.isSelected())
					{
				        System.out.println("selected");
			         }
			        else
			         {
				        System.out.println("not selected");
			         }
			     }
				else
				{
					System.out.println("not enabled");
				}
			}
				else
				{
					System.out.println("not displayed");
				}
		}
				
		catch(Exception ex)
		{
			System.out.println("exception");
		}
		


	}
}



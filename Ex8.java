package wdMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex8 
{
	public static void main(String[] args) 
	{
		// Launch Browser
		System.setProperty("webdriver.gecko.driver","G:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		FirefoxDriver d=new FirefoxDriver();
		d.get("https://www.skyscanner.co.in/airline/airline-indigo-6e.html");
		WebDriverWait w=new WebDriverWait(d,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class,'bpk-radio-29Pvv')])[1]/input")));
		WebElement e=d.findElement(By.xpath("(//*[contains(@class,'bpk-radio-29Pvv')])[1]/input"));
		
		/*if(e.isSelected())
		{
			System.out.println("Selected");
		}
		else
		{
			System.out.println("Not Selected");
		}*/
		
		try
		{
			if(e.isDisplayed())
			{
				if(e.isEnabled())
				{
					if(e.isSelected())
					{
						System.out.print("Is Selected");
					}
					else
					{
					System.out.println("Not Enabled");
					}
				}
				else
				{
				System.out.println("not Displayed");
				}
			}
			
		}
		catch(Exception e1)
		{
			System.out.println("Wrong Element");
		}
		d.close();
	}

}

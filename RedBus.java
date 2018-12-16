package test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBus 
{
	public static void main(String[] args) throws Exception
	{
		// Launch Browser
		 ChromeOptions ops = new ChromeOptions();
         ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver(ops);
		d.get("https://www.redbus.in/");
		WebDriverWait w=new WebDriverWait(d,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("src")));
		WebElement e=d.findElement(By.id("src"));
		Actions a=new Actions(d);
		a.sendKeys(e,"tan").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autoFill']")));
		List<WebElement> l=d.findElements(By.xpath("//*[@class='autoFill']/li"));
		int i=0;
		for(i=0;i<=l.size();i++)
			{
				try
				{
					String z=l.get(i).getText();
					if(z.equalsIgnoreCase("Tanguturu"))
					{
						a.sendKeys(Keys.ENTER).build().perform();
						break;
					}
					else
					{
						a.sendKeys(Keys.DOWN).build().perform();
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1.getMessage());
				}
			}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[2]")));
		WebElement e1=d.findElement(By.xpath("(//*[@type='text'])[2]"));
		a.sendKeys(e1,"hyd").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autoFill']")));
		List<WebElement> l1=d.findElements(By.xpath("//*[@class='autoFill']/li"));
		for(i=0;i<=l1.size();i++)
			{
				try
				{
					String z=l1.get(i).getText();
					if(z.equalsIgnoreCase("Hyderabad"))
					{
						a.sendKeys(Keys.ENTER).build().perform();
						break;
					}
					else
					{
						a.sendKeys(Keys.DOWN).build().perform();
					}
				}
				catch(Exception g)
				{
					System.out.println(g.getMessage());
				}
			}
		/*w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='onward_cal']")));
		WebElement e3=d.findElement(By.xpath("//*[@id='onward_cal']"));
		a.click(e3).build().perform();*/
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table/tbody)[2]")));
		WebElement e2=d.findElement(By.xpath("(//table/tbody)[2]/tr[7]/td[3]"));
		a.moveToElement(e2).click(e2).build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_btn")));
		d.findElement(By.id("search_btn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@src='http://origin-st.redbus.in/buslogos/country/ind/logo_group/10283.png']")));
		d.close();
	}

}

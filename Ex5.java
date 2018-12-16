package wdMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex5 
{
	public static void main(String[] args) throws Exception
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver","D:\\New folder\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		
		//Launch Site
		
		d.get("https://www.redbus.in/");
		WebDriverWait w=new WebDriverWait(d,100);
		Actions a=new Actions(d);
		WebElement e=d.findElement(By.xpath("//*[@data-message='Please enter a source city']"));
		a.sendKeys(e,"g").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autoFill']/li")));
		//d.findElement(By.xpath("//*[@class='autoFill']/li"));
		List<WebElement> l=d.findElements(By.xpath("//*[@class='autoFill']/li"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
			String z=l.get(i).getText();
			if(z.equalsIgnoreCase("guwahati"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				break;
			}
			else
			{
				a.sendKeys(Keys.DOWN).build().perform();
			}
		}
		
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-message='Please enter a destination city']")));
		WebElement e2=d.findElement(By.xpath("//input[@id='dest']"));
		a.sendKeys(e2,"hy").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autoFill']/li")));
		List<WebElement> l2=d.findElements(By.xpath("//*[@class='autoFill']/li"));
		System.out.println(l2.size());
		for(int j=0;j<l.size();j++)
		{
			System.out.println(l2.get(j).getText());
			String z=l2.get(j).getText();
			if(z.equalsIgnoreCase("hyderabad"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				break;
				
			}
			else
			{
				a.sendKeys(Keys.DOWN).build().perform();
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Onward Date']")));
		WebElement e1=d.findElement(By.xpath("//*[text()='Onward Date']"));
		d.executeScript("arguments[0].click();", e1);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]/tbody/tr[7]/td[2]")));
		WebElement e3=d.findElement(By.xpath("(//table)[2]/tbody/tr[7]/td[4]"));
		//d.executeScript("arguments[0].click();",e3);
		Thread.sleep(8000);
		a.moveToElement(e3).click().build().perform();
		d.findElement(By.xpath("//*[text()='Search Buses']")).click();
		d.close();

	}

}

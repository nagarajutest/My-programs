package wdMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datepicker 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("https://jqueryui.com/datepicker/");
		WebDriverWait wait=new WebDriverWait(d,20);
		d.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='hasDatepicker']")));
		d.findElement(By.xpath("//input[@class='hasDatepicker']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));
		String x=d.findElement(By.xpath("//span[text()='October']")).getText();
		String y=d.findElement(By.xpath("//span[text()='2018']")).getText();
		System.out.println(x+" "+y);
		
		while(2>1)
		{
			try
			{
				String m=d.findElement(By.xpath("//span[text()='October']")).getText();
				String n=d.findElement(By.xpath("//span[text()='2017']")).getText();
				if(n.contains("2017")&&m.contains("October"))
				{
					break;
				}
			}			
			catch(Exception e)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Prev']")));
				d.findElement(By.xpath("//span[text()='Prev']")).click();
			}
		}
		while(2>1)
		{
			try
			{
				String m=d.findElement(By.xpath("//span[text()='October']")).getText();
				String n=d.findElement(By.xpath("//span[text()='2018']")).getText();
				if(n.contains("2018")&&m.contains("October"))
				{
					break;
				}
			}			
			catch(Exception e)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
				d.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		d.switchTo().defaultContent();
		d.close();
	}

}

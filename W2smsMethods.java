package w2sms;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W2smsMethods 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public String launch(String a,String b, String c)
	{
		if(a.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("WebDriver.gecko.driver","G:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(b);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		return("Done");
	}
	public String fill(String a,String b,String c)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(a)));
		driver.findElement(By.xpath(a)).sendKeys(b);
		return("Done");
	}
	public String Click(String a,String b,String c)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(a)));
		driver.findElement(By.xpath(a)).click();
		return("Done");
	}
	public String click(String a,String b,String c)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(a)));
		driver.findElement(By.xpath(a)).click();
		return("Done");
	}
	public String validateLogin(String a,String b,String c) throws Exception
	{
		try
		{
			if(c.equalsIgnoreCase("All Valid")&&wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='toMobile']"))).isDisplayed())
			{
				return("Passed");
			}
			else
			{
				String temp=this.screenshot();
				return("Test Failed & Goto"+temp+".png");
			}
		}
		catch(Exception ex)
		{
			String temp=this.screenshot();
			return("Test Interupted & Goto"+temp+".png");
		}
	}
	public String closesite(String a,String b,String c)
	{
		driver.close();
		return("done");
	}
	public String screenshot() throws Exception
	{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String ssname=sf.format(d);
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(ssname+".png");
		FileUtils.copyFile(src,dest);
		return("ssname");
		
	}

}

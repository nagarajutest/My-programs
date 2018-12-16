package test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GooglePagenation 
{
	public static void main(String[] args) throws Exception 
	{
		ExtentReports er=new ExtentReports("google.html",false);
		ExtentTest et=er.startTest("Google Pagenation");
		
		
		//Take a Word From The Keyboard
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Word");
		String x=sc.nextLine();
		
		// Launch Browser----------------------------------------------------
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
				
		//Launch Google Site--------------------------------------------------
		
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		String y=driver.getTitle();
		int flag=0;
		while(2>1)
		{
			if(!y.contains(x))
			{
				flag=1;
				break;
			}
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				break;
			}
		}
		if(flag==0)
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
			Date d=new Date();
			String ssname=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileUtils.copyFile(src, dest);
			et.log(LogStatus.PASS,"Test Passed"+et.addScreenCapture(ssname+".png"));
		}
		else
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy=hh-mm-ss");
			Date d=new Date();
			String ssname=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.FAIL,"Test Failed"+et.addScreenCapture(ssname+".png"));
		}
		driver.close();
		er.endTest(et);
		er.flush();
	}

}

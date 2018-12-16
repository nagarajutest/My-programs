package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Way2smsLogin 
{
	public static void main(String[] args) throws Exception 
	{
		
		//Take Values From Keyboard---------------------------------------------------------
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Mobile Number");
		String mno=sc.nextLine();
		System.out.println("Enter Number Criteria");
		String mnoc=sc.nextLine();
		System.out.println("Enter Password");
		String p=sc.nextLine();
		System.out.println("Enter Mobile Number Criteria");
		String pc=sc.nextLine();
		
		//Create Html Result File---------------------------------------------------------
		
		ExtentReports er=new ExtentReports("Way2sms.html",false);
		ExtentTest et=er.startTest("Way2sms Login Scenario Tested");
		
		//Launch Browser---------------------------------------------------------------------
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		//Launch Site------------------------------------------------------------------------
		
		driver.get("http://www.way2sms.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		
		//Validate Login Scenario------------------------------------------------------------
		
		driver.findElement(By.name("mobileNo")).sendKeys(mno);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(p);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Login')])[2]")));
		driver.findElement(By.xpath("(//*[contains(text(),'Login')])[2]")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
		try
		{
			if(mno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Mobile Number Blank");
			}
			else if(mno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Mobile Number Length Lessthan 10");
			}
			else if(mnoc.equalsIgnoreCase("valid")&&p.length()==0&&driver.findElement(By.xpath("(//b[text()='Enter password'])[2]")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Mobile Number Valid & Password Blank");
			}
			else if(mnoc.equalsIgnoreCase("valid")&&pc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Incorrect number or password! Try Again.']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Mobile Number Valid & Password Invalid");
			}
			else if(mnoc.equalsIgnoreCase("valid")&&pc.equalsIgnoreCase("valid")&&w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']"))).isDisplayed())
			{
				et.log(LogStatus.PASS,"Mobile Number Valid & Password valid");
			}
			else
			{

				SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
				Date d=new Date();
				String login=sf.format(d);
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(login+".png");
				FileUtils.copyFile(src, dest);
				et.log(LogStatus.FAIL,"Login Scenario Failed"+et.addScreenCapture(login+".png"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
			Date d=new Date();
			String login=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(login+".png");
			FileUtils.copyFile(src, dest);
			et.log(LogStatus.ERROR,"Error Occured"+et.addScreenCapture(login+".png"));
		}
		//Close Site----------------------------------------------------------------------------
		
		driver.close();
		er.endTest(et);
		er.flush();
	}

}

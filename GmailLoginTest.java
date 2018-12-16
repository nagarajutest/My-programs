package test;

import java.io.File;
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

public class GmailLoginTest
{
	public static void main(String[] args) throws Exception 
	{
		// Values Taken From KeyBoard---------------------------------------------------
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id");
		String u=sc.nextLine();
		System.out.println("Enter UserID Criteria");
		String uc=sc.nextLine();
		String p="";
		String pc="";
		if(uc.equalsIgnoreCase("valid"))
		{
			System.out.println("Enter Password");
			p=sc.nextLine();
			System.out.println("Enter Password Criteria");
			pc=sc.nextLine();
		}
		
		//Create Html Results----------------------------------------------------------------
		
		ExtentReports er=new ExtentReports("GmailLogin.html",false);
		ExtentTest et=er.startTest("Gmail Login Test");
		
		//Launch Browser & Launch Site-------------------------------------------------------
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		
		//Gmail Login-----------------------------------------------------------------------
		
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys(u);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		
		//Validations ------------------------------------------------------------
		
		try
		{
			//User Id Testing--------------------------------------------------------
			
			if(u.length()==0 && driver.findElement(By.xpath("//*[text()='Enter an email or phone number']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Blank Mobile Number Test Passed");
			}
			else if(uc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("(//*[contains(text(),'find your Google Account')])[2]")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid UserId Test Passed");
			}
			else if(uc.equalsIgnoreCase("valid")&&w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).isDisplayed())
			{
				driver.findElement(By.name("password")).sendKeys(p);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Promotions']")));
			
			//Gmail Password Testing-----------------------------------------------------------------
			
				if(p.length()==0&&driver.findElement(By.name("//*[text()='Enter a password']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank Password Test Passed");
				}
				else if(pc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[contains(text(),'Wrong password.')]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Invalid Password Test Passed");
				}
				else if(pc.equalsIgnoreCase("valid")&&w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Promotions']"))).isDisplayed())
				{
					et.log(LogStatus.PASS,"Valid Password Test Passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
					Date d=new Date();
					String Glogin=sf.format(d);
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(Glogin+".png");
					FileUtils.copyFile(src,dest);
					et.log(LogStatus.FAIL,"Gmail Password Test Failed"+et.addScreenCapture(Glogin+".png"));
				}
			}
			else
			{
				SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
				Date d=new Date();
				String Glogin=sf.format(d);
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(Glogin+".png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.FAIL,"Gmail UserId Test Failed"+et.addScreenCapture(Glogin+".png"));
			}
		}
		catch(Exception e)
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
			Date d=new Date();
			String Glogin=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(Glogin+".png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.ERROR,"Gmail Login Test Interrupted"+et.addScreenCapture(Glogin+".png"));
		}
		
		//Close Site----------------------------------------------------------------------
		
		driver.close();
		
		//Save And Close Results----------------------------------------------------------
		
		er.endTest(et);
		er.flush();
	}
}

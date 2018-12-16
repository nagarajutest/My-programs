package wdMethods;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Ex6 
{
	public static void main(String[] args)
	{
		// Launch Browser
		WebDriver driver=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser Name");
		String x=sc.nextLine();
		System.out.println("Enter User Id");
		String y=sc.nextLine();
		System.out.println("Enter Password");
		String z=sc.nextLine();
		if(x.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(x.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files\\Opera\\54.0.2952.51\\opera.exe");
			System.setProperty("webdriver.opera.driver","C:\\Selenium\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver(o);
		}
		else
		{
		System.out.print("Browser not found");	
		System.exit(0);
		}
		//Launch Site
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement e=driver.findElement(By.name("identifier"));
		e.sendKeys(y);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		WebElement e1=driver.findElement(By.name("password"));
		e1.sendKeys(z);
		driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
	}

}

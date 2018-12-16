package wdMethods;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Act1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch Browser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser");
		String x=sc.nextLine();
		System.out.println("enter a word");
		String l=sc.nextLine();
		System.out.println("Suggest word");
		String m=sc.nextLine();
		WebDriver driver=null;
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
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.sendKeys(e,l).build().perform();
		int c=0;
		Thread.sleep(5000);
		while(2>1)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			c=c+1;
			String y=e.getAttribute("value");
			System.out.println(y);
			if(y.equals(m))
			{
				System.out.println("Item Was Found At" +c);
				a.sendKeys(Keys.ENTER).build().perform();
				break;
			}
			if(c==0)
			{
				System.out.println("Item Was Not Found");
				break;
			}
			
			
		}
		driver.close();
		

	}

}

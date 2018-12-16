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

public class Example1 
{
	public static void main(String[] args) throws Exception ,IndexOutOfBoundsException
	{
		//Launch Site
		WebDriver driver=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser Name");
		String x=sc.nextLine();
		
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
		Thread.sleep(5000);
		//Launch Site
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement e=driver.findElement(By.name("q"));
		System.out.print("Enter a Word");
		String y=sc.nextLine();
		e.sendKeys(y);
		System.out.println("Enter Suggestion Word");
		String m=sc.nextLine();
		List<WebElement>l=driver.findElements(By.xpath("//*[text()='kalam']"));
		System.out.println(l.size());
		e.clear();
		Actions a=new Actions(driver);
		a.sendKeys(e,y).build().perform();
		int c=0;
		while(2>1)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			c=c+1;
			String z=e.getAttribute("value");
			if(z.equals(m))
			{
				a.sendKeys(Keys.ENTER).build().perform();	
				break;
			}
			if(c==0)
			{
				break;
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}

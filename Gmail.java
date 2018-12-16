package wdMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail 
{
	public static void main(String[] args) throws InterruptedException, AWTException
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
		WebDriverWait w=new WebDriverWait(driver,100);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[6]/tbody/tr")));
		/*List<WebElement> l=driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
		System.out.println(l.size());
		driver.findElement(By.xpath("(//*[@class='aKw'])[3]")).click();
		List<WebElement>l2=driver.findElements(By.xpath("(//table)[7]/tbody/tr"));
		System.out.println(l2.size());
		/*for(int i=1;i<=l2.size();i++)
		{
			driver.findElement(By.xpath("(//table)[7]/tbody/tr["+i+"]/td[2]/div")).click();
		}
		driver.findElement(By.xpath("//*[@gh='mtb']/div/div/child::div[2]/child::div[3]/div")).click();*/
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='aKw'])[3]")));
		driver.findElement(By.xpath("(//*[@class='aKw'])[3]")).click();
		List<WebElement>l3=driver.findElements(By.xpath("(//table)[6]/tbody/tr/td[6]/span[1]/img[1]"));
		System.out.println(l3.size());
		for(int i=1;i<=l3.size();i++)
		{
			driver.findElement(By.xpath("(//table)[6]/tbody/tr["+i+"]/td[6]/span[1]/img[1]")).click();
		}
		
		//Compose Mail
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='COMPOSE']")));
		driver.findElement(By.xpath("//*[text()='COMPOSE']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		driver.findElement(By.name("to")).sendKeys("tanneerunagarajurise@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("hi");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("how r u");
		
		//Attach File
		
		driver.findElement(By.xpath("//*[@aria-label='Attach files']/descendant::*[3]")).click();
		Thread.sleep(5000);
		
		//Path Copied To Clipboard
		
		StringSelection s=new StringSelection("C:\\Users\\Nagaraj\\Downloads\\20180527_100429 (1).jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		Robot r=new Robot();
		
		//Path Taken From ClipBoard
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Attachment')]")));
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your message has been')]")));
		
		//Logout
		
		driver.findElement(By.xpath("//*[contains(@title,'Google')]/span")).click();
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		
		//Close Site
		
		driver.close();
	}

}

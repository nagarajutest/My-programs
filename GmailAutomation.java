package firefox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailAutomation 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//Launch Site
		
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.get("https://www.google.com/gmail/about/");
		
		//Login
		
		driver.findElement(By.xpath("(//*[contains(@class,'gmail-nav')])[6]")).click();
		driver.findElement(By.id("identifierId")).sendKeys("tanneerunagarajurise");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("9704197258");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		
		//Total Count Of Rows In Table
		
		List<WebElement> l=driver.findElements(By.xpath("(//table/tbody)[6]/tr"));
		System.out.println("count table rows"+l.size());
		
		//Total Count Of Columns In Table
		
		List<WebElement> l2=driver.findElements(By.xpath("(//table)[6]/tbody/tr[1]/td"));
		System.out.println(l2.size());
		
		//List Of Column Elements
		
		for(int i=0;i<l2.size();i++)
		{
			String x=l2.get(i).getText();
			System.out.println(x);
		}
		//Delete Mail 
		
		driver.findElement(By.xpath("(//table)[6]/tbody/tr[1]/td[2]/div")).click();
		driver.findElement(By.xpath("//*[@gh='mtb']/div/div/child::div/div[3]/child::div/div")).click();
		System.out.println("deleted");
		
		//Logout
		driver.findElement(By.xpath("//*[contains(@title,'Google')]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		driver.close();
		

	}

}

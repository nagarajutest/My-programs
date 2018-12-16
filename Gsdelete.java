package firefox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gsdelete 
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
		Thread.sleep(11000);
		
		//Get No Of Rows
		
		driver.findElement(By.xpath("(//*[@class='aKw'])[3]")).click();
		List<WebElement> l2=driver.findElements(By.xpath("(//table)[8]/tbody/tr"));
		System.out.println(l2.size());
		
		//Delete promotion Mail
		
		/*driver.findElement(By.xpath("(//table)[8]/tbody/tr[1]/td[2]/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@gh='mtb']/div/div/child::div[2]/child::div[3]")).click();
		System.out.println("deleted");*/			
		//Delete All Promotion Mails
		
		Thread.sleep(11000);
		//try 
			//{
				for(int i=1;i<=l2.size();i++)
					{
						driver.findElement(By.xpath("(//table)[8]/tbody/tr["+i+"]/td[2]/div")).click();
			
					}
				Thread.sleep(11000);
		
						driver.findElement(By.xpath("//*[@gh='mtb']/div/div/child::div[2]/child::div[3]")).click();
						System.out.println("deleted");
			//}
		/*catch(Exception e)
		{
			System.out.println("No one Deleted");
		}*/
		//Logout
		
		driver.findElement(By.xpath("//*[contains(@title,'Google')]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		
		//Close Site
		
		driver.close();

	}

}

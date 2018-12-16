package chrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPagenation 
{
	public static void main(String[] args) throws Exception
	{
		// Launch Browser----------------------------------------------------
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		//Launch Gmail Site--------------------------------------------------
		
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
		driver.findElement(By.name("identifier")).sendKeys("kalikivayisivannarayana");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("8096540750");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Promotions']")));
		driver.findElement(By.xpath("//div[text()='Promotions']")).click();
		
		//PageNation----------------------------------
		
		int norm=0;
		while(2>1)
		{
			WebElement e=driver.findElement(By.xpath("(//table)[5]"));
			w.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(e)));
			List<WebElement> l=driver.findElements(By.xpath("(//table)[5]/tbody/tr"));
			System.out.println(l.size());
			for(int i=1;i<=l.size();i++)
			{
				w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//table)[5]/tbody/tr["+i+"]/td[5]")));
				String x=driver.findElement(By.xpath("(//table)[5]/tbody/tr["+i+"]/td[5]")).getText();
				//List<WebElement> cl=l.get(i).findElements(By.tagName("td"));
				//String x=cl.get(5).getText();
				if(x.equalsIgnoreCase("ace2three"))
				{
					norm=norm+1;
				}
			}
			try
			{
				if(driver.findElement(By.xpath("//div[@aria-label='Older']")).getAttribute("aria-disabled").equals("true"))
				{
					break;
				}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//div[@aria-label='Older']")).click();
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
			}
		}
		System.out.println(norm);
		
		//Logout-----------------------------------------------------
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@aria-label,'Google Account:')]/span")));
		driver.findElement(By.xpath("//a[contains(@aria-label,'Google Account:')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		driver.close();
		
	}

}

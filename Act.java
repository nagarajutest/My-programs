package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Act
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(d,100);
		d.get("http://www.google.co.in");
		d.manage().window().maximize();
		Actions a=new Actions(d);
		WebElement e=d.findElement(By.name("q"));
		a.sendKeys(e,"kalamkari").build().perform();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sbsb_b']")));
		int c=0;
		while(2>1)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			c=c+1;
			String x=e.getAttribute("value");
			if(x.equals("kalamkari saree"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				break;
				
			}
			if(c==10)
			{
				break;
			}
		}
		
		d.close();

	}

}

package chrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDown 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch Site
		System.setProperty("webdriver.gecko.driver","C:\\\\Selenium\\\\geckodriver-v0.20.1-win64\\\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("(//*[@class='ui dropdown'])[1]"));
		a.click(e).build().perform();
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.xpath("//*[@class='menu transition visible']/div"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		driver.findElement(By.xpath("//*[@class='menu transition visible']/div[4]")).click();
		driver.close();

	}

}

package firefox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DropDown1
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch Site
				System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
				FirefoxDriver driver=new FirefoxDriver();
				driver.get("https://semantic-ui.com/modules/dropdown.html");
				//Actions a=new Actions(driver);
				//Thread.sleep(5000);
				//WebElement e=
				driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
				//a.click(e).build().perform();
				List<WebElement> l=driver.findElements(By.xpath("//*[@class='menu transition visible']/div"));
				Thread.sleep(5000);
				System.out.println(l.size());
				for(int i=0;i<l.size();i++)
				{
					System.out.println(l.get(i).getText());
				}
				driver.findElement(By.xpath("(//*[text()='Angular'])[2]")).click();
				driver.findElement(By.xpath("(//*[text()='CSS'])[2]")).click();
				driver.findElement(By.xpath("(//*[text()='Graphic Design'])[2]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple active visible'or@class='ui fluid dropdown selection multiple upward active visible']/a[1]/i")).click();
				Thread.sleep(5000);
				driver.close();
	}

}

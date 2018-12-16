package wdMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex3 
{
	public static void main(String[] args) 
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait w=new WebDriverWait(d,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui fluid dropdown selection multiple']")));
		d.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='menu transition visible']/div")));
		List<WebElement> l=d.findElements(By.xpath("//*[@class='menu transition visible']/div"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		l.get(1).click();
		l.get(2).click();
		l.get(3).click();
		d.findElement(By.xpath("((//*[@class='ui label transition visible'])[2]/i)|(//*[contains(@class,'multiple upward active visible')]/a[2])")).click();
		d.close();
		

	}

}

package wdMethods;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex2
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\MicrosoftWebDriver.exe");
		EdgeDriver d=new EdgeDriver();
		d.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait w=new WebDriverWait(d,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='ui dropdown'])[1]")));
		d.findElement(By.xpath("(//*[@class='ui dropdown'])[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='ui dropdown active visible']/child::i/following-sibling::div/div)|(//*[@class='ui dropdown upward active visible']/child::i/following-sibling::div/div)")));
		List<WebElement> l=d.findElements(By.xpath("(//*[@class='ui dropdown active visible']/child::i/following-sibling::div/div)|(//*[@class='ui dropdown upward active visible']/child::i/following-sibling::div/div)"));
		System.out.println(l.size());
		Thread.sleep(5000);
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		d.close();

	}

}

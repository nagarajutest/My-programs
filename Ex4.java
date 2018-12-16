package wdMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex4
{
	public static void main(String[] args) 
	{
		// Launch browser
				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				ChromeDriver d=new ChromeDriver();
				d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
				WebDriverWait w=new WebDriverWait(d,100);
				d.switchTo().frame(1);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contenteditable='false']/select")));
				WebElement e=d.findElement(By.xpath("//*[@contenteditable='false']/select"));
				Select s=new Select(e);
				List<WebElement> l=s.getOptions();
				System.out.println(l.size());
				for(int i=0;i<l.size();i++)
				{
					System.out.println(l.get(i).getText());
				}
				e.click();
				s.selectByIndex(2);
				d.switchTo().defaultContent();
				d.close();

	}

}

package chrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Collections
{
	public static void main(String[] args) 
	{
		//launch site
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		List<WebElement> l= driver.findElements(By.tagName("img"));
		System.out.println(l.size());
		int vi=0;
		int hi=0;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).isDisplayed())
			{
			vi=vi+1;
			}
			else
			{
				hi=hi+1;
			}
		}
		System.out.println("visible image count is"+vi);
		System.out.println("hidden images count is"+hi);
		driver.close();

	}

}

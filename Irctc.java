package chrome;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Irctc 
{
	public static void main(String[] args) 
	{
		// Launch Browser
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.irctc.co.in");
		WebDriverWait w=new WebDriverWait(driver,100);
		driver.close();
	}

}

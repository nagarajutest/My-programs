package chrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
		//validate cookies
		if(driver.manage().getCookies().size()!=0)
		{	
			System.out.println("cookies were loaded");
		}
		else
		{
			System.out.println("cookies were not loaded");
		}
		
		driver.close();

	}

}

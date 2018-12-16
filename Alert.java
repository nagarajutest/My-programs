package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html?");
		driver.findElement(By.name("password")).sendKeys("9704197258");
		driver.findElement(By.id("loginBTN")).click();
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.name("password")).clear();
		System.out.println("clear the text field");
		Thread.sleep(5000);
		driver.switchTo().activeElement().sendKeys("9704197258");
		Thread.sleep(5000);
		driver.close();
		

	}

}

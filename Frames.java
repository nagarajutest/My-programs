package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//launch site
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html?");
		//findElement().sendkeys(),click(),
		driver.findElement(By.name("username")).sendKeys("9100748987");
		driver.findElement(By.name("password")).sendKeys("9704197258");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Send SMS']")).click();
		Thread.sleep(5000);
		//By Using Frames
		driver.switchTo().frame("frame");
		driver.findElement(By.name("mobile")).sendKeys("9505265205");
		driver.findElement(By.name("message")).sendKeys("nagaraju");
		driver.findElement(By.name("Send")).click();
		driver.switchTo().defaultContent();
		//driver.findElement(By.xpath("//i[@class='chati homei']")).click();
		//driver.findElement(By.xpath("//*[@class='out louti']")).click();
		//driver.close();
		

	}

}

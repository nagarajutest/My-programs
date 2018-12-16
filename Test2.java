package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2
{

	public static void main(String[] args) throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.way2sms.com/content/index.html?");
	String x=driver.getTitle();
	System.out.println(x);
	String x1=driver.getCurrentUrl();
	System.out.println(x1);
	if(x1.contains("https"))
	{
		System.out.println("secured");
	}
	else
	{
		System.out.println("not secured");
	}
	driver.findElement(By.name("username")).sendKeys("9100748987");
	driver.findElement(By.name("password")).sendKeys("9704197258");
	driver.findElement(By.id("loginBTN")).click();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//*[text()='Send SMS']")).click();
	//Thread.sleep(5000);
	//driver.switchTo().frame("frame");
	//driver.findElement(By.name("mobile")).sendKeys("9505265205");
	//driver.findElement(By.name("message")).sendKeys("hi");
	//driver.findElement(By.name("Send")).click();
	//driver.switchTo().defaultContent();
	//driver.findElement(By.xpath("//i[@class='chati homei']")).click();
	driver.findElement(By.xpath("//*[@class='out louti']")).click();
	driver.close();
	}

}

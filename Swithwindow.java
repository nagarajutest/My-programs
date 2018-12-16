package chrome;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swithwindow 
{

	public static void main(String[] args) throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");	
    WebDriver driver=new ChromeDriver();
    driver.get("http://www.way2sms.com/content/index.html?");
    driver.findElement(By.xpath("//*[@src='../images/android-button.png']")).click();
    Thread.sleep(5000);
    ArrayList<String> x=new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(x.get(1));
    driver.findElement(By.name("q")).sendKeys("games");
    driver.quit();
	}

}

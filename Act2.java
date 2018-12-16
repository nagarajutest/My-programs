package chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Act2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("http://jqueryui.com/droppable/");
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		WebElement e=d.findElement(By.id("draggable"));
		WebElement e1=d.findElement(By.id("droppable"));
		a.dragAndDrop(e,e1).build().perform();
		Thread.sleep(5000);
		d.switchTo().defaultContent();
		d.close();

	}

}

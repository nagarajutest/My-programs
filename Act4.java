package chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Act4 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("http://jqueryui.com/slider/");
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		d.switchTo().frame(0);
		WebElement e=d.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		Actions a=new Actions(d);
		a.dragAndDropBy(e,150,0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e,-100,0).build().perform();
		Thread.sleep(5000);
		d.switchTo().defaultContent();
		d.findElement(By.linkText("Vertical slider")).click();
		d.switchTo().frame(0);
		Thread.sleep(5000);
		WebElement e1=d.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		a.dragAndDropBy(e1,0,100).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1,0,-100).build().perform();
		Thread.sleep(5000);
		d.switchTo().defaultContent();
		d.close();
		

	}

}

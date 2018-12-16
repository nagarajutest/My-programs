package wdMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex9
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Enter User Id");
		Scanner sc=new Scanner(System.in);
		String x=sc.nextLine();
		System.out.println("Enter Password");
		String y=sc.nextLine();
		
		// Launch Browser
		System.setProperty("webdriver.gecko.driver","G:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		FirefoxDriver d=new FirefoxDriver();
		d.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(d,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		d.findElement(By.name("identifier")).clear();
		d.findElement(By.name("identifier")).sendKeys(x);
		d.findElement(By.xpath("(//*[@class='CwaK9'])[3]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		d.findElement(By.name("password")).clear();
		d.findElement(By.name("password")).sendKeys(y);
		d.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='COMPOSE']")));
		d.findElement(By.xpath("//*[text()='COMPOSE']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		d.findElement(By.name("to")).sendKeys("naveenbadshaa@gmail.com");
		Robot r=new Robot();
		//WebElement e=d.findElement(By.xpath("//*[@class='ao5']"));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("subjectbox")));
		d.findElement(By.name("subjectbox")).sendKeys("hi");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-label='Message Body'])[2]")));
		d.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("hi");
		d.findElement(By.xpath("//*[@aria-label='Attach files']/descendant::*[3]")).click();
		StringSelection s=new StringSelection("C:\\Users\\Nagaraj\\Downloads\\20180527_100429.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Attachment')]")));
		d.findElement(By.xpath("//*[text()='Send']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your message has been sent')]")));
		d.findElement(By.xpath("//*[contains(@title,'Google Account')] /span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']")));
		d.findElement(By.xpath("//*[text()='Sign out']")).click();
		d.close();

	}

}

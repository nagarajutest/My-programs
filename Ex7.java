package wdMethods;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex7 
{
	public static void main(String[] args) 
	{
		//Launch Browser
		System.out.println("Enter User Id");
		Scanner s=new Scanner(System.in);
		String x=s.nextLine();
		System.out.println("Enter Password");
		String y=s.nextLine();
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(d,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		d.findElement(By.name("identifier")).clear();
		d.findElement(By.name("identifier")).sendKeys(x);
		d.findElement(By.xpath("(//*[@class='CwaK9'])[3]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		d.findElement(By.name("password")).clear();
		d.findElement(By.name("password")).sendKeys(y);
		d.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='T-Jo-auh']")));
		d.findElement(By.xpath("//*[@class='T-Jo-auh']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Delete']/div/div")));
		d.findElement(By.xpath("//*[@aria-label='Delete']/div/div")).click();
		d.findElement(By.xpath("//*[contains(@title,'Google Account')] /span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']")));
		d.findElement(By.xpath("//*[text()='Sign out']")).click();
		d.close();

	}

}

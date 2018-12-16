package firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Getmethods 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.google.co.in");
				
		//Using getTitle()
				
		String x=driver.getTitle();
		System.out.println(x);
	    		
		//Using getCurrentUrl()
		
		String x1=driver.getCurrentUrl();
		System.out.println(x1);
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		//Using getAttribute()
		
		String x2=driver.findElement(By.name("q")).getAttribute("autocomplete");
		System.out.println(x2);
		
		//Using clear()
		
		driver.findElement(By.name("q")).clear();
		Thread.sleep(5000);
		driver.close();

	}

}

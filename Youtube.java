package wdMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Youtube 
	{
		public static void main(String[] args) throws Exception
		{
			//Launch Browser
			
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			
			//Launch Site (SWD)
			
			driver.get("http://www.youtube.com");
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
			driver.findElement(By.name("search_query")).sendKeys("Abdul Kalam speeches");
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-label='Search'])[3]")));
			driver.findElement(By.xpath("(//*[@aria-label='Search'])[3]")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Abdul Kalam in European Parliament')]")));
			driver.findElement(By.xpath("//*[contains(text(),'Abdul Kalam in European Parliament')]")).click();
			//Video Automation (By Using SIKULIX)
			Screen s=new Screen();
			Location l=new Location(300,300);
			Thread.sleep(5000);
			s.wheel(l,Button.LEFT,0);
			s.click("Pause.png");
			Thread.sleep(5000);
			s.wheel(l,Button.LEFT,0);
			s.click("play.png");
			Thread.sleep(5000);
			s.wheel(l,Button.LEFT,0);
			s.mouseMove("Volume.png");
			Thread.sleep(5000);
			Match e=s.find("Slider.png");
			int x=e.getX();
			int y=e.getY();
			Location e1=new Location(x-50,y);
			s.dragDrop(e,e1);
			Thread.sleep(5000);
			Location e2=new Location(x+50,y);
			s.dragDrop(e,e2);
		
			driver.close();
		}
	}

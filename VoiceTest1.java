package chrome;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Handler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class VoiceTest1 {

	public static void main(String[] args) throws InterruptedException, Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		/* ChromeOptions options=new ChromeOptions();
	        Map<String, Object> prefs=new HashMap<String,Object>();
	        prefs.put("profile.default_content_setting_values.notifications", 1);
	        //1-Allow, 2-Block, 0-default
	        options.setExperimentalOption("prefs",prefs);
	        WebDriver driver=new ChromeDriver(options);*/
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='gsst_a']/span")).click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		/*Set<String>h=driver.getWindowHandles();
		Iterator<String>it=h.iterator();
		String ParentWindowId=it.next();
		String ChildWindowId=it.next();
		driver.switchTo().window(ChildWindowId);
		driver.close();*/
		//Thread.sleep(1000);
		try
		{

		    FileInputStream fis = new FileInputStream("hello1.mp3");
		    Player player = new Player(fis);
		    player.play();
		    System.out.println("Song is Playing");
		    }
		catch(FileNotFoundException e)
			{
			e.printStackTrace();
		    }
		catch(JavaLayerException e)
		{
			e.printStackTrace();
		}
		}
	}



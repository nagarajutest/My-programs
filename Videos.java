package gestures;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Videos 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\New folder\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://www.youtube.com");
		WebDriverWait w=new WebDriverWait(d,20);
		w.until(ExpectedConditions.elementToBeClickable(By.name("search_query")));
		d.findElement(By.name("search_query")).sendKeys("maharshi teaser");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-label='Search'])[3]")));
		d.findElement(By.xpath("(//*[@aria-label='Search'])[3]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@title,'#MeetRishi - Maharshi Teaser')])[1]")));
		d.findElement(By.xpath("(//*[contains(@title,'#MeetRishi - Maharshi Teaser')])[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title style-scope ytd-video-primary-info-renderer']")));
		Location l=new Location(300,300);
		Screen s=new Screen();
		s.wheel(l,Button.LEFT,0);
		if(s.exists("Skip.png")!=null)
		{
			s.click("Skip.png");
		}
		Thread.sleep(1000);
		s.wheel(l,Button.LEFT,0);
		s.click("pause.png");
		Thread.sleep(1000);
		s.wheel(l, Button.LEFT,0);
		s.click("play.png");
		Thread.sleep(1000);
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("volume.png");
		Match e=s.find("buble.png");
		int x=e.getX();
		int y=e.getY();
		Location e1=new Location(x-50,y);
		s.dragDrop(e,e1);
		Thread.sleep(1000);
		Location e2=new Location(x+50,y);
		s.dragDrop(e,e2);
		d.close();
	}

}

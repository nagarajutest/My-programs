package gestures;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GetText 
{
	public static void main(String[] args) throws Exception 
	{

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","AIGANZYLZLZDU8HQ");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","");
		dc.setCapability("appPackage","com.lenovo.ideafriend");
		dc.setCapability("appActivity","com.lenovo.ideafriend.alias.MmsActivity");
		dc.setCapability("autoGrantPermissions",true);
		
		//Start Appium Server And App
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver driver;
		
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		WebDriverWait wa=new WebDriverWait(driver,20);
		try
		{
			TouchAction ta=new TouchAction(driver);
			TapOptions to=new TapOptions();
			
			wa.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.LinearLayout'][@index='0']")));
			while(2>1)
			{				
				try
				{	
					WebElement wl=driver.findElement(By.xpath("//*[@bounds='[0,1376][1080,1556]']"));
					int x=wl.getLocation().getX();
					int y=wl.getLocation().getY();
					if(wl.isDisplayed())
					{
						ta.press(PointOption.point(x, y)).release().perform();
						break;
					}
				}
				catch(Exception e)
				{
					int h=driver.manage().window().getSize().getHeight();
					int w=driver.manage().window().getSize().getWidth();
					int x1=(int)(w/2);
					int y1=(int)(h*0.7);
					int x2=(int)(w/2);
					int y2=(int)(h*0.4);					
					WaitOptions wo=new WaitOptions();
					ta.press(PointOption.point(x1,y1)).waitAction(wo.withDuration(Duration.ofMillis(1000))).moveTo(PointOption.point(x2,y2)).release().perform();
				}
			}
			wa.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='22/08/2018 23:02']")));
			String m=driver.findElement(By.xpath("//*[contains(@resource-id,'text')]")).getAttribute("text");
			System.out.println(m);
			String x1=m.substring(8);
			//String y1=m.substring(1, 2);
			System.out.println(x1);
			//System.out.println(y1);
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		//Close App
		driver.closeApp();
		//Stop Appium Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}

package gestures;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class BookMyshow 
{
	public static void main(String[] args) throws Exception 
	{
		//Launch BookMyShow App In ARD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","AIGANZYLZLZDU8HQ");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","6.0");
		dc.setCapability("appPackage","com.lenovo.FileBrowser");
		dc.setCapability("appActivity","com.lenovo.FileBrowser.activities.FileBrowserMain");
		//Start Server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k\"appium -a 0.0.0.0 -p 4723\"");
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
		try
			{
				//Activity a=new Activity("com.bt.bms","com.movie.bms.languageselection.views.activities.LanguageSelectionActivity");
				//driver.startActivity(a);
				WebDriverWait w=new WebDriverWait(driver,20);
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Movies']")));
				driver.pressKeyCode(AndroidKeyCode.HOME);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps']")));
				driver.findElement(By.xpath("//*[@content-desc='Apps']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BookMyShow']")));
				driver.findElement(By.xpath("//*[@text='BookMyShow']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Explore In Your Own Language']")));
			}
			catch(Exception e)
			{
			
			}
		//Close App
		driver.closeApp();
		//Close Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}

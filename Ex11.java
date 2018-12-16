package wdMethods;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Ex11 
{
	public static void main(String[] args) throws Exception
	{
		//
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");
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
		try
		{
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
			driver.findElement(By.xpath("//*[@text='9']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='plus']")));
			driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='8']")));
			driver.findElement(By.xpath("//*[@text='8']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='equals']")));
			driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		}
		catch(Exception e)
		{
			System.out.println("x");
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}

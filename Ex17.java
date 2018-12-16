package wdMethods;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Ex17
{
	public static void main(String[] args) throws Exception
	{
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter Search Word");
		String x=sc.nextLine();
		System.out.println("Enter contact position");
		String z=sc.nextLine();*/
		
		// calculate Multiple Digits
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","AIGANZYLZLZDU8HQ");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","6.0");
		dc.setCapability("appPackage","com.lenovo.ideafriend");
		dc.setCapability("appActivity","com.lenovo.ideafriend.alias.MmsActivity");
		dc.setCapability("autoGrantPermissions",true);
		
		//Start Appium Server And App
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723");
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
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='All']")));
			int w1=driver.manage().window().getSize().width;
			int h=driver.manage().window().getSize().height;
			int x1=w1/2;
			int y1=(int) (h*0.2);
			int x2=w1/2;
			int y2=(int) (h*0.4);
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Your OTP is 576719 for Union Bank of India Credit Card ending 1606 valid for 5 minutes. Do not share this OTP with anyone']")).click();
					break;
					
				}
				catch(Exception e)
				{
					TouchAction ta=new TouchAction(driver);
					WaitOptions wo=new WaitOptions();
					Duration d=Duration.of(2,ChronoUnit.SECONDS);
					ta.press(PointOption.point(x1,y1)).waitAction(wo.withDuration(d)).moveTo(PointOption.point(x2, y2)).perform();
				}
			}
			
			
		driver.startActivity(newactivity("com.lenovo.ideafriend","com.lenovo.ideafriend.alias.MmsActivity"));	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
	}

	private static Activity newactivity(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}

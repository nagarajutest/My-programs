package wdMethods;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Ex13 
{
	public static void main(String[] args) throws Exception 
	{
		//
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Input 1");
		String x=sc.nextLine();
		
		// calculate Multiple Digits
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
		
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
		
		//Start Automation
		
		try
		{
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='dial']")));
			//Enter Phone Number
			for(int i=0;i<x.length();i++)
			{
				char d=x.charAt(i);
				String y="";
				switch(d)
				{
				case '0':
						y="zero";
						break;
				case '1':
					y="one";
					break;
				case '2':
					y="two";
					break;
				case '3':
					y="three";
					break;
				case '4':
					y="four";
					break;
				case '5':
					y="five";
					break;
				case '6':
					y="six";
					break;
				case '7':
					y="seven";
					break;
				case '8':
					y="eight";
					break;
				case '9':
					y="nine";
					break;	
				}
				driver.findElement(By.xpath("//*[@content-desc='"+y+"']")).click();
				
			}
			//Click On Dial
			driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='End']")));
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@content-desc='End']")).click();
			driver.closeApp();
			
		}
		catch(Exception e)
		{
			
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}

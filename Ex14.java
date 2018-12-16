package wdMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Ex14 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Search Word");
		String x=sc.nextLine();
		System.out.println("Enter contact position");
		String z=sc.nextLine();
		
		// calculate Multiple Digits
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","AIGANZYLZLZDU8HQ");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","6.0");
		dc.setCapability("appPackage","com.lenovo.ideafriend");
		dc.setCapability("appActivity","com.lenovo.ideafriend.alias.PeopleActivity");
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
		
		//Start Automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Groups']")));
			driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Set up my profile']")));
			driver.findElement(By.xpath("//*[@text='Search contacts | 277 Total contacts']")).sendKeys(x);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='All contacts' or @text='No match found.']")));
			try
			{
				if(driver.findElement(By.xpath("//*[@text='No match found.']")).isDisplayed())
				{
					System.out.println("No Contacts To Call");
				}
				
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//*[@class='android.view.ViewGroup'][@index='"+z+"']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Details']")));
				driver.findElement(By.xpath("//*[@content-desc='Call Mobile +91 80965 40750']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Idea 01']")));
				driver.findElement(By.xpath("//*[@text='Idea 01']")).click();
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='End']")));
				Thread.sleep(10000);
				try
				{
					if(driver.findElement(By.xpath("//*[@text='Dialling']")).isDisplayed())
						{
							driver.findElement(By.xpath("//*[@content-desc='End']")).click();
						}
				}
				catch(Exception ex)
				{
					
					driver.findElement(By.xpath("//*[@content-desc='End']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='New messages']")));
					String s=driver.findElement(By.xpath("//*[contains(@text='UL Expiry:2018-08-12']")).getAttribute("text");
					System.out.println(s);
					driver.findElement(By.xpath("//*[@text='Cancel']")).click();
					
				}
				//System.out.println(e.getMessage());
				/*WebElement e1=driver.findElement(By.xpath("//*[@class='android.view.ViewGroup'][index='"+z+"']"));
				Point p =e1.getLocation();Idea 01
				int m =p.getX();Call Mobile +91 80965 40750
				int n =p.getY();
				System.out.println(m);
				System.out.println(n);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Details']")));*/
			}
			
			/*for(int i=0;i<x.length();i++)
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
				
				}
		driver.findElement(By.xpath("//*[@resource-id='com.lenovo.ideafriend:id/"+x+"']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.lenovo.ideafriend:id/slot_index_2']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.incallui:id/endButton']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@resource-id='com.android.incallui:id/endButton']")).click();*/
		}
		catch(Exception e)
		{
			System.out.print("app");
		}
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
	}

}

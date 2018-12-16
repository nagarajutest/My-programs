package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Way2Sms
{
	public static void main(String[] args) throws Exception
	{
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(By.name("mobileNo")));
		driver.findElement(By.name("mobileNo")).sendKeys("9100748987");;
		driver.findElement(By.name("password")).sendKeys("9704197258");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Login'])[2]")));
		driver.findElement(By.xpath("(//*[text()='Login'])[2]")).click();
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='input-group'])[1]//input[@name='toMobile']")));
		driver.findElement(By.name("toMobile")).sendKeys("9505265205");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='form-group'])[3]/textarea")));
		driver.findElement(By.xpath("(//*[@class='form-group'])[3]/textarea")).sendKeys("hi");
		driver.findElement(By.xpath("//*[text()='send sms']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='dropdown border-left'])[1]/button/p")));
		driver.findElement(By.xpath("(//*[@class='dropdown border-left'])[1]/button/p")).click();
		driver.findElement(By.xpath("//div[@class='dropdown border-left open']//ul[@class='dropdown-menu']//li//a[@href='Logout']")).click();
		driver.close();
	}

}

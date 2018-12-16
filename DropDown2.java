package firefox;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDown2 
{
	public static void main(String[] args)
	{
		//Scanner sc=new Scanner(System.in);
		//String x=sc.nextLine();
		//Launch Site
				System.setProperty("webdriver.gecko.driver","C:\\\\Selenium\\\\geckodriver-v0.20.1-win64\\\\geckodriver.exe");
				FirefoxDriver driver=new FirefoxDriver();
				driver.get("https://semantic-ui.com/modules/dropdown.html");
				Actions a=new Actions(driver);
				WebElement e=driver.findElement(By.xpath("(//*[contains(@class,'selection multiple')])[2]"));
				a.click(e).build().perform();
				List<WebElement> l=driver.findElements(By.xpath("//*[contains(@class,'menu transition visible')]/div"));
				System.out.println(l.size());
				for(int i=0;i<l.size();i++)
				{
					System.out.println(l.get(i).getText());
					//String y=l.get(i).getText();
					/*if(x.equals(y))
					{
						a.c
					}*/
			
				}
				l.get(5).click();
						
						
	}
	

}

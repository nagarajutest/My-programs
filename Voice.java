package wdMethods;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Voice 
{
	public static void main(String[] args) throws Exception 
	{
		Runtime.getRuntime().exec("\"/Program Files (x86)/Google/Chrome/Application/chrome.exe\"");
		Robot r=new Robot();
		for(int i=0;i<=6;i++)
		{
			
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}

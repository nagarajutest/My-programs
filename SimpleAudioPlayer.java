package chrome;
import java.net.MalformedURLException;
import java.net.URL;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
 public class SimpleAudioPlayer
 {
    public static void main(String[] args) 
    {
    	String songName = "01 - Naa Jaane [www.PakHeaven.Com]";
    	String pathToMp3 = System.getProperty("C:\\naga\\Music\\HINDI") +"/"+ songName;
    	BasicPlayer player = new BasicPlayer();
    	try 
    	{
    	    player.open(new URL("C:\\naga\\Music\\HINDI" + pathToMp3));
    	    player.play();
    	} 
    	catch (BasicPlayerException | MalformedURLException e) 
    	{
    	    e.printStackTrace();
    	}
 
    }
 }
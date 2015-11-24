/*
 * Download jFugue (jfugue-4.0.3.jar): http://www.jfugue.org/4/download.html
 * Put the jar in your (build) path (add external jar)
 * All we need to know: http://www.jfugue.org/4/book.html
 * Basic Examples: http://www.jfugue.org/4/examples.html
 * Import statement: import org.jfugue.*; 
 * IGNORE WARNING; Eclipse issue that does not cause any errors
 * Note: jFugue 5.0 is available but it hasn't been used before and there is very limited documentation
 */
import org.jfugue.*; 
public class JFugueInfo 
{
	public static void main(String[] args)
	{
		Player player1 = new Player(); //sounds like shit but something to look at
		player1.play("Cq Dbq Eq Fq | Ch Dbq Eq | F#i Di Gh."); //period equals dotted note
		
		Player player2 = new Player();
		
	}

}

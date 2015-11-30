/*
 * Download jFugue (jfugue-4.0.3.jar): http://www.jfugue.org/4/download.html
 * Put the jar in your (build) path (add external jar)
 * All we need to know: http://www.jfugue.org/4/book.html
 * Basic Examples: http://www.jfugue.org/4/examples.html
 * Import statement: import org.jfugue.*; 
 * IGNORE WARNING; Eclipse issue that does not cause any errors
 * Note: jFugue 5.0 is available but it hasn't been used before and there is very limited documentation
 * 
 * uncomment any player.play lines if you want to hear them
 */
import org.jfugue.*; 
public class JFugueInfo 
{
	public static void main(String[] args)
	{
		Player player = new Player(); 
		
		//player.play("C5q Dbq Eq Fq | Ch Dbq Eq | F#i Di Gh."); //period:dotted_note #:sharp b:flat
	    
		//player.play("E5s A5s C6s B5s E5s B5s D6s C6i E6i G#5i E6i | A5s E5s A5s C6s B5s E5s B5s D6s C6i A5i Ri");//this sounds better
		
		player.play("V0 C4w | G4w | C4w V1 Ew | Dw | Dq. Eh.. " + "V2 Gw | Bw | Gw"); //multiple parts...V1 has a suspension!
		//number after note specifies octave (range 1-9; C4 is middle C
	}

}

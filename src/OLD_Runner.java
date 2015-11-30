import org.jfugue.*; 
/*
 * BEN: try running this class 
 * I created the Song.java entirely from scratch today...poorly structured but still should help get you an idea
 * RUN THIS 3-5 times 
 */
public class OLD_Runner 
{
	public static void main(String[] args) 
	{
		Song test = new Song();
		Player player = new Player();
		System.out.println("The melody is: " + test.melody);
		System.out.println("The bass line is: " + test.bassLine);
		System.out.println("The chordProgression is" + test.chordProgression);
		player.play("V0 " + test.bassLine + " " + "V1 " + test.melody);
		/*
		System.out.println((((int) (Math.random() * 2) + 1) / 2.0));
		System.out.println(Song.generateChordProgression());
		*/
	}
}

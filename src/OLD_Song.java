import org.jfugue.*;
import java.util.ArrayList;

public class OLD_Song 
{
	public static final int numOfMeasures = 4;
	public static final int beatsPerMeasure = 2;
	static ArrayList<String> key = chooseKey();
	static ArrayList<String> chordProgression = generateChordProgression();
	String melody = generateMelody();
	String bassLine = generateBassLine();
	public static String generateBassLine()
	{
		String bassLine = "";
		String duration = "h";
		int octave = 4;
		for(int i = 0; i < chordProgression.size(); i++)
		{
		   int rootAsNum = numeralToNumber(chordProgression.get(i));
		   String noteAsLetter = key.get(rootAsNum);
		   bassLine += (noteAsLetter + octave + duration + " ");
		   if((i + 1) % beatsPerMeasure == 0)
		   {
			   bassLine += "| ";
		   }
		}
		return bassLine;
	}
	public static String generateMelody()
	{
		String melody = "";
		int currentRoot; String noteAsLetter; String finalNote;
		for(int i = 0; i < chordProgression.size(); i++)
		{
			String chord = chordProgression.get(i);
			currentRoot = numeralToNumber(chord);
			double spaceLeft = 1.0; 
			while(spaceLeft > 0)
			{
				double noteLengthAsDouble;
				if(spaceLeft>0.5)
				{
					noteLengthAsDouble = (((int) (Math.random() * 2) + 1)) / 2.0;
				}
				else// spaceleft =0.5
				{
					noteLengthAsDouble = 0.5;
				}
				String duration; int noteAsNum;
				if(noteLengthAsDouble == 0.5)
				{
					duration = "q";
					spaceLeft -= 0.5;
				}
				else //(noteLengthAsDouble == 1.0
				{
					duration = "h";
					spaceLeft -= 1.0;
				}
				int randomNum = (int) (Math.random() * 100);
				if(randomNum < 30) //1st
				{
					noteAsNum = currentRoot;
				}
				else if(randomNum < 55) //3rd
				{
					noteAsNum = currentRoot + 2;
				}
				else if(randomNum < 75)
				{
					noteAsNum = currentRoot + 5;
				}
				else if(randomNum < 82)
				{
					noteAsNum = currentRoot + 1;
				}
				else 
				{
					noteAsNum = currentRoot - 1;
				}
				if(noteAsNum > 7)
				{
					noteAsNum -=7;
				}
				if(noteAsNum < 1)
				{
					noteAsNum += 7;
				}
				noteAsLetter = key.get(noteAsNum);
				finalNote = noteAsLetter + duration;
				melody += finalNote + " ";
			}
			if((i + 1) % beatsPerMeasure == 0)
			{
				melody += "| ";
			}
		}
		return melody;
	}
	public static int numeralToNumber(String numeral)
	{
		if(numeral.equals("I"))
		{
			return 1;
		}
		else if(numeral.equals("ii"))
		{
			return 2;
		}
		else if(numeral.equals("iii"))
		{
			return 3;
		}
		else if(numeral.equals("IV"))
		{
			return 4;
		}
		else if(numeral.equals("V"))
		{
			return 5;
		}
		else if(numeral.equals("vi"))
		{
			return 6;
		}
		else //(numeral.equals("vii"))
		{
			return 7;
		}
	}
	
	
	
	
	public static ArrayList<String> chooseKey()
	{
		
		ArrayList<String> cMajor = new ArrayList<String>();
		cMajor.add("ERROR");cMajor.add("C");cMajor.add("D");cMajor.add("E");cMajor.add("F");cMajor.add("G");cMajor.add("A");cMajor.add("B");
		ArrayList<String> gMajor = new ArrayList<String>(); 
		gMajor.add("ERROR");gMajor.add("G");gMajor.add("A");gMajor.add("B");gMajor.add("C");gMajor.add("D");gMajor.add("E");gMajor.add("F#");
		ArrayList<String> fMajor = new ArrayList<String>(); 	
		fMajor.add("ERROR");fMajor.add("F");fMajor.add("G");fMajor.add("A");fMajor.add("Bb");fMajor.add("C");fMajor.add("D");fMajor.add("E");
		
		int random = (int)(Math.random() * 3);
		if(random == 0)
		{
			return cMajor;
		}
		else if(random == 1)
		{
			return gMajor;
		}
		else return fMajor;
	}
	public static ArrayList<String> generateChordProgression()
	{
	    ArrayList<String> chordArray =  new ArrayList<String>();
	    for(int index = 0; index < numOfMeasures * beatsPerMeasure; index++)
	    {
	    	if(index == 0)
	    	{
	    		chordArray.add("I");
	    	}
	    	else //not first chord
	    	{
	    		String lastChord = chordArray.get(index - 1);
	    		String nextChord;
    			int randomNum = (int) (Math.random() * 100);
	    		if(lastChord == "I")
	    		{
	    			if(randomNum < 15)
	    			{
	    				nextChord = "I";
	    			}
	    			else if(randomNum < 30)
	    			{
	    				nextChord = "ii";
	    			}
	    			else if(randomNum < 45)
	    			{
	    				nextChord = "vi";
	    			}
	    			else if(randomNum < 75)
	    			{
	    				nextChord = "IV";
	    			}
	    			else //randomNum < 100
	    			{
	    				nextChord = "V";
	    			}
	    		}
	    		else if(lastChord == "ii")
	    		{
	    			if(randomNum < 70)
	    			{
	    				nextChord = "V";
	    			}
	    			else 
	    			{
	    				nextChord = "vi";
	    			}
	    		}
	    		else if(lastChord == "iii") //never should happen
	    		{
	    			nextChord = "I";
	    		}
	    		else if(lastChord == "IV") 
	    		{
	    			if(randomNum < 10)
	    			{
	    				nextChord = "ii";
	    			}
	    			else if(randomNum < 50)
	    			{
	    				nextChord = "V";
	    			}
	    			else if(randomNum < 60)
	    			{
	    				nextChord = "IV";
	    			}
	    			else if(randomNum < 75)
	    			{
	    				nextChord = "vii";
	    			}
	    			else //(randomNum < 100)
	    			{
	    				nextChord = "I";
	    			}
	    		}
	    		else if(lastChord == "V")
	    		{
	    			if(randomNum < 65)
	    			{
	    				nextChord = "I";
	    			}
	    			else //
	    			{
	    				nextChord = "vi";
	    			}
	    		}
	    		else if(lastChord == "vi")
	    		{
	    			if(randomNum < 80)
	    			{
	    				nextChord = "IV";
	    			}
	    			else //(randomNum < 100)
	    			{
	    				nextChord = "vi";
	    			}
	    		}
	    		else //(lastChord == "vii")
	    		{
	    			nextChord = "I";
	    		}
	    		chordArray.add(nextChord);
	    	}
	    }
	    return chordArray;
	    /*	
	    String chordProgression = ""; String chord; int index = 0;
		for(int measure = 1; measure <= numOfMeasures; measure++) //translates array to string
		{
			for(int beat = 1; beat <= beatsPerMeasure; beat++)
			{
               chord = chordArray.get(index);
               chordProgression = chordProgression + chord + " ";
               index++;
			}
			chordProgression += "| ";
		}
		return chordProgression;*/
	}
}


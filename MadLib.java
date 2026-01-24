//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("run");
		nouns.add("Jonathan Leohr");
		adjectives.add("purple");
		story = "Jonathan Leohr run down the purple road.";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadAdjectives();
		loadNouns();
		loadVerbs();
		
		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner chopper = new Scanner(new File(fileName));
			//While there is more of the story, read in the word/symbol
			while(chopper.hasNext())
			{
				//Make a string so that "chopper.next()" is not called multiple times, which I learned will keep going through the words
				String x = chopper.next();
				//If what was read in is one of the symbols, find a random
				//word to replace it.
				if(x.equals("#"))
				{
					story += " " + getRandomNoun();
				}
				else if(x.equals("@"))
				{
					story += " " + getRandomVerb();
				}
				else if(x.equals("&"))
				{
					story += " " + getRandomAdjective();
				}
				else
					story += " " + x;
			}
			chopper.close();
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		

		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));
			while(reader.hasNext())
			{
				nouns.add(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}
		
		
	}

	public void loadVerbs()
	{
		
		try
		{
			Scanner reader = new Scanner(new File("verbs.dat"));
			while(reader.hasNext())
			{
				verbs.add(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}

	}

	public void loadAdjectives()
	{
		
		try
		{
			Scanner reader = new Scanner(new File("adjectives.dat"));
			while(reader.hasNext())
			{
				adjectives.add(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}

		
	}

	public String getRandomVerb()
	{
		return "" + verbs.get((int)(Math.random() * verbs.size()));
	}

	public String getRandomNoun()
	{
		Random rand = new Random();
		return "" + nouns.get(rand.nextInt(nouns.size()));
	}

	public String getRandomAdjective()
	{
		return "" + adjectives.get((int)(Math.random() * adjectives.size()));
	}

	public String toString()
	{
		return "" + story;
	}
}
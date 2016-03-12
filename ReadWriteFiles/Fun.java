/*
Write some code that will create a stream named fileIn that is a member of
the class BufferedReader and that connects the stream to a text file named
joe so that your program can read input from the text file joe.
*/

// imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fun
{
	public static void main(String[] args)
	{
		String[] lines = new String[10];
		String check = "";
		int nLines = 0;
		try
		{
			BufferedReader fileIn = new BufferedReader(new FileReader("joe.txt"));
			while (check != null)
			{
				check = fileIn.readLine();
				if (check != null)
				{	
					lines[nLines] = check; 
					nLines++;
				}
			}
			fileIn.close();
			for (int i = 0; i < nLines-1; i++)
			{
				System.out.println(lines[i]);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File joe.txt not found");
			System.out.println("or could not be opened.");
		}
		catch(IOException e)
		{
			System.out.println("Error reading from file joe.txt");
		}

	}
}
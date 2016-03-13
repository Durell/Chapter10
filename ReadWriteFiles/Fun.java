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
import java.io.File;
import java.util.Scanner;

public class Fun
{
	public static void main(String[] args)
	{
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please give me a file name to read from.");
    String fileName = keyboard.nextLine();
    File fileObject = new File(fileName);

    while(!fileObject.exists())
    {
      System.out.println("No file named: " + fileName);
      System.out.println("Please give me a valid file name: ");
      fileName = keyboard.nextLine();
      fileObject = new File(fileName);
    }

		try
		{
			BufferedReader fileIn = new BufferedReader(new FileReader(fileObject));
		  String[] lines = new String[10];
		  int nLines = 0;
      lines[nLines] = fileIn.readLine();
			while (lines[nLines] != null)
			{
			  nLines++;
			  lines[nLines] = fileIn.readLine(); 
			}
			fileIn.close();
			for (int i = 0; i < nLines; i++)
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

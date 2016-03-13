/*
Chapter No. 10 - Project No. 1
File Name:          Names.java
Programmer:         Durell Smith
Date Last Modified: March 2, 2016

Problem Statement:
Write a program that reads both the girl and boy files into memory using arrays.
Then, allow the user to input a name. The program should search through both
arrays. If there is a match, then it should output the popularity ranking and the
number of namings. The program should also indicate if there is no match.
 
Overall Plan:
1.
2.
3.

Classes needed and Purpose:
main class - Names
*/

// imports
import java.util.*;   //includes Scanner
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Names
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner inputBoyStream = null;
        Scanner inputGirlStream = null;
        
        try
        {
            inputBoyStream = new Scanner(new FileInputStream("boynames.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File boynames.txt was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }

        try
        {
            inputGirlStream = new Scanner(new FileInputStream("girlnames.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File girlnames.txt was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }

        // Ladies First
        String[] girls = new String[1000];
        for (int i = 0; i < girls.length; i++)
        {
            girls[i] = inputGirlStream.nextLine(); //To go to the next line
        }
        // Now Boys
        String[] boys = new String[1000];
        for (int i = 0; i < boys.length; i++)
        {
            boys[i] = inputBoyStream.nextLine(); //To go to the next line
        }
        
        inputBoyStream.close( );
        inputGirlStream.close( );

/*      ---- Test ----
        // tested to make sure they're populated:
        for (int i = 0; i < 10; i++)
        {
            System.out.println(girls[i]);
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(boys[i]);
        }
        String[] comName = boys[1].split(" ", 2);

        System.out.println("Please Work!!!!!!!!");
        System.out.println(comName[0] + " with " + comName[1] + " occurences");
*/

        String EXIT = "0",
        	   iname = "";
               

        System.out.println("Please give me a name to search for.");
        iname = keyboard.nextLine();
        while (!iname.equals(EXIT))
        {
            boolean gc = false, 
                    bc = false;
            for (int i = 0; i < boys.length; i++)
            {
                String[] bcomName = boys[i].split(" ", 2);
                String[] gcomName = girls[i].split(" ", 2);
                if (iname.toLowerCase().equals(bcomName[0].toLowerCase()))
                {
                    System.out.println(bcomName[0] + " is ranked " + (i + 1) + 
                    					" in popularity among boys with " + 
                    					bcomName[1] + " occurences");
                    bc = true;
                }
    
                if (iname.toLowerCase().equals(gcomName[0].toLowerCase()))
                {
                    System.out.println(gcomName[0] + " is ranked " + (i + 1) + 
                    					" in popularity among girls with " + 
                    					gcomName[1] + " occurences");
                    gc = true;
                }
            }
    
            if (bc == false)
                System.out.println(iname + " is not ranked among the 1000 most" +
                					" popular boy's names.");
    
            if (gc == false)
                System.out.println(iname + " is not ranked among the 1000 most" +
                					" popular girl's names.");

            System.out.println("Please give me another name to search for or" +
            					" enter '0' to exit.");
            iname = keyboard.nextLine();
        }
    } // end main method
} // end Names class
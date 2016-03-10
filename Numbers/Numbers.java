/*
Chapter No. 10 - Handout 2 Exercise 1
File Name:          Numbers.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write a program that reads a file of numbers of type int and outputs all the numbers to
another file, but without any duplicate numbers. Assume that the input file is sorted from
smallest first to largest last. After the program is run, the new file will contain all the
numbers in the original file, but no number will appear more than once in the file. The
numbers in the output file should also be sorted from smallest to largest. Your program
should obtain both file names from the user. Use a text file that stores one number per
line.
 
Classes needed and Purpose:
main class - Numbers
*/

// imports
import java.util.*;   //includes Scanner
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Numbers
{
	// main method
	public static void main(String[] args)
	{
    Scanner userInput = new Scanner(System.in);
    PrintWriter ouputTxtStream = null;
    String fileName = "";

    System.out.print("Please give me the name of the text file to read from. > ");
    fileName = userInput.nextLine();
    try
    {
      txtFileStream = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File " + fileName + " was not found");
      System.out.println("or could not be opened");
      System.exit(0);
    }

    System.out.print("Please give me the name of the text file to write to. > ");
    fileName = userInput.nextLine();
    try
    {
      outputTxtStream = new PrintWriter(new FileOutputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File " + fileName + " was not found");
      System.out.println("or could not be opened");
      System.exit(0);
    }

    

	} // end main method

} // end Numbers class

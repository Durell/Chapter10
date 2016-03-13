/*
Chapter No. 10 - Handout 2 Project 1
File Name:          Numbers.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write a program that reads a file of numbers of type int and outputs all the numbers to
another file without any duplicate numbers. 
*/

// imports
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

public class Numbers
{
	// main method
	public static void main(String[] args)
	{
    // userInput will retrieve file names from users
    Scanner userInput = new Scanner(System.in);
    // request fileName from user
    System.out.print("Please give me the name of the text file to read from. > ");
    String fileName = userInput.nextLine();
    File fileObject = new File(fileName); // will use to verify file exists
    int num = 0,
        prev = -1;
    // check if file exists, if not request to input again
    while(!fileObject.exists())
    {
      System.out.println("No file named: " + fileName);
      System.out.println("Please give me a valid file name: ");
      fileName = userInput.nextLine();
      fileObject = new File(fileName);
    }
    // now that we have a valid fileName we'll create an input stream
    Scanner inputFileStream = null;
    try
    {
      inputFileStream = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File " + fileName + " could not be opened");
      System.exit(0);
    }
    // now we'll get the file we're writing to.
    System.out.print("Please give me the name of the text file to write to. > ");
    fileName = userInput.nextLine();
    PrintWriter outputFileStream = null;
    try
    {
      outputFileStream = new PrintWriter(new FileOutputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File " + fileName + " was not found");
      System.out.println("or could not be opened");
      System.exit(0);
    }
    // and finally copy every number except repeats
    while (inputFileStream.hasNextInt())
    {
      num = inputFileStream.nextInt();
      if (num != prev)
      {
        outputFileStream.println(num);
        prev = num;
      }
    }
    inputFileStream.close(); // close the stream
    outputFileStream.close(); // close the stream
	} // end main method
} // end Numbers class

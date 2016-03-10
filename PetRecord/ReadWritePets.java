/*
Chapter No. 10 - Handout#2 Project 1
File Name:          ReadWritePets.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:

Classes needed and Purpose:
main class - ReadWritePets
*/

// imports
import java.util.*;   //includes Scanner
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadWritePets
{

  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    Scanner txtFileStream = null;
    String userResponse = "";

    System.out.print("Would you like to read or write a file?);
    userResponse = userInput.nextLine();

    System.out.print("Please give me the text file name. > ");
    userResponse = userInput.nextLine();
    try
    {
      txtFileStream = new Scanner(new FileInputStream(userResponse));
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File " + userResponse + " was not found");
      System.out.println("or could not be opened");
      System.exit(0);
    }
  } // end main() method
} // end ReadWritePets class

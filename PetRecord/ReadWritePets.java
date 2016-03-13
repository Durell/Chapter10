/*
Chapter No. 10 - Handout 2 Project 2
File Name:          ReadWritePets.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write a program that allows user to write and read records
of type PetRecord to or from a file they specify.

Classes needed and Purpose:
main class - ReadWritePets
*/

// imports
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class ReadWritePets
{

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Scanner txtFileStream = null;
    String userResponse = "";

    System.out.println("Would you like to read or write a file?");
    System.out.print("Input r to read or w to write> ");
    userResponse = keyboard.nextLine();
    if (userResponse.trim.toLowerCase.equals("w"))
    {
      System.out.print("Please give me the text file name. > ");
      userResponse = keyboard.nextLine();
      File fileObject = new File(userResponse);
    }

    System.out.print("Please give me the text file name. > ");
    userResponse = keyboard.nextLine();
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

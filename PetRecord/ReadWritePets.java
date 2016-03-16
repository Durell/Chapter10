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
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.io.EOFException;

public class ReadWritePets
{

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    String userResponse = "";
    boolean done = false;

    // keep going until user requests to exit
    System.out.print("Hi, I can write and read PetRecords to/from a file.");
    while (!done)
    {
      System.out.println("Would you like to read from a file or write to a file?");
      System.out.println("Enter r to read, w to write or q to quit.");
      userResponse = keyboard.nextLine();

      // if they want to write a file
      if (userResponse.trim().toLowerCase().equals("w"))
      {
        System.out.print("Please give me the text file name. > ");
        userResponse = keyboard.nextLine();
        File fileObject = new File(userResponse);
        boolean append = false;
        // if the file already exists, ask if they want to add to it or overwrite
        if (fileObject.exists())
        {
          System.out.println("File already exists. Append or overwrite file?");
          System.out.print("To append enter 'a'. To overwrite enter 'o'. > ");
          userResponse = keyboard.nextLine();
          append = userResponse.trim().toLowerCase().equals("a");
        }
        // now we're ready to open the file
        AppendObjectOutputStream outputStream;
        try
        {
          outputStream = new AppendObjectOutputStream(new FileOutputStream(fileObject, append));
          boolean doneAdding = false;
          while (!doneAdding)
          {
            System.out.println("Please give me the pet's name.");
            String name = keyboard.nextLine();
            System.out.println("What is the age of the pet?");
            int age = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("How much does it weigh?");
            double weight = keyboard.nextDouble();
            keyboard.nextLine();
            PetRecord addPet = new PetRecord(name, age, weight);
            System.out.println(addPet);
            outputStream.writeObject(addPet);
            System.out.println("Would you like to add another (y/n)?");
            name = keyboard.nextLine();
            if (name.trim().toLowerCase().equals("n"))
              doneAdding = true;
          }
          outputStream.close();
        }
        catch(IOException e)
        {
          System.out.println("File " + userResponse + " was not found");
          System.out.println("or could not be opened");
          System.exit(0);
        }
        // we need a String name, int age, and double weight
      }

      // if they want to read a file
      else if (userResponse.trim().toLowerCase().equals("r"))
      {
        System.out.print("Please give me the text file name. > ");
        userResponse = keyboard.nextLine();
        // make sure the file exists since we want to read
        File fileObject = new File(userResponse);
        while (!fileObject.exists())
        {
          System.out.println("No file named: " + userResponse);
          System.out.println("Please give me a valid file name: ");
          userResponse = keyboard.nextLine();
          fileObject = new File(userResponse);
        }
        ObjectInputStream inputStream;
        try
        {
          inputStream = new ObjectInputStream(new FileInputStream(userResponse));
          try
          {
            PetRecord record;
            while (true)
            {
              record = (PetRecord)inputStream.readObject();
              System.out.println(record);
            }
          }
          catch(EOFException e)
          {
            System.out.println("Reached end of record.");
          }
          inputStream.close();
        }
      	catch(ClassNotFoundException e)
      	{
      		System.out.println("classNotFound Exception ran.");
      	}
        catch(IOException e)
        {
          System.out.println("File " + userResponse + " was not found");
          System.out.println("or could not be opened");
          System.exit(0);
        }
      }
      else if (userResponse.trim().toLowerCase().equals("q"))
        done = true;
    }
  } // end main() method
} // end ReadWritePets class

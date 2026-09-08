package Exercises;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class practiceFilereader
{
    public static void main(String[] args) throws IOException
    {
        File myFile = new File("Things.txt");
        PrintWriter outputFile = new PrintWriter("Things.txt");
        Scanner inputfile = new Scanner(myFile);
        Random randomNumbers = new Random();

        double x,y,z,average;

        x = randomNumbers.nextInt();
        y = randomNumbers.nextInt();
        z = randomNumbers.nextInt();
        
        outputFile.println(x);
        outputFile.println(y);
        outputFile.println(z);

        outputFile.close();

        System.out.println("Your random numbers are " + x + " " + y + " " + z);

        average = (x + y + z)/3;

        System.out.println(average);

        inputfile.close();
    }
}
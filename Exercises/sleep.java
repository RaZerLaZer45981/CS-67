package Exercises;
import java.util.Scanner;

public class sleep 
{
    public static void main(String[] args)
    {
        int hours;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many hours of sleep did you get last night?");
        hours = keyboard.nextInt();

        if (hours >= 0 && hours <= 4)
        {
            System.out.println("Are you sure you are awake?");
        }
        else if (hours > 4 && hours <= 8)
        {
            System.out.println("The coffee shop is around the corner");
        }
        else if (hours > 8)
        {
            System.out.println("You are well-rested!");
        }
        else
        {
            System.out.println("Input error.");
        }

        keyboard.close();
    }   
}

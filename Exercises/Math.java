package Exercises;
import java.util.Scanner;

public class Math 
{
    public static void numbers(double num1, int num2)
    {
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
    }

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What would you like your first number to be? (Double)");
        double num1 = keyboard.nextDouble();

        System.out.println("What would you like your second number to be? (Integer)");
        int num2 = keyboard.nextInt();

        numbers(num1,num2);

       keyboard.close();
    }
}
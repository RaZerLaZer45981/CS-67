package Exercises;
import java.util.Scanner;

public class temperature 
{
    public static void main(String[] args)
    {
        int temperature;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is the temperature outside?");
        temperature = keyboard.nextInt();

        if (temperature > 90){
            System.out.println("Time for ice cream!");
        }
            
        else{
            System.out.println("Time for cake!");
        }

        keyboard.close();
    }
}

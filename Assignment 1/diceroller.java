import java.util.Scanner;

/*
https://codehs.com/tutorial/evelyn/user-input-in-java
Used to take a user input

https://www.w3schools.com/java/java_user_input.asp
Used for examples on how to code specific things like if statements, loops, or random numbers
*/

public class diceroller
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);

        System.out.println("What sided dice would you like to roll?");

        Integer dice = input.nextInt();

        System.out.println("Rolling a " + dice + " sided dice.");

        int randomnumber = (int)(Math.random() * dice + 1); 

        System.out.println("You rolled a " + randomnumber + "!");

        input.close();
    }
}
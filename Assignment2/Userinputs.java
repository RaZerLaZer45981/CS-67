package Assignment2;
import java.util.Scanner;

public class Userinputs
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        String name1;
        String genre1;

        String name2;
        String genre2;

        System.out.println("What is the name of the game?");
        name1 = keyboard.nextLine();

        System.out.println("What is the genre of the game?");
        genre1 = keyboard.nextLine();

        Game game1 = new Game(name1, genre1);

        System.out.println("What is the name of the game?");
        name2 = keyboard.nextLine();

        System.out.println("What is the genre of the game?");
        genre2 = keyboard.nextLine();

        Game game2 = new Game(name2, genre2);

        game1.display();
        game2.display();

        keyboard.close();
    }
}


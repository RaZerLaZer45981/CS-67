package Assignment3;
import java.util.Scanner;

public class Bookshelf 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        Boolean next = true;
        String yes;
        String name;
        int pages;

        while (next)
        {
            System.out.println("What is the name of the book?");
            name = keyboard.nextLine();

            System.out.println("How many pages does the book have?");
            pages = keyboard.nextInt();
            keyboard.nextLine();

            Book newBook = new Book(name, pages);
            newBook.display();

            System.out.println("Would you like to add another book to the shelf? (Yes or No)");
            yes = keyboard.nextLine();

            if (yes.equals("Yes"))
            {
                continue;
            }

            else if (yes.equals("No"))
            {
                next = false;
            }

            else
            {
                continue;
            }
        }
        keyboard.close();
    }
}

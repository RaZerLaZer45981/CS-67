package Exercises;
import java.util.Scanner;

public class Person 
{
    private String name;
    private Date birthday;

    public Person(String n, Date bd) 
    {
        name = n;
        birthday = bd;    
    }

    Scanner keyboard = new Scanner(System.in);

    public String setName()
    {
        System.out.println("What is the name of your person?");
        name = keyboard.nextLine();

        return name;
    }

    public String setName(String name1)
    {
        name = name1;

        return name;
    }

    public String toString()
    {
        return name + " " + birthday;
    }
}

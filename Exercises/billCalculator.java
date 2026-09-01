package Exercises;
import java.util.Scanner;

public class billCalculator
{
    public static void main(String[] args)
    {
        Scanner board = new Scanner(System.in);

        int people;
        double total;
        double costPerPerson;

        System.out.println("Please enter the number of people: ");
        people = board.nextInt();

        System.out.println("Please enter the total of the bill");
        total = board.nextDouble();

        total = (total * 0.15) + total;

        costPerPerson = total / people;

        System.out.println("With a 15 percent tip, the total bill is" + total);
        System.out.println("Each person owes $" + costPerPerson);

        board.close();
    }
}

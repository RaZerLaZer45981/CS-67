package Assignment3;

public class Book 
{
    String name;
    Integer pages;

    public Book(String name, Integer pages)
    {
        this.name = name;
        this.pages = pages;
    }

    public void display()
    {
        System.out.println("The name of the book is " + name + " and the number of pages is " + pages + ".");
    }
}

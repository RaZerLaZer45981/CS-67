package Assignment2;

public class Game
{
    String name;
    String genre;

    public Game(String name, String genre)
    {
        this.name = name;
        this.genre = genre;
    }

    public void display()
    {
        System.out.println("The name of the game is " + name + " and the genre is a " + genre + " Game.");
    }

}

package Exercises;

public class Derp 
{
    public static int countChar(String word, char ch)
    {
        int count = 0;

        for (int i = 0; i<word.length(); i++)
            {
                if(word.charAt(i) == ch)
                {
                    count ++;
                }
            }

        return count;
    }

    public static void main(String[] args)
    {
        int count = 0;

        count = countChar("banana", 'a');

        System.out.println("There were " + count + " a's.");
    }

}

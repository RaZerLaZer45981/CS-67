package Assignment4;
import java.io.*;
import java.util.Scanner;

// Name: Seth Hall

// Secret Message #1: Eat More Vegetables

// Secret Message #2: Four Chars After W

// Secret Message #3: tinyurl.com/3s847myv

public class fileReader 
{
    public static void main(String[] args) throws IOException
    {
        String stringx = "",stringy = "",stringw = "";
        File myFile = new File("Assignment4Input.txt");
        Scanner inputfile = new Scanner(myFile);

        while (inputfile.hasNext())
        {
            String line = inputfile.nextLine();
            for (int i=0; i<line.length(); i++) 
            {
                if (line.charAt(i) == 'X')
                {
                    stringx = stringx + line.charAt(i+3);
                }

                if (line.charAt(i) == 'Y')
                {
                    stringy = stringy + line.charAt(i+5);
                }

                if (line.charAt(i) == 'W')
                {
                    stringw = stringw + line.charAt(i+4);
                }
            }
        }
        System.out.println(stringx);
        System.out.println(stringy);
        System.out.println(stringw);

        inputfile.close();
    }
}

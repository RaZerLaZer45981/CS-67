package Exercises;

public class Date
{
    private int month;
    private int day;
    private int year;

    public Date()
    {
        month = 0;
        day = 0;
        year = 0;
    }

    public Date(int month, int day, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public void setMonth(int num1)
    {
        if(num1 < 0 && num1 >= 13)
        {
            System.out.println("Invalid Number (1-12)");
        }
        else
        {
            month = num1;
        }
    }

    public void setDay(int num2)
    {
        if(num2 < 0 && num2 >= 32)
        {
            System.out.println("Invalid Number (1-31)");
        }
        else
        {
            day = num2;
        }
    }

    public void setYear(int num3)
    {
        if(num3 < 0)
        {
            System.out.println("Invalid Number");
        }
        else
        {
            year = num3;
        }
    }

    public String toString()
    {
        return (month + "/" + day + "/" + year);
    }
}
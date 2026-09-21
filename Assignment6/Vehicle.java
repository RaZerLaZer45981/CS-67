package Assignment6;

import java.time.Year;

// Name: Seth Hall

// Superclass. Every vehicle in the program has a make, a model, a year,
// and a price. The subclasses add on to this.

public class Vehicle
{
    private String make;
    private String model;
    private int year;
    private double price;

    // Constructor that initializes all four attributes
    public Vehicle(String make1, String model1, int year1, double price1)
    {
        make = make1;
        model = model1;
        year = year1;
        price = price1;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price1)
    {
        price = price1;
    }

    // How old the vehicle is. The subclasses inherit this method and do
    // not need to write their own copy of it.
    public int getAge()
    {
        return Year.now().getValue() - year;
    }

    // Older vehicles are worth less. 8% comes off the price for each year.
    public double estimateValue()
    {
        double value = price;

        for (int i = 0; i < getAge(); i++)
        {
            value = value * 0.92;
        }

        return value;
    }

    public String toString()
    {
        return year + " " + make + " " + model + " - $" + String.format("%.2f", price);
    }
}

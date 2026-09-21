package Assignment6;

// Name: Seth Hall

// A second subclass of Vehicle. Adds towing capacity and a method that
// checks whether the truck can pull a given load.

public class PickupTruck extends Vehicle
{
    private int towingCapacity;   // pounds

    public PickupTruck(String make1, String model1, int year1, double price1, int towing1)
    {
        super(make1, model1, year1, price1);
        towingCapacity = towing1;
    }

    public int getTowingCapacity()
    {
        return towingCapacity;
    }

    // Extra method that only the subclass has
    public boolean canTow(int pounds)
    {
        return pounds <= towingCapacity;
    }

    public String toString()
    {
        return super.toString() + " [Pickup, tows " + towingCapacity + " lbs]";
    }
}

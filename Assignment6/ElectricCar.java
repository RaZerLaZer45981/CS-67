package Assignment6;

// Name: Seth Hall

// Subclass of Vehicle. Adds the battery range and a method that figures
// out how many stops a trip would need.

public class ElectricCar extends Vehicle
{
    private int batteryRange;   // miles on a full charge

    public ElectricCar(String make1, String model1, int year1, double price1, int range1)
    {
        super(make1, model1, year1, price1);   // send the shared parts to the superclass
        batteryRange = range1;
    }

    public int getBatteryRange()
    {
        return batteryRange;
    }

    // Extra method that only the subclass has
    public int chargingStopsNeeded(int tripMiles)
    {
        int stops = 0;
        int milesLeft = tripMiles;

        while (milesLeft > batteryRange)
        {
            stops = stops + 1;
            milesLeft = milesLeft - batteryRange;
        }

        return stops;
    }

    // Overrides the superclass version. The 8% per year does not fit an
    // electric car very well because the battery wears out faster, so
    // this one takes off a little extra.
    public double estimateValue()
    {
        double value = super.estimateValue();

        return value - (getAge() * 500);
    }

    // Overriding toString(). super.toString() reuses the superclass text
    // so the make and model do not get written out twice.
    public String toString()
    {
        return super.toString() + " [Electric, " + batteryRange + " mile range]";
    }
}

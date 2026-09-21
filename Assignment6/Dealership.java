package Assignment6;

import java.util.ArrayList;

// Name: Seth Hall

// Driver class. Builds several objects, stores them in an ArrayList, and
// loops through the list to show inheritance and overriding at work.

public class Dealership
{
    public static void main(String[] args)
    {
        // The list holds Vehicle references, but the objects inside can be
        // plain Vehicles, ElectricCars, or PickupTrucks.
        ArrayList<Vehicle> lot = new ArrayList<Vehicle>();

        lot.add(new Vehicle("Honda", "Civic", 2019, 22500.00));
        lot.add(new Vehicle("Toyota", "Corolla", 2022, 24000.00));
        lot.add(new ElectricCar("Tesla", "Model 3", 2021, 41000.00, 272));
        lot.add(new ElectricCar("Nissan", "Leaf", 2018, 29000.00, 151));
        lot.add(new PickupTruck("Ford", "F-150", 2020, 38500.00, 13000));
        lot.add(new PickupTruck("Chevrolet", "Silverado", 2023, 45000.00, 9500));

        int tripLength = 600;
        int load = 10000;
        double total = 0;
        int oldestAge = 0;
        String oldestName = "";

        System.out.println("=== Everything On The Lot ===");
        System.out.println();

        // One loop that does it all: toString() gets called on each object,
        // and Java picks the right version at runtime, so the electrics and
        // the trucks print their extra information without any if statements
        // here. instanceof then picks out the subclass-only checks, and the
        // same pass keeps a running total for the summary at the end. Age
        // comes from getAge(), which is written once in Vehicle and inherited
        // by every object in the list.
        for (int i = 0; i < lot.size(); i++)
        {
            Vehicle v = lot.get(i);

            System.out.println((i + 1) + ". " + v);
            System.out.println("   Age: " + v.getAge() + " years");
            System.out.println("   Estimated value: $" + String.format("%.2f", v.estimateValue()));

            if (v instanceof ElectricCar)
            {
                ElectricCar car = (ElectricCar) v;
                int stops = car.chargingStopsNeeded(tripLength);

                System.out.println("   Road trip (" + tripLength + " mi): " + stops + " charging stop(s).");
            }

            if (v instanceof PickupTruck)
            {
                PickupTruck truck = (PickupTruck) v;

                if (truck.canTow(load))
                {
                    System.out.println("   Towing (" + load + " lbs): can handle the load.");
                }
                else
                {
                    System.out.println("   Towing (" + load + " lbs): not rated for it.");
                }
            }

            System.out.println();

            total = total + v.estimateValue();

            if (v.getAge() > oldestAge)
            {
                oldestAge = v.getAge();
                oldestName = v.getMake() + " " + v.getModel();
            }
        }

        System.out.println("=== Lot Summary ===");
        System.out.println();
        System.out.println("Vehicles on the lot: " + lot.size());
        System.out.println("Total estimated value: $" + String.format("%.2f", total));
        System.out.println("Average estimated value: $" + String.format("%.2f", total / lot.size()));
        System.out.println("Oldest vehicle: " + oldestName + " (" + oldestAge + " years)");
    }
}

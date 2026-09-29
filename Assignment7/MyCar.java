import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private String brand;
    private int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Overloaded constructor: lets you create a Vehicle when the year isn't known yet
    Vehicle(String brand) {
        this(brand, 0);
    }

    void start() {
        System.out.println("Vehicle is starting");
    }

    // Overloaded method: same name as start(), different parameter list
    void start(int speedMph) {
        System.out.println("Vehicle is starting and accelerating to " + speedMph + " mph");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "Brand: " + brand + ", Year: " + year;
    }

    // Machine-readable format used when saving to / loading from a file
    public String toCSV() {
        return "VEHICLE," + brand + "," + year;
    }
}


class Car extends Vehicle {
    private int numberOfDoors;
    private int milesPerGallon;
    private int numMileage;

    Car(String brand, int year, int numberOfDoors, int milesPerGallon, int numMileage) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
        this.milesPerGallon = milesPerGallon;
        this.numMileage = numMileage;
    }

    // Overriding: a Car starts differently than a generic Vehicle
    void start() {
        System.out.println("Car is starting");
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public String toString() {
        return super.toString() + ", Number of Doors: " + numberOfDoors + ", Miles per Gallon: " + milesPerGallon + ", Mileage: " + numMileage;
    }

    public String toCSV() {
        return "CAR," + getBrand() + "," + getYear() + "," + numberOfDoors + "," + milesPerGallon + "," + numMileage;
    }
}


// New subclass/object type added to the hierarchy
class Truck extends Vehicle {
    private int towingCapacityLbs;

    Truck(String brand, int year, int towingCapacityLbs) {
        super(brand, year);
        this.towingCapacityLbs = towingCapacityLbs;
    }

    // Overriding: a Truck starts differently than a generic Vehicle
    void start() {
        System.out.println("Truck is starting (diesel engine rumbling)");
    }

    public String toString() {
        return super.toString() + ", Towing Capacity: " + towingCapacityLbs + " lbs";
    }

    public String toCSV() {
        return "TRUCK," + getBrand() + "," + getYear() + "," + towingCapacityLbs;
    }
}


public class MyCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Vehicle myVehicle = new Vehicle("Toyota", 2007);
        Car myCar = new Car("Chevy", 2012, 4, 30, 50000);
        Truck myTruck = new Truck("Ford", 2019, 13000);

        vehicles.add(myVehicle);
        vehicles.add(myCar);
        vehicles.add(myTruck);

        System.out.println("--- Overloading example (Vehicle.start) ---");
        myVehicle.start();
        myVehicle.start(35);

        System.out.println();
        System.out.println("--- Overriding example (each subclass starts differently) ---");
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
        }

        System.out.println();
        System.out.println("--- Add your own car ---");
        Car userCar = createCarFromInput(scanner);
        vehicles.add(userCar);

        System.out.println();
        System.out.println("Vehicles in the list:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        String filename = "vehicles_data.csv";
        writeVehiclesToFile(vehicles, filename);

        System.out.println();
        System.out.println("--- Reloading vehicles from " + filename + " ---");
        ArrayList<Vehicle> loadedVehicles = readVehiclesFromFile(filename);
        for (Vehicle vehicle : loadedVehicles) {
            System.out.println(vehicle);
        }

        printFleetSummary(loadedVehicles);

        scanner.close();
    }

    // Prompts the user for car details, validating input so bad entries don't crash the program
    private static Car createCarFromInput(Scanner scanner) {
        System.out.print("Enter the car's brand: ");
        String brand = scanner.nextLine().trim();
        while (brand.isEmpty()) {
            System.out.print("Brand cannot be empty. Enter the car's brand: ");
            brand = scanner.nextLine().trim();
        }

        int year = readValidInt(scanner, "Enter the car's year: ");
        int doors = readValidInt(scanner, "Enter the number of doors: ");
        int mpg = readValidInt(scanner, "Enter the miles per gallon: ");
        int mileage = readValidInt(scanner, "Enter the current mileage: ");

        return new Car(brand, year, doors, mpg, mileage);
    }

    // Keeps asking until the user enters a value that actually parses as an int
    private static int readValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\"" + input + "\" is not a valid whole number. Please try again.");
            }
        }
    }

    // Writes the fleet out to a CSV file so it can be reloaded later
    private static void writeVehiclesToFile(ArrayList<Vehicle> vehicles, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Vehicle vehicle : vehicles) {
                writer.println(vehicle.toCSV());
            }
            System.out.println("Saved " + vehicles.size() + " vehicles to " + filename);
        } catch (IOException e) {
            System.out.println("Could not write to " + filename + ": " + e.getMessage());
        }
    }

    // Reads the fleet back in from a CSV file, skipping any lines that are malformed
    private static ArrayList<Vehicle> readVehiclesFromFile(String filename) {
        ArrayList<Vehicle> loaded = new ArrayList<>();
        File file = new File(filename);

        try (Scanner fileScanner = new Scanner(file)) {
            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    loaded.add(parseVehicle(line));
                } catch (RuntimeException e) {
                    System.out.println("Skipping malformed line " + lineNumber + ": " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return loaded;
    }

    // Turns one CSV line back into the right kind of Vehicle
    private static Vehicle parseVehicle(String line) {
        String[] parts = line.split(",");
        String type = parts[0];
        String brand = parts[1];
        int year = Integer.parseInt(parts[2]);

        switch (type) {
            case "CAR":
                int doors = Integer.parseInt(parts[3]);
                int mpg = Integer.parseInt(parts[4]);
                int mileage = Integer.parseInt(parts[5]);
                return new Car(brand, year, doors, mpg, mileage);
            case "TRUCK":
                int towing = Integer.parseInt(parts[3]);
                return new Truck(brand, year, towing);
            case "VEHICLE":
                return new Vehicle(brand, year);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    // Invented feature: a quick report summarizing the whole fleet
    private static void printFleetSummary(ArrayList<Vehicle> vehicles) {
        int carCount = 0;
        int truckCount = 0;
        int totalMpg = 0;
        int yearSum = 0;

        for (Vehicle vehicle : vehicles) {
            yearSum += vehicle.getYear();
            if (vehicle instanceof Car) {
                carCount++;
                totalMpg += ((Car) vehicle).getMilesPerGallon();
            } else if (vehicle instanceof Truck) {
                truckCount++;
            }
        }

        System.out.println();
        System.out.println("--- Fleet Summary ---");
        System.out.println("Total vehicles: " + vehicles.size());
        System.out.println("Cars: " + carCount + ", Trucks: " + truckCount);
        if (!vehicles.isEmpty()) {
            System.out.printf("Average model year: %.1f%n", yearSum / (double) vehicles.size());
        }
        if (carCount > 0) {
            System.out.printf("Average MPG (cars only): %.1f%n", totalMpg / (double) carCount);
        }
    }
}

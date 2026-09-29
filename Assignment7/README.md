Seth Hall
Assignment 7 — Extending MyCar.java

- 1. What I Learned
The vehicle class has an abstract drive() method that both the Car() and Bike() have. The bike will print "Cycling along" while the car will print "(name) has started to drive." Without this version of polymorphism, you would need a bunch of if, if-else statements to get the same print statements depending on the type of vehicle. This makes it so the code isn't as bulky and is easy to interpret.

- 2. What I changed

- Implemented method overloading in the vehicle class. There are now 2 start() methods and 2 constructors now.
- Also implemented method overriding with the new Vehicle.start() and Truck.start().
- Added the Truck subclass with the towingCapacityLbs variable and an overiding toString()
- Added a scanner input where createCarFromInput() will prompt the user to build their own car and add it to the fleet.
- readValidInt() was added so the user has to enter a correct number for the loop to pass
- Writes all the vehicles to a csv file with the toCSV() method
- readVehiclesFromFile() reads the csv file and parseVehicle rebuilds the subclass from each line
- printFleetSummary() gives a total vehicle count, the average model year, the average miles per gallon across all cars

- 3. Method Overloading and Method Overriding

Overloading (same method name, different parameters, all in the Vehicle class):
- Constructors: Vehicle(String brand, int year) and Vehicle(String brand), which defaults the year
- start() and start(int speedMph), which starts the vehicle at a given speed

Overriding (a subclass replaces a method it inherits from Vehicle):
- start() is overridden in both Car and Truck so each type prints its own start message
- toString() is overridden in Car and Truck to add their extra fields to Vehicle's output
- toCSV() is overridden in Car and Truck so each one writes its own line format to the csv file

- 4. Challenges Encountered
(This is what the AI had problems with)

- The original `Vehicle` class kept `brand`/`year` as `private` fields with no getters, so `Car`/`Truck` couldn't access them directly to build a `toCSV()` string. I added `getBrand()`/`getYear()` to `Vehicle` rather than changing the fields to `protected`, to keep encapsulation intact while still giving subclasses (and `main`) read access.
- Designing a file format that could be both written and correctly read back required picking a simple CSV layout where the first field tags the vehicle type (`VEHICLE`, `CAR`, `TRUCK`), so `parseVehicle()` knows which constructor to call and how many fields to expect.
- Balancing "add validation" with "don't crash the whole program on bad file data" — I wrapped per-line parsing in a `try/catch` inside `readVehiclesFromFile()` so one bad line just gets skipped with a message instead of stopping the reload entirely.

- 5. Use of AI Tools
- Claude AI via VS Code was used to create the whole assignment.
- Gave Claude screenshots of the assignment and showed it what it could do. It ended up doing everything it could have done
- Pretty much everything code wise was made by Claude.

package nestedclasses.innerclasses;

public class CarExample {
    static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Test 3", 500);
        // Create an Engine tied to *that* Car
        Car.Engine engine  = car.new Engine();

        // Another way to create an engine
        //Car.Engine engine1 = new Car("Tesla 3", 500).new Engine();

        // Start the engine
        engine.start();

    }
}

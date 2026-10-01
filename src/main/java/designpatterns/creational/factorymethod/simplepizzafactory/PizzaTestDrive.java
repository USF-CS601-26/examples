package designpatterns.creational.factorymethod.simplepizzafactory;

// Example from Head First Design Patterns
public class PizzaTestDrive {
 
	static void main(String[] args) {
		PizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + System.lineSeparator());
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + System.lineSeparator());
	}
}

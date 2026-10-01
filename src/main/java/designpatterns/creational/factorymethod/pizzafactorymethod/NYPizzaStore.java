package designpatterns.creational.factorymethod.pizzafactorymethod;

/** A part of the Factory Method Pattern example.
 * From Head First Design Patterns book.
 */
public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}

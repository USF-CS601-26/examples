package designpatterns.creational.factorymethod.pizzafactorymethod;

/** A part of the Factory Method Pattern example.
 * From Head First Design Patterns book.
 */
public class ChicagoPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
        	if (type.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (type.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}

package designpatterns.creational.builder.withbuilder;

/** Driver class for the Builder Pattern */
public class Driver {
    public static void main(String[] args) {
        NutritionFacts.Builder builder = new NutritionFacts.Builder(20, 8);
        NutritionFacts nf = builder.calories(300).fat(10).build();
        System.out.println(nf);

        // Can do it in one line too:
        NutritionFacts nf1 = new NutritionFacts.Builder(20, 8)
                .calories(300)
                .fat(10)
                .build();
        System.out.println(nf1);
    }

}

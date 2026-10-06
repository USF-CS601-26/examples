package designpatterns.creational.builder.withlombok;

public class Main {
    static void main(String[] args) {
        // Creating an object using the Lombok-generated builder
        UserProfile user = UserProfile.builder()
                .firstName("Jane")
                .lastName("Doe")
                .email("jane.doe@example.com")
                .age(28)
                // .phoneNumber() can be skipped entirely if it's optional
                .build();

        System.out.println(user);
    }
}
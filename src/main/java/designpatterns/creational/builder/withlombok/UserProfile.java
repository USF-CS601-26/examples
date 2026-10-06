package designpatterns.creational.builder.withlombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString // Automatically generates a nice toString() method for debugging
public class UserProfile {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;
    private final String phoneNumber; // Optional field
}


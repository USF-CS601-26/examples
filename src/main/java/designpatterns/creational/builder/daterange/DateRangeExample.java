package designpatterns.creational.builder.daterange;

import java.time.LocalDate;

public class DateRangeExample {
    static void main(String[] args) {
        // Create a DataRange object using the builder pattern
        DateRange.Builder builder = new DateRange.Builder();
        DateRange range = builder.start(LocalDate.of(2026, 10, 1))
                .end(LocalDate.of(2026, 11, 1)).build();
        System.out.println(range);
    }
}

package designpatterns.creational.builder.daterange;

import java.time.LocalDate;

// Implement the Builder pattern
public class DateRange {
    private final LocalDate start; // make final
    private final LocalDate end; // make final

    // a private constructor that takes Builder
    private DateRange(Builder builder) {
        this.start = builder.start;
        this.end = builder.end;
    }

    @Override
    public String toString() {
        return start + " to " + end;
    }

    public static class Builder {
        private LocalDate start;
        private LocalDate end;

        public Builder() {
        }

        public Builder start(LocalDate date) {
            this.start = date;
            return this;
        }

        public Builder end(LocalDate date) {
            this.end = date;
            return this;
        }

        public DateRange build() {
            if (!start.isBefore(end))
                throw new IllegalArgumentException();
            return new DateRange(this);
        }

    }

}
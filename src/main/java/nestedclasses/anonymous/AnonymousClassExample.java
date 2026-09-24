package nestedclasses.anonymous;

import java.util.Comparator;

/** An example of an anonymous class. Shows a way to pass parameters to the object of the anonymous class.
 *  Anonymous classes can not have explicit constructors, so we discussed how to initialize objects. */
public class AnonymousClassExample {
    static void main(String[] args) {
        // Option 1: use initializer
        Comparator<Student> flexibleComp = new Comparator<Student>() {
            private String comparisonCriteria;

            Comparator<Student> init(String comparisonCriteria) {
                this.comparisonCriteria = comparisonCriteria;
                return this;
            }

            @Override
            public int compare(Student s1, Student s2) {
                if (comparisonCriteria.equals("name"))
                    return s1.getName().compareTo(s2.getName());
                else if (comparisonCriteria.equals("id"))
                    return s1.getId() - s2.getId();
                else {
                    double gpa1 = s1.getAverageGPA();
                    double gpa2 = s2.getAverageGPA();
                    if (Math.abs(gpa1 - gpa2) < 0.1) return 0;
                    else if (gpa1 < gpa2) return -1;
                    else return 1;
                }
            }
        }.init("name");


        // Option 2: Use final local variable
        final String criteria = "name";
        Comparator<Student> comp = new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                if (criteria.equals("name"))
                    return s1.getName().compareTo(s2.getName());
                else if (criteria.equals("id"))
                    return s1.getId() - s2.getId();
                else {
                    double gpa1 = s1.getAverageGPA();
                    double gpa2 = s2.getAverageGPA();
                    if (Math.abs(gpa1 - gpa2) < 0.1) return 0;
                    else if (gpa1 < gpa2) return -1;
                    else return 1;
                }
            }
        };
    }

}

package nestedclasses.anonymous;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorExample {

    static void main(String[] args) {
        // comp points to an object of an anonymous class
        Comparator<Student> comp = new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2) {
                 return s1.toString().compareTo(s2.toString());
            }
        };

        // A shorter way to write it:
       // Comparator<Student> comp = (s1, s2) -> s1.toString().compareTo(s2.toString());
        Set<Student> students1 = new TreeSet<>(comp);
        students1.add(new Student("Neha Singh", 0));
        students1.add(new Student ("Xue Liang", 1));
        students1.add(new Student("Allison K", 2));
        System.out.println(students1);

        System.out.println();

        // We can also use a shorter syntax, and pass directly to the TreeSet:
        Set<Student> students = new TreeSet<>((s1, s2) -> { return s1.toString().compareTo(s2.toString());});
        students.add(new Student("Neha Singh", 0));
        students.add(new Student ("Xue Liang", 1));
        students.add(new Student("Allison K", 2));
        System.out.println(students);
    }

}

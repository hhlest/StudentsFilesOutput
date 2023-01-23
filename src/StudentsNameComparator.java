import java.util.Comparator;

public class StudentsNameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        String name1 = s1.getLastName();
        String name2 = s2.getLastName();

        if (name1.compareTo(name2) > 0) {
            return 1;
        }

        if (name1.compareTo(name2) < 0) {
            return -1;
        }

        return 0;

    }
}

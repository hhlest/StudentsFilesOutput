import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private final Student[] students = new Student[3];

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent (Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException("No free space in the group.");
    }

    public Student searchStudentByLastName(String lastName) throws Exception {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        throw new StudentsNotFoundException("Student not found by last name.");
    }

    public Student searchStudent(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        return null;
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public Student[] sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsLast(new StudentsNameComparator()));
        return students;
    }

    @Override
    public String toString() {
        String result = "Group: " + groupName + "\n";
        for (Student student : students) {
            if (student != null) {
                result += student + "\n";
            }
        }
        return result;
    }
}

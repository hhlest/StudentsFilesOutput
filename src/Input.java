import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input implements FilePathConstants {

    public static void readInputAndCreateFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter group name: ");
        Group g = new Group(sc.next());

        while (true) {
            Student s = Input.readInputAndCreateStudent(g);

            try {
                g.addStudent(s);
            } catch (GroupOverflowException e) {
                e.printStackTrace();
            }

            System.out.println("Save to file? Y/N:");
            if (sc.next().equalsIgnoreCase("Y")) {
                FileOperator.createOutputFile(g);
                break;
            }
        }
    }

    public static Student readInputAndCreateStudent(Group g) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student's name: ");
        String name = sc.next();

        System.out.println("Enter student's lastname: ");
        String lastName = sc.next();

        Gender gender = null;
        try {
            System.out.println("Enter student's gender M/F: ");
            String gen = sc.next().toUpperCase();
            gender = Gender.valueOf(gen);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        int ID = 0;
        try {
            System.out.println("Enter student's ID: ");
            ID = sc.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return new Student(name, lastName, gender, ID, g.getGroupName());
    }
}

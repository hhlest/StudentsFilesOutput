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
                FileOperations.saveToFile(g);
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


    public static Group readInputFile() throws FileNotFoundException {
        Group groupFromFile = new Group();
        FileReader fr = new FileReader(INPUT_FILE_PATH);
        try (BufferedReader br = new BufferedReader(fr)) {
            Gender gender = null;
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] result = strLine.split(" ");

                String name = result[0];
                String lastName = result[1];
                if (result[2].equalsIgnoreCase("M")) {
                    gender = Gender.M;
                } else if (result[2].equalsIgnoreCase("F")) {
                    gender = Gender.F;
                } else {
                    gender = null;
                }

                int ID = Integer.parseInt(result[3]);
                String group = result[4];

                groupFromFile.setGroupName(result[4]);
                groupFromFile.addStudent(new Student(name, lastName, gender, ID, group));
            }

        } catch (IOException | GroupOverflowException e) {
            e.printStackTrace();
        }
        return groupFromFile;
    }

}

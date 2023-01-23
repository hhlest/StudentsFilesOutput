
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperations implements FilePathConstants {

    public static void createOutputFile(Group g) throws IOException {
        FileWriter f1 = new FileWriter(OUTPUT_FILE_PATH, true);
        PrintWriter pw = new PrintWriter(f1);
        pw.println(g);
        pw.flush();
    }

    public static void createInputFile(Group g) throws IOException {
        FileWriter f1 = new FileWriter(INPUT_FILE_PATH, true);
        PrintWriter pw = new PrintWriter(f1);
        pw.println(g);
        pw.flush();
    }

    public static void saveToFile(Group g) {
        try {
            FileOperations.createOutputFile(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nFile successfully saved:" + " " + OUTPUT_FILE_PATH);
    }
}

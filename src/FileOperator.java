
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperator implements FilePathConstants {

    public static void createOutputFile(Group g) {
        try (FileWriter f1 = new FileWriter(OUTPUT_FILE_PATH, true)) {
            PrintWriter pw = new PrintWriter(f1);
            pw.println(g);
            System.out.println("File successfully saved: " + OUTPUT_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("The file was not saved. \nCheck OUTPUT_FILE_PATH in constants.");
        }
    }
}

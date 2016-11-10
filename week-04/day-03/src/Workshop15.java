/**
 * Created by BB on 2016-11-10.
 */
import java.util.Scanner;
import java.io.*;

public class Workshop15 {
    public static void main(String[] args) {

        System.out.println("Enter the file path, or q to Quit.");

        Scanner userInput = new Scanner(System.in);
        String filePath;

        System.out.print("File path: ");

        while (userInput.hasNextLine()) {
            filePath = userInput.nextLine();
            if (filePath.equals("q"))
                break;
            printFileContent(filePath);
            System.out.print("File path: ");
        }
    }

    private static void printFileContent(String filePath) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e1) {
            System.out.println("File not found!");
        } catch (IOException e2) {
            System.out.println("Something went wrong!");
        }
    }
}

/**
 * Created by BB on 2016-11-09.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Workshop13 {

    public static void main(String[] args) {

        System.out.println("Please provide an absolute path and I will list the contents of it! (Type 'q' to quit)");

        Scanner userInput = new Scanner(System.in);

        String pathToList;

        System.out.print("Path: ");

        while(userInput.hasNextLine()){
            pathToList = userInput.nextLine();
            if(pathToList.equals("q"))
                break;
            printDirectoryContents(pathToList);
            System.out.print("Path: ");
        }
    }

    private static void printDirectoryContents(String pathToList) {

        File f = new File(pathToList);
        if (f.isFile()) {
            System.out.println("This is a file. Here are the contents of its parent folder.");
            f= new File(f.getParent());
        }
        File[] paths = f.listFiles();
        try {
            for(File path:paths) {
                 System.out.println(path);
            }
        } catch (NullPointerException e1) {
             System.out.println("The specified path does not exist.");
        }
    }
}

/**
 * Created by BB on 2016-11-10.
 */
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Workshop16 {

    public static void main(String[] args) {

        System.out.println("Enter the filename (assuming writing to C:\\Users\\BB\\Desktop\\Green Fox Academy), or q to Quit");

        Scanner userInput = new Scanner(System.in);

        String strNameOfFile;
        Integer ctCharacters;
        ctCharacters = 0;
        System.out.print("Path: ");

        while(userInput.hasNextLine()){
            strNameOfFile = userInput.nextLine();
            if(strNameOfFile.equals("q"))
                break;
//            writeStuff (strNameOfFile, ctCharacters);
            System.out.print("!!"); //complete this, remember the ctCharacters
        }


    }

//    private static void writeStuff (String pathToList, Integer ctCharacters) {
//        try {
//            File stuffToWrite = new File(pathToList);
//
//        }
        //open the file, blow up if already there

        //next Scanner While to take the input and transfer to the file
        // count the number of characters transferred
        // look for 3 empty strings in a row and then quit

        //after while close
//    }
}
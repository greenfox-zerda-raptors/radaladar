/**
 * Created by BB on 2016-11-17.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.greenfox.biczokb.todo.*;

public class AppMethods {

    public static ToDoList loadList(String fileName) {
        ToDoList list = new ToDoList();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.addToDo(new ToDoItem(line.split(" ", 2)[1]));
                if (line.split(" ", 2)[0].equals("1")) {
                 list.complete(list.size());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous ToDo list exists. Creating a new one.");
            return list;
        }
        return list;
    }

    public static void title() {
        System.out.println("=============");
        System.out.println("TODO LIST APP");
        System.out.println("=============");
    }

    public static void userInterface() {
        System.out.println("\n==================");
        System.out.println("Available commands");
        System.out.println("==================");
        System.out.println(" list or l      list all tasks");
        System.out.println(" add or a       add new task");
        System.out.println(" remove or r    remove task");
        System.out.println(" edit or e      edit task");
        System.out.println(" complete or c  complete task");
        System.out.println(" help or h      print out this list");
        System.out.println(" quit or q      save & quit program");
        System.out.println("==================");
    }

    public static ArrayList<String> inputParser(String menuAns) {
        ArrayList<String> parsedInput = new ArrayList<String>();
        int i = 2;
        if (menuAns.split(" ")[0].toLowerCase().equals("edit") || menuAns.split(" ")[0].toLowerCase().equals("e")) {
            i = 4;
        }
        for (String s : menuAns.split(" ", i)) {
            parsedInput.add(s);
        }
        return parsedInput;
    }

    public static void saveList(ToDoList list, String s) {
        try {
            File file = new File(s);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.printSave(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong. ¯\\_(ツ)_/¯ ");
        }
    }

    public static void quit(ToDoList list) {
        System.out.println("Bye!");
        System.out.println("::::PROGRAM END::::");
        System.exit(0);
    }

    public static void exceptionHandler(Exception e) {
        switch (e.getClass().getSimpleName()) {
            case "NumberFormatException":
                System.out.println("Incorrect format. Please enter a valid command.");
                break;
            case "ArrayIndexOutOfBoundsException" :
                System.out.println("This item does not exist. Please use a valid item number.");
                break;
            case "IndexOutOfBoundsException" :
                System.out.println("This item does not exist. Please use a valid item number.");
                break;
            default:
                System.out.println("Oops! Something went wrong. Please enter a valid command. " + e);
                break;
        }

    }
}

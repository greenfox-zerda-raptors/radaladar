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

    /// User interface stuff

    public static void title() {
        System.out.println("========================== B., Biczók - 2016");
        System.out.println("==                                        ==");
        System.out.println("==               TODO LIST                ==");
        System.out.println("==                                        ==");
    }

    public static void userInterface() {
        System.out.println("============================================");
        System.out.println("==           Available commands           ==");
        System.out.println("============================================");
        System.out.println(" list or l             list all tasks");
        System.out.println(" description or d      view task description");
        System.out.println(" add or a              add new task");
        System.out.println(" remove or r           remove task");
        System.out.println(" edit or e             edit task name/description");
        System.out.println(" complete or c         complete task");
        System.out.println(" swap or s             swap two tasks");
        System.out.println(" import or i           import existing todo list");
        System.out.println(" help or h             print out this list");
        System.out.println(" quit or q             save & quit program");
        System.out.println("============================================");
    }

    public static void quit() {
        System.out.println("============================================");
        System.out.println("==                  Bye!                  ==");
        System.out.println("============================================");
        System.out.println("==              PROGRAM END               ==");
        System.out.println("============================================");
        System.exit(0);
    }

    /// Parsing user input

    public static ArrayList<String> inputParser(String menuAns) {
        ArrayList<String> parsedInput = new ArrayList<String>();
        int i = 2;
        if (menuAns.split(" ")[0].toLowerCase().equals("edit") || menuAns.split(" ")[0].toLowerCase().equals("e")) {
            i = 4;
        } else if (menuAns.split(" ")[0].toLowerCase().equals("swap") || menuAns.split(" ")[0].toLowerCase().equals("s")){
            i = 3;
        }
        for (String s : menuAns.split(" ", i)) {
            parsedInput.add(s);
        }
        parsedInput.set(0, parsedInput.get(0).toLowerCase());
        return parsedInput;
    }

    /// Loading list and saving list

    public static ToDoList loadList(String fileName) {
        ToDoList list = new ToDoList();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if ((line.contains("///"))) {
                    list.addToDo(new ToDoItem(line.split(" ",2)[1].substring(0, line.split(" ",2)[1].indexOf("///")), line.split("///",2)[1]));
                } else {
                    list.addToDo(new ToDoItem(line.split(" ",2)[1]));
                }
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

    public static void importList (ToDoList list, String fileName) {
        String toLoad = "C:\\Users\\BB\\Desktop\\Green Fox Academy\\radaladar\\week-05\\project - ToDoApp\\" + fileName +".txt";
        ToDoList temp = loadList(toLoad);
        list.addList(temp);
        System.out.println("Todo list " + fileName + ".txt imported.");
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

    /// Exception Handling ///

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

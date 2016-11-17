/**
 * Created by BB on 2016-11-17.
 */

import com.greenfox.biczokb.todo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppToDo {

    public static void main(String[] args) {

        Scanner inputMenu = new Scanner(System.in);
        String menuAns;

        ToDoList list = new ToDoList();
        list = AppMethods.loadList("C:\\Users\\BB\\Desktop\\Green Fox Academy\\radaladar\\week-05\\project - ToDoApp\\todo.txt");

        AppMethods.title();
        AppMethods.userInterface();
        System.out.print("\n>>> ");

        while (inputMenu.hasNextLine()) {

            ArrayList<String> inputArray = new ArrayList<>();
            menuAns = inputMenu.nextLine();
            inputArray = AppMethods.inputParser(menuAns);

            try{
                switch (inputArray.get(0).toLowerCase()) {
                    case "list":
                    case "l":
                        list.printList();
                        break;
                    case "add":
                    case "a":
                        list.addToDo(new ToDoItem(inputArray.get(1)));
                        System.out.println("New item added.");
                        break;
                    case "remove":
                    case "r":
                        list.removeToDo(Integer.valueOf(inputArray.get(1)));
                        System.out.println("Item removed.");
                        break;
                    case "edit":
                    case "e":
                        list.editToDo(Integer.valueOf(inputArray.get(1)), inputArray.get(2), inputArray.get(3));
                        System.out.println("Item modified.");
                        break;
                    case "complete":
                    case "c":
                        list.complete(Integer.valueOf(inputArray.get(1)));
                        System.out.println("Item completed. Great job!");
                        break;
                    case "help":
                    case "h":
                        AppMethods.userInterface();
                        break;
                    case "quit":
                    case "q":
                        AppMethods.saveList(list,"C:\\Users\\BB\\Desktop\\Green Fox Academy\\radaladar\\week-05\\project - ToDoApp\\todo.txt");
                        AppMethods.quit(list);
                    default:
                        System.out.print("Please enter a valid command.");
                        break;
                }
            } catch (Exception e) {
                AppMethods.exceptionHandler(e);
            }
            System.out.print("\n>>> ");
        }
    }
}
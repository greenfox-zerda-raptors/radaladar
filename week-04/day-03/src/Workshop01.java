/**
 * Workshop: Revise Bana Exceptions examples
 * Step through this example.  This is taken directly from Bana Exceptions
 *
 * java.lang.RuntimeException : exceptions that can be thrown during the normal
 * operation of the Java Virtual Machine. These exceptions are your responsibility
 * as a programmer.
 *
 * Common Exceptions
 * ArithmeticException: An arithmetic operation occurs with no answer (Division by Zero)
 * ClassNotFoundException: A class is called for that doesn't exist
 * IllegalArgumentException: A method has been passed an illegal argument
 * IndexOutOfBoundsException: Thrown when an index for an array, string is called for, but doesn't exist
 * InputMismatchException: (Part of NoSuchElementException) User enters the wrong data type into a Scanner method
 * IOException: An I/O operation failed
 *
 * Answer these questions:
 * - What is a Run time error vs a Compile time Error
 * - How does the program below work
 *
 ******************************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;                       // Library that allows us to capture user input
import java.util.*;                             // Allows me to check for InputMismatchException
import java.io.*;                               // Allows for system input and output through data streams, serialization and the file system

public class Workshop01 {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        divideByZero(2);

        int age = checkValidAge();

        while (age == 0) {
            age = checkValidAge();
        }
        System.out.printf("You are %d years old", age);

        getAFile("./somestuff.txt");

    }

    public static void divideByZero(int a) {

        try {
            System.out.println(a / 0);
        } catch (ArithmeticException e) {
            System.out.println("no can do\n" + e.getMessage() + "\n" + e.toString() + "\n" );
        //            e.printStackTrace(); // this is its own print statement
        }
    }

    public static int checkValidAge() {
        System.out.println("Age?");

        try {
            return userInput.nextInt();
        } catch (InputMismatchException e) {
            userInput.next();
            System.out.println("That isn't a whole number");
            return 0;
        }

    }

    public static void getAFile(String fileName) {
        try {
		/* If I tried to do this without providing for an exception
		* I'd get the error Unhandled Exception Type FileNotFoundException
		* A checked exception is an exception the compiler forces you to protect against
		*/
            FileInputStream file = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry I couldn't find that file");
        }

        // You can catch numerous exceptions (List most specific first
        catch (IOException e) // Catches any IO Exception
        {
            System.out.println("An unknown IO Error Occured");
        }

		/* To ignore an exception do this
		 * catch (ClassNotFoundException e)
		 * {}
		 */

		/* Java 7 allows you to catch multiple exceptions at once
		 * catch (FileNotFoundException | IOException e)
		 * {}
		 */

        // This will catch any exception (This should always be last)
        catch (Exception e) {
            System.out.println("I catch every exception");
        }

        // If used finally is always executed whether there was an exception or not
        // It is used for clean up work like closing files and database connections
        finally {
            System.out.println("");
        }
    }
}

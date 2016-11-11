import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by BB on 2016-11-10.
 */

public class MatrixRotate {

    public static void main(String[] args) {

        Scanner inputMenu = new Scanner(System.in);
        String menuAns;

        System.out.println("********************\n" +
                           "********************\n" +
                           "** Welcome to the **\n" +
                           "** MATRIX ROTATOR **\n" +
                           "********************\n" +
                           "********************\n");
        System.out.println("Enter 1 to set matrix dimensions\n" +
                           "Enter 2 to input your own matrix\n" +
                           "Enter q to quit");
        System.out.print(">>> ");

        while (inputMenu.hasNextLine()) {
            menuAns = inputMenu.nextLine();
            switch (menuAns) {

                case "1":
                    System.out.println("\nPlease input the length (x) of your matrix!");
                    int x = getNum();
                    System.out.println("Please input the height (y) of your matrix!");
                    int y = getNum();
                    Object[][] matrix = new Object[y][x];
                    matrix = mCreator(y, x);
                    mRotator(matrix);
                    break;

                case "2":

                    System.out.println("\nPlease input your matrix one row at a time. Type \"!\" after last row.");
                    try {
                        Object[][] userMatrix = userMatrixCreator();
                        mRotator(userMatrix);
                    } catch (Exception e) {
                        System.out.println("Oops, something went wrong!");
                    }

                    break;

                case "q":
                    System.out.println("Bye!");
                    System.out.println("::::PROGRAM END::::");
                    System.exit(0);

                default:
                    System.out.println("Please enter valid input!\n");
            }
            System.out.println("Enter 1 to set matrix dimensions\n" +
                    "Enter 2 to input your own matrix\n" +
                    "Enter q to quit");
            System.out.print(">>> ");
        }
    }

    public static int getNum() {
        Scanner inputNum = new Scanner(System.in);
        int num = 0;
        while (num == 0) {
            try {
                System.out.print(">>> ");
                num = Integer.parseInt(inputNum.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("This makes no sense. Please provide valid input.");
            }
        }
        return num;
    }

    public static Object[][] mCreator(int y, int x) {
        Object[][] matrix = new Object[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                matrix[i][j] = (i + 1) * 10 + j + 1;
            }
        }
        return matrix;
    }

    public static Object[][] userMatrixCreator() {
        Scanner inputMatrix = new Scanner(System.in);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String toSplit = "";

        while (!(toSplit.equals("!"))) {
            System.out.print(">>> ");
            toSplit =inputMatrix.nextLine();
            if (toSplit.equals("!")) {
                break;
            }
            String[] splitArray = toSplit.split("\\s+");
            for (String str: splitArray) {
                arrayList.add(str);
            }
            arrayList.add("$");
        }

        int rowLengthCounter = 1;
        int rowCounter = 0;
        int longestRow = 0;

        for (Object o: arrayList) {
            if (o != "$") {
                if (rowLengthCounter > longestRow) {
                    longestRow = rowLengthCounter;
                }
                rowLengthCounter++;
            } else {
                rowLengthCounter = 1;
                rowCounter++;
            }
        }

        int objCount = 0;
        Object[][] outMatrix = new Object[rowCounter][longestRow];

        for (int i = 0; i < rowCounter; i++) {
            for (int j = 0; j < longestRow; j++) {
                if (arrayList.get(objCount) != "$") {
                    outMatrix[i][j] = arrayList.get(objCount);
                    objCount++;
                } else if (j < longestRow - 1 && (arrayList.get(objCount) == "$")) {
                    outMatrix[i][j] = "_";}
            }
            objCount++;
        }
        return outMatrix;
    }

    public static void mRotator(Object[][] matrix) {
        System.out.println("\nOriginal--------");
        mPrint(matrix);
        Object[][] newMatrix = new Object[matrix.length][matrix[0].length];

        for (int i = 1; i <= 3;i++){
            if (i % 2 == 1) {
                newMatrix = mTranspose(matrix);
                rowReverse(newMatrix);
                System.out.println("");
            } else {
                matrix = mTranspose(newMatrix);
                rowReverse(matrix);
                System.out.println("");
            }
            switch (i){

                case 1 :
                    System.out.println("1st Rotation--------");
                    mPrint(newMatrix);
                    break;

                case 2:
                    System.out.println("2nd Rotation--------");
                    mPrint(matrix);
                    break;

                case 3:
                    System.out.println("3rd Rotation--------");
                    mPrint(newMatrix);

                    break;
            }
        }
        System.out.println("");
    }

    public static void mPrint(Object[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == null || matrix[i][j] == "_") {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }

    public static Object[][] mTranspose(Object[][] oldMatrix) {
        int y = oldMatrix.length;
        int x = oldMatrix[0].length;
        Object[][] newMatrix = new Object[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                newMatrix[i][j] = oldMatrix[j][i];
            }
        }
        return newMatrix;
    }

    public static void rowReverse(Object[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y / 2; j++) {
                Object temp = matrix[i][j];
                matrix[i][j] = matrix[i][y - 1 - j];
                matrix[i][y - 1 - j] = temp;
            }
        }
    }
}

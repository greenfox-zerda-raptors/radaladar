/**
 * Created by BB on 2016-11-04.
 */
public class Workshop08 {
    public static void main(String[] args) {
        // Task 1: Create (dynamically) a two dimensional array with the following matrix. Use a loop!
        // 1 0 0 0
        // 0 1 0 0
        // 0 0 1 0
        // 0 0 0 1

        // Task 2: Print this two dimensional array to the output
        int rows = 4;
        int columns = 4;
        int[][] xy = new int[rows][columns];


        for (int i = 0; i < rows; i++) {
            String out = "";
            for (int j = 0; j < columns; j++){
                if (i == j) {
                    xy[i][j]++;
                }
                out += xy[i][j] + " ";
            }
            System.out.println(out);
        }

    }
}

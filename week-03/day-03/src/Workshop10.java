/**
 * Created by BB on 2016-11-04.
 */
public class Workshop10 {
    public static void main(String[] args) {
        // Task 1: Create an array (jagged) which can contain the different shades of specified colors
        // in colors[0] store the shades of green: "lime", "forest green", "olive", "pale green", "spring green"
        // in colors[1] store the shades of red: "orange red", "red", "tomato"
        // in colors[2] store the shades of pink: "orchid", "violet", "pink", "hot pink"

        int rows = 3;

        String[] green = {"lime", "forest green", "olive", "pale green", "spring green"};
        String[] red = {"orange red", "red", "tomato"};
        String[] pink = {"orchid", "violet", "pink", "hot pink"};

        String[] allColors = new String[green.length + red.length + pink.length];
        System.arraycopy(green, 0, allColors, 0, green.length);
        System.arraycopy(red, 0, allColors, green.length, red.length);
        System.arraycopy(pink, 0, allColors, green.length + red.length, pink.length);

        String[][] jaggedColors = new String[rows][];

        int[] sizes = {green.length, red.length, pink.length};

        int counter = 0;

        for (int i = 0; i < rows; i++) {
            String out = "";
            for (int j = 0; j < sizes[i]; j++) {
                jaggedColors[i] = new String[sizes[i]];
                jaggedColors[i][j] = allColors[counter];
                counter++;
                out += jaggedColors[i][j];
                if (j != sizes[i]-1) {
                    out += ", ";
                }
            }
            System.out.println(out);

        }
    }
}
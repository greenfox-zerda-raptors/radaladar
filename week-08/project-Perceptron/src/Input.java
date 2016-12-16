/// Created by BB on 2016-12-15.

public class Input {
    private double[] vector;
    private double actual;

    public Input(double[] row){
        vector = new double[row.length-1];
        for (int i = 0; i < row.length-2; i++) {
            vector[i] = row[i];
        }
        actual = row[row.length-1];
    }

    public double[] getVector() {
        return vector;
    }

    public double getActual() {
        return actual;
    }
}

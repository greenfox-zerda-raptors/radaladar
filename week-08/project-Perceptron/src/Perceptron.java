/// Created by BB on 2016-12-15.

import java.util.ArrayList;

public class Perceptron {
    private ArrayList<Input> inputData = new ArrayList<>();
    private static double learningRate = 0.01;
    private static int maxEpochs = 100;
    private double[] weights = new double[3];
    private double theta;

    public Perceptron(){}

    public void getInputData() {
        System.out.println("Connecting to SQL Server...");
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Loading data from row #" + i);
                Input inputRow = new Input(SQLHandler.loadDataRow(i, 3));
                inputData.add(inputRow);
            }
            System.out.println("Finished.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void training(){
        int epochs = 0;
        weights[0] = randomNumber(0, 1);
        weights[1] = randomNumber(0, 1);
        weights[2] = randomNumber(0, 1);
        System.out.println("Training start.");
        while (epochs != maxEpochs) {
            for (Input i : inputData) {
                double sum = summation(i);
                thresholding(sum);
                updateWeights(i, calculateError(i, sum));
            }
            System.out.println("...");
            epochs++;
        }
        System.out.println("Training finished on epoch #" + epochs);
    }

    public void categorizationTest(Input toCategorize) {
        System.out.println("Testing element.");
        double sum = summation(toCategorize);
        if (toCategorize.getActual() == thresholding(sum)) {
            System.out.println("Success.");
        } else {
            System.out.println("Failure.");
        }
    }

    private double summation(Input input) {
        double sum = 0;
        for (int i = 0; i < input.getVector().length; i++) {
            sum += input.getVector()[i] * weights[i];
        }
        sum += weights[weights.length-1];
        return sum;
    }

    private int thresholding(double sum) {
        if (sum >= theta) {
            return 1;
        } else {
            return 0;
        }
    }

    private double calculateError(Input input, double sum){
        double error = input.getActual() - sum;
        return error;
    }

    private void updateWeights(Input input, double error) {
        for (int i = 0; i < input.getVector().length; i++) {
            weights[i] += learningRate*error*input.getVector()[i];
        }
        weights[weights.length-1] *= learningRate*error;
    }

    private static double randomNumber(double min, double max){
        double d = min+Math.random()*(max-min);
        return d;
    }

}

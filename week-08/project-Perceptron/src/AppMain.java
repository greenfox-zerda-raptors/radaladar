/// Created by BB on 2016-12-15.

import java.util.ArrayList;

public class AppMain {

    public static void main(String[] args) {
        String dataFile = "src/randompoints_data.csv";
        String nameFile = "src/randompoints_name.csv";

        try {
            SQLHandler.createTable(CSVReader.readNames(nameFile));
            SQLHandler.populateTable(CSVReader.readData(dataFile));
            GraphingTest.plot();
            Perceptron p = new Perceptron();
            p.getInputData();
            p.training();
            ArrayList<double[]> testCases = generateTestCases();
            for (double[] test : testCases) {
                p.categorizationTest(new Input(test));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static ArrayList<double[]> generateTestCases(){
        ArrayList<double[]> testCases = new ArrayList<>();
        testCases.add(new double[]{-0.2509221885208677,-0.9404978704261859,1});
        testCases.add(new double[]{-0.5376026084808876,-0.32047476969735433,1});
        testCases.add(new double[]{-0.48426914738339977,-0.6095707223524962,1});
        testCases.add(new double[]{-0.9757356169486525,-0.5600779876442412,1});
        testCases.add(new double[]{-0.2913195273168021,-0.048017007305367954,1});
        testCases.add(new double[]{0.2515052373785429,0.7234534106341405,0});
        testCases.add(new double[]{0.7596262776836064,0.14976028829073298,0});
        testCases.add(new double[]{0.2282449551166078,0.44437327821341277,0});
        testCases.add(new double[]{0.8134344383705304,0.0359858624817285,0});
        testCases.add(new double[]{0.010226378393721449,0.612982203231447,0});
        return testCases;
    }
}

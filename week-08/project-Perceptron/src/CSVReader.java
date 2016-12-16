/// Created by BB on 2016-12-16.

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {

    public static ArrayList<String> readNames(String nameFile) throws Exception{
        BufferedReader br;
        String line;
        String cvsSplitBy = ",";
        ArrayList<String> names = null;

        System.out.println("Reading column labels from " + nameFile + "...");
        br = new BufferedReader(new FileReader(nameFile));
        while ((line = br.readLine()) != null) {
            names = new ArrayList<>(Arrays.asList(line.split(cvsSplitBy)));
        }
        br.close();
        System.out.println("Finished.");
        return names;
    }

    public static ArrayList<ArrayList<String>> readData(String dataFile) throws Exception{

        BufferedReader br;
        String line;
        String cvsSplitBy = ",";
        ArrayList<String> row;
        ArrayList<ArrayList<String>> dataRows = new ArrayList<>();

        System.out.println("Reading rows from " + dataFile + "...");
        br = new BufferedReader(new FileReader(dataFile));
        while ((line = br.readLine()) != null) {
            row = new ArrayList<>(Arrays.asList(line.split(cvsSplitBy)));
            dataRows.add(row);
        }
        br.close();
        System.out.println("Finished.");
        return dataRows;
    }
}

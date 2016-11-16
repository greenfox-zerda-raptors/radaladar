/**
 * Created by BB on 2016-11-16.
 */
import java.util.*;

public class Workshop05 {
    public static void main(String[] args) {
        List<String> tvModels= new ArrayList<String>();

        tvModels.add("Samsung S19E200BW");
        tvModels.add("LG 19MB35D");
        tvModels.add("NEC MultiSync EA193Mi");
        tvModels.add("Asus VE198S");

        System.out.println("Sort strings alphabetical --------");
        List<String> sortedList = tvModels.subList(0, tvModels.size());
        Collections.sort(sortedList);
        for (String str: sortedList) {
            System.out.println(str);
        }

        TvModel[] model = new TvModel[4];
        model[0]= new TvModel("Samsung S19E200BW", "19", 5);
        model[1]= new TvModel("LG 19MB35D", "18", 2);
        model[2]= new TvModel("NEC MultiSync EA193Mi", "18",8);
        model[3]= new TvModel("Asus VE198S", "17", 6);

        System.out.println("Sort objects by rtV4M --------");
        Arrays.sort(model);
        for( TvModel i: model) {
            System.out.println(i.toString());
        }

        System.out.println("Sort objects by name, with comparator --------");
        Arrays.sort(model, ModelNameComparator);
        for( TvModel i: model) {
            System.out.println(i.toString());
        }
    }

    public static Comparator<TvModel> ModelNameComparator = new Comparator<TvModel>() {
        public int compare (TvModel model1, TvModel model2) {
            String left = model1.getName().toUpperCase();
            String right = model2.getName().toUpperCase();
            return left.compareTo(right);
        }
    };
}

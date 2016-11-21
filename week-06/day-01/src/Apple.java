import java.util.ArrayList;

/**
 * Created by BB on 2016-11-21.
 */
public class Apple {
    public String name = "apple";
    public ArrayList<Integer> list = new ArrayList<>();

    public int sum() {
        int counter = 0;
        for (Integer i : this.list) {
            counter += i;
        }
        return counter;
    }

    public void add(int i) {
        this.list.add(i);
    }

    public String getName() {
        return name;
    }

    public int fibonacci(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (i == 2) {
            return 1;
        } else {
            return fibonacci(i-1)+fibonacci(i-2);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

}

package guava;

/**
 * Created by kicsen on 2016. 11. 30..
 */
public class Car {
    private long id;
    private String name;
    private int price;
    private String model;

    public Car(long id, String name, int price, String model) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

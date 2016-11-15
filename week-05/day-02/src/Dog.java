/**
 * Created by BB on 2016-11-15.
 */
public class Dog extends Animal {
    public boolean hasTail;

    public Dog() {
        super("Dog", 10, true);
    }

    public void speak(){
        System.out.println("This dog barks.");
    }
    public void beg(){
        System.out.println("This dog begs.");
    }

}

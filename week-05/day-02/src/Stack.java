import java.util.ArrayList;

/**
 * Created by BB on 2016-11-15.
 */
public class Stack {
    private ArrayList<Object> stack = new ArrayList<Object>(0);

    public Stack() {

    }

    public int size() {
        return stack.size();
    }

    public void push(Object o) {
        this.stack.add(0, o);
    }

    public Object pop() {
        Object o = this.stack.get(0);
        this.stack.remove(0);
        return o;
    }
}

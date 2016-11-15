/**
 * Created by BB on 2016-11-15.
 */
public class Workshop06 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.size());
        stack.push("aaa");
        stack.push("bbb");
        stack.push(1234);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}

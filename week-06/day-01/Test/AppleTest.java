import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BB on 2016-11-21.
 */
public class AppleTest {

    @Test
    public void fibonacci() throws Exception {
        Apple myObject = new Apple();
        assertEquals(13, myObject.fibonacci(7));
        assertEquals(0, myObject.fibonacci(0));
    }

    @Test
    public void sum() throws Exception {
        Apple myObject = new Apple();
        myObject.add(1);
        myObject.add(2);
        myObject.add(3);
        myObject.add(4);
        myObject.add(5);
        assertEquals(15, myObject.sum());
        Apple myObject2 = new Apple();
        assertEquals(0, myObject2.sum());
        Apple myObject3 = new Apple();
        myObject3.add(5);
        assertEquals(5, myObject3.sum());
        Apple myObject4 = new Apple();
        assertEquals(0, myObject4.sum());
    }

    @org.junit.Test
    public void getName() throws Exception {
        Apple apple = new Apple();
        assertEquals("apple", apple.getName());
    }

}
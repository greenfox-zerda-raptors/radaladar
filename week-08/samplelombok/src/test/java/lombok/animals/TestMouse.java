package lombok.animals;

import lombok.foods.Food;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class TestMouse {

    private Mouse mouse;

    @Before
    public void init() {
        mouse = new Mouse("Ciccc", 100, 200);
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Mouse(super=AbstractAnimal(name=Ciccc, birthDate=2016-12-15, children=[], movedDistanceInMilliMeters=0, happiness=200.0, weightInGram=100))";
        assertEquals(expected, mouse.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Mouse newMouse = new Mouse("Ciccc", 100, 200);
        assertEquals(newMouse, this.mouse);
    }

    @Test
    public void testHashCode() throws Exception {
        Mouse newMouse = new Mouse("Ciccc", 100, 200);
        assertEquals(newMouse.hashCode(), mouse.hashCode());
    }

    @Test
    public void testDeclaredMethod() throws Exception {
        assertTrue(Modifier.isPublic(Mouse.class.getDeclaredMethod("feed", Food.class).getModifiers()));
        assertTrue(Modifier.isPublic(Mouse.class.getDeclaredMethod("logOwnInfo").getModifiers()));
        assertTrue(Modifier.isProtected(Mouse.class.getDeclaredMethod("getMoveHappinessDecrease").getModifiers()));
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, Mouse.class.getDeclaredConstructors().length);
        AbstractAnimal.class.getDeclaredConstructor(String.class, Long.TYPE, Double.TYPE);
    }

    @Test
    public void testMove() throws Exception {
        mouse.move(100);
        assertEquals(3, mouse.getMoveHappinessDecrease());
        assertEquals(197D, mouse.getHappiness(), 0);
        assertEquals(0, mouse.getWeightInGram(), 0);
    }
}

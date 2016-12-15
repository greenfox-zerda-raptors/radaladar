package lombok.animals;

import lombok.foods.HorseFood;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class TestHorse {

    private Horse horse;

    @Before
    public void init() {
        horse = new Horse("Paci", 100000, 2300);
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Horse(super=AbstractAnimal(name=Paci, birthDate=2016-12-15, children=[], movedDistanceInMilliMeters=0, happiness=2300.0, weightInGram=100000))";
        assertEquals(expected, horse.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Horse newHorse = new Horse("Paci", 100000, 2300);
        assertEquals(newHorse, horse);
    }

    @Test
    public void testHashCode() throws Exception {
        Horse newHorse = new Horse("Paci", 100000, 2300);
        assertEquals(newHorse.hashCode(), horse.hashCode());
    }

    @Test
    public void testDeclaredMethod() throws Exception {
        assertTrue(Modifier.isPublic(Horse.class.getDeclaredMethod("feed", HorseFood.class).getModifiers()));
        assertTrue(Modifier.isPublic(Horse.class.getDeclaredMethod("logOwnInfo").getModifiers()));
        assertTrue(Modifier.isProtected(Horse.class.getDeclaredMethod("getMoveHappinessDecrease").getModifiers()));
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, Horse.class.getDeclaredConstructors().length);
        AbstractAnimal.class.getDeclaredConstructor(String.class, Long.TYPE, Double.TYPE);
    }

    @Test
    public void testMove() throws Exception {
        horse.move(100);
        assertEquals(1, horse.getMoveHappinessDecrease());
        assertEquals(2299D, horse.getHappiness(), 0);
        assertEquals(99900L, horse.getWeightInGram(), 0);
    }
}

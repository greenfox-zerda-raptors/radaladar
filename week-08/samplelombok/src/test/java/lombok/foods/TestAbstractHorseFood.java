package lombok.foods;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class TestAbstractHorseFood {

    @Test
    public void testGetters() throws Exception {
        assertEquals(LocalDate.class, AbstractHorseFood.class.getDeclaredMethod("getExpirationDate").getGenericReturnType());
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredNameSetter() throws Exception {
        AbstractHorseFood.class.getDeclaredMethod("setName", String.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredWeightSetter() throws Exception {
        AbstractHorseFood.class.getDeclaredMethod("setWeight", Long.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredCaloriesSetter() throws Exception {
        AbstractHorseFood.class.getDeclaredMethod("setCalories", Long.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredCreationDateSetter() throws Exception {
        AbstractHorseFood.class.getDeclaredMethod("setCreationDate", LocalDate.class);
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, AbstractHorseFood.class.getDeclaredConstructors().length);
        AbstractHorseFood.class.getDeclaredConstructor(String.class, Long.class, Long.class, Float.class, LocalDate.class);
    }
}

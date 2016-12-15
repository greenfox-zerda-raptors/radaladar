package lombok.foods;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class TestAbstractFood {

    @Test
    public void testGetters() throws Exception {
        assertEquals(String.class, AbstractFood.class.getDeclaredMethod("getName").getGenericReturnType());
        assertEquals(Long.class, AbstractFood.class.getDeclaredMethod("getWeight").getGenericReturnType());
        assertEquals(Long.class, AbstractFood.class.getDeclaredMethod("getCalories").getGenericReturnType());
        assertEquals(LocalDate.class, AbstractFood.class.getDeclaredMethod("getCreationDate").getGenericReturnType());
        assertEquals(Float.class, AbstractFood.class.getDeclaredMethod("getQualityMultiplier").getGenericReturnType());
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredGetExpirationDate() throws Exception {
        AbstractFood.class.getDeclaredMethod("getExpirationDate").getGenericReturnType();
    }

    @Test
    public void testSetQualityMultiplier() throws Exception {
        AbstractFood.class.getDeclaredMethod("setQualityMultiplier", Float.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredNameSetter() throws Exception {
        AbstractFood.class.getDeclaredMethod("setName", String.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredWeightSetter() throws Exception {
        AbstractFood.class.getDeclaredMethod("setWeight", Long.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredCaloriesSetter() throws Exception {
        AbstractFood.class.getDeclaredMethod("setCalories", Long.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredCreationDateSetter() throws Exception {
        AbstractFood.class.getDeclaredMethod("setCreationDate", LocalDate.class);
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(2, AbstractFood.class.getDeclaredConstructors().length);
        AbstractFood.class.getDeclaredConstructor(String.class, Long.class, Long.class, Float.class);
        AbstractFood.class.getDeclaredConstructor(String.class, Long.class, Long.class, LocalDate.class, Float.class);
    }
}

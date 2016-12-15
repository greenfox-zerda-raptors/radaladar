package lombok.animals;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import lombok.extern.java.Log;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;

/**
 * Created by kicsen on 2016. 12. 12..
 */
@Log
public class TestAbstractAnimal {

    @Test
    public void testGetters() throws Exception {
        Type listType = new TypeToken<ImmutableList<? extends Animal>>() {
        }.getType();

        assertEquals(String.class, AbstractAnimal.class.getDeclaredMethod("getName").getGenericReturnType());
        assertEquals(LocalDate.class, AbstractAnimal.class.getDeclaredMethod("getBirthDate").getGenericReturnType());
        assertEquals(listType, AbstractAnimal.class.getDeclaredMethod("getChildren").getGenericReturnType());
        assertEquals(Integer.class, AbstractAnimal.class.getDeclaredMethod("getChildrenNumber").getGenericReturnType());
        assertEquals(Long.class, AbstractAnimal.class.getDeclaredMethod("getMovedDistanceInMilliMeters").getGenericReturnType());
        assertEquals(Double.class, AbstractAnimal.class.getDeclaredMethod("getHappiness").getGenericReturnType());
        assertEquals(Long.class, AbstractAnimal.class.getDeclaredMethod("getWeightInGram").getGenericReturnType());
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredOwnInfo() throws Exception {
        AbstractAnimal.class.getDeclaredMethod("logOwnInfo").getGenericReturnType();
    }

    @Test
    public void testSetters() throws Exception {
        AbstractAnimal.class.getDeclaredMethod("setMovedDistanceInMilliMeters", Long.class);
        AbstractAnimal.class.getDeclaredMethod("setHappiness", Double.class);
        AbstractAnimal.class.getDeclaredMethod("setWeightInGram", Long.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredNameSetter() throws Exception {
        AbstractAnimal.class.getDeclaredMethod("setName", String.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredBirthDateSetter() throws Exception {
        AbstractAnimal.class.getDeclaredMethod("setBirthDate", String.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNonDeclaredChildrenSetter() throws Exception {
        AbstractAnimal.class.getDeclaredMethod("setChildren", String.class);
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, AbstractAnimal.class.getDeclaredConstructors().length);
        AbstractAnimal.class.getDeclaredConstructor(String.class, Long.TYPE, Double.TYPE);
    }

}

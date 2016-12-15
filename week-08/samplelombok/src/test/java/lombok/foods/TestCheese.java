package lombok.foods;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kicsen on 2016. 12. 13..
 */
public class TestCheese {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private Cheese cheese;

    @Before
    public void init() {
        cheese = Cheese.builder().weight(400L).calories(1200L).qualityMultiplier(4F).build();
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Cheese(super=AbstractFood(name=Cheese, weight=400, calories=1200, creationDate=" + new DateTime().toString("yyyy-MM-dd") + ", qualityMultiplier=4.0))";
        assertEquals(expected, cheese.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Cheese newCheese = Cheese.builder().weight(400L).calories(1200L).qualityMultiplier(4F).build();
        assertEquals(newCheese, cheese);
    }

    @Test
    public void testHashCode() throws Exception {
        Cheese newCheese = Cheese.builder().weight(400L).calories(1200L).qualityMultiplier(4F).build();
        assertEquals(newCheese.hashCode(), cheese.hashCode());
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, Cheese.class.getDeclaredConstructors().length);
        Cheese.class.getDeclaredConstructor(Long.class, Long.class, Float.class);
    }
}

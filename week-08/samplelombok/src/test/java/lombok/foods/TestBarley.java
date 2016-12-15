package lombok.foods;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kicsen on 2016. 12. 13..
 */
public class TestBarley {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private Barley barley;

    @Before
    public void init() {
        barley = Barley.builder().weight(2300L).qualityMultiplier(1.2F).expirationDate(LocalDate.parse("2017-12-12", dateTimeFormatter)).build();
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Barley(super=AbstractHorseFood(super=AbstractFood(name=Barley, weight=2300, calories=11500, creationDate=" + new DateTime().toString("yyyy-MM-dd") + ", qualityMultiplier=1.2), expirationDate=2017-12-12))";
        assertEquals(expected, barley.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Barley newBarley = barley = Barley.builder().weight(2300L).qualityMultiplier(1.2F).expirationDate(LocalDate.parse("2017-12-12", dateTimeFormatter)).build();
        assertEquals(newBarley, barley);
    }

    @Test
    public void testHashCode() throws Exception {
        Barley newBarley = barley = Barley.builder().weight(2300L).qualityMultiplier(1.2F).expirationDate(LocalDate.parse("2017-12-12", dateTimeFormatter)).build();
        assertEquals(newBarley.hashCode(), barley.hashCode());
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, Barley.class.getDeclaredConstructors().length);
        Barley.class.getDeclaredConstructor(Long.class, Float.class, LocalDate.class);
    }
}

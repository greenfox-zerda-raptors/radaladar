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
public class TestHay {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private Hay hay;

    @Before
    public void init() {
        hay = Hay.builder().weight(1000L).qualityMultiplier(1.1F).expirationDate(LocalDate.parse("2018-08-25", dateTimeFormatter)).build();
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Hay(super=AbstractHorseFood(super=AbstractFood(name=Hay, weight=1000, calories=2000, creationDate=" + new DateTime().toString("yyyy-MM-dd") + ", qualityMultiplier=1.1), expirationDate=2018-08-25))";
        assertEquals(expected, hay.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Hay newHay = hay = Hay.builder().weight(1000L).qualityMultiplier(1.1F).expirationDate(LocalDate.parse("2018-08-25", dateTimeFormatter)).build();
        assertEquals(newHay, hay);
    }

    @Test
    public void testHashCode() throws Exception {
        Hay newHay = hay = Hay.builder().weight(1000L).qualityMultiplier(1.1F).expirationDate(LocalDate.parse("2018-08-25", dateTimeFormatter)).build();
        assertEquals(newHay.hashCode(), hay.hashCode());
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, Hay.class.getDeclaredConstructors().length);
        Hay.class.getDeclaredConstructor(Long.class, Float.class, LocalDate.class);
    }
}

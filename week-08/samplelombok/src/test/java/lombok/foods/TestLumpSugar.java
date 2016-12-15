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
public class TestLumpSugar {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private LumpSugar lumpSugar;

    @Before
    public void init() {
        lumpSugar = LumpSugar.builder().weight(300L).qualityMultiplier(3F).expirationDate(LocalDate.parse("2017-09-25", dateTimeFormatter)).build();
    }

    @Test
    public void testToString() throws Exception {
        String expected = "LumpSugar(super=AbstractHorseFood(super=AbstractFood(name=LumpSugar, weight=300, calories=3900, creationDate=" + new DateTime().toString("yyyy-MM-dd") + ", qualityMultiplier=3.0), expirationDate=2017-09-25))";
        assertEquals(expected, lumpSugar.toString());
    }

    @Test
    public void testEquals() throws Exception {
        LumpSugar newLumpSugar = LumpSugar.builder().weight(300L).qualityMultiplier(3F).expirationDate(LocalDate.parse("2017-09-25", dateTimeFormatter)).build();
        assertEquals(newLumpSugar, lumpSugar);
    }

    @Test
    public void testHashCode() throws Exception {
        LumpSugar newLumpSugar = LumpSugar.builder().weight(300L).qualityMultiplier(3F).expirationDate(LocalDate.parse("2017-09-25", dateTimeFormatter)).build();
        assertEquals(newLumpSugar.hashCode(), lumpSugar.hashCode());
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals(1, LumpSugar.class.getDeclaredConstructors().length);
        LumpSugar.class.getDeclaredConstructor(Long.class, Float.class, LocalDate.class);
    }
}

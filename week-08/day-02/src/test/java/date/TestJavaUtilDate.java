package date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class TestJavaUtilDate {

    @Test
    public void testDateIsMutable() throws Exception {
        Date myDate = new GregorianCalendar(2009, Calendar.SEPTEMBER, 7).getTime();
        LOGGER.info("My date is: {}", myDate);
        anExternalMethod(myDate);
        LOGGER.info("It should not be changed... but: {}", myDate);
    }

    private static void anExternalMethod(Date inputDate) {
        LOGGER.info("anExternalMethod() is called");
        inputDate.setTime(new Date().getTime());
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TestJavaUtilDate.class);

}

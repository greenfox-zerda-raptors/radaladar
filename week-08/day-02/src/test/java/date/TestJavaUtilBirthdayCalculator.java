package date;

import com.google.common.base.Preconditions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public final class TestJavaUtilBirthdayCalculator {

    BirthdayCalculator<Date> birthdayCalculator = new BirthdayWithJavaUtilDate();

    @Test
    public void testParseDate() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = dateFormat.parse("2014-10-17");
        Date parsedDate = birthdayCalculator.parseDate("2014-10-17");
        assertEquals(expectedDate, parsedDate);
        parsedDate = birthdayCalculator.parseDate("nodate");
        assertEquals(null, parsedDate);
    }

    @Test
    public void printMonthAndDay() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = dateFormat.parse("2014-10-17");
        String monthAndDay = birthdayCalculator.printMonthAndDay(expectedDate);
        assertEquals("10. 17.", monthAndDay);
    }

    @Test
    public void testIsAnniversaryToday() throws Exception {
        GregorianCalendar gregorianCalendar = createPreviousYearGregorianCalendar();

        int mounth = gregorianCalendar.get(Calendar.MONTH);
        if (mounth + 1 <= gregorianCalendar.getActualMaximum(Calendar.MONTH)) {
            ++mounth;
        } else {
            --mounth;
        }
        gregorianCalendar.set(Calendar.MONTH, mounth);
        assertFalse(birthdayCalculator.isAnniversaryToday(gregorianCalendar.getTime()));

        siftCalendarWithDays(gregorianCalendar, 1);
        assertFalse(birthdayCalculator.isAnniversaryToday(gregorianCalendar.getTime()));

        gregorianCalendar = createPreviousYearGregorianCalendar();
        assertTrue(birthdayCalculator.isAnniversaryToday(gregorianCalendar.getTime()));

        gregorianCalendar = new GregorianCalendar();
        assertTrue(birthdayCalculator.isAnniversaryToday(gregorianCalendar.getTime()));
    }

    @Test
    public void testCalculateAgeInYears() throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        assertEquals(0, birthdayCalculator.calculateAgeInYears(gregorianCalendar.getTime()));

        gregorianCalendar = createPreviousYearGregorianCalendar();
        assertEquals(1, birthdayCalculator.calculateAgeInYears(gregorianCalendar.getTime()));

        siftCalendarWithDays(gregorianCalendar, 1);
        assertEquals(0, birthdayCalculator.calculateAgeInYears(gregorianCalendar.getTime()));

        gregorianCalendar = createPreviousYearGregorianCalendar();
        siftCalendarWithDays(gregorianCalendar, -1);
        assertEquals(1, birthdayCalculator.calculateAgeInYears(gregorianCalendar.getTime()));
    }

    @Test
    public void testCalculateDaysToNextAnniversary() throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Thread.sleep(1000);
        GregorianCalendar nextYearGregorianCalendar = createNextYearGregorianCalendar();
        // -1 day because elapsed time between the creation and evaluation
        int expectedDays = calculateDifference(gregorianCalendar, nextYearGregorianCalendar, TimeUnit.DAYS) - 1;
        assertEquals(expectedDays, birthdayCalculator.calculateDaysToNextAnniversary(gregorianCalendar.getTime()));

        siftCalendarWithDays(gregorianCalendar, 1);
        expectedDays = calculateDifference(new GregorianCalendar(), gregorianCalendar, TimeUnit.DAYS);
        assertEquals(expectedDays, birthdayCalculator.calculateDaysToNextAnniversary(gregorianCalendar.getTime()));
    }

    @Test
    public void testIsHolidayMarch15() throws Exception {
        Date march15Date = new GregorianCalendar(2015, 3, 15).getTime();
        assertNotSame(new Date(2015, 3, 15), march15Date);
    }

    private GregorianCalendar createPreviousYearGregorianCalendar() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.YEAR, gregorianCalendar.get(Calendar.YEAR) - 1);
        return gregorianCalendar;
    }

    private GregorianCalendar createNextYearGregorianCalendar() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.YEAR, gregorianCalendar.get(Calendar.YEAR) + 1);
        return gregorianCalendar;
    }

    private int calculateDifference(GregorianCalendar from, GregorianCalendar to, TimeUnit unit) {
        long difference = to.getTimeInMillis() - from.getTimeInMillis();
        return (int) (difference / unit.toMillis(1));
    }

    private void siftCalendarWithDays(GregorianCalendar calendar, final int days) {
        Preconditions.checkArgument(days <= calendar.getLeastMaximum(Calendar.DAY_OF_MONTH));
        int actualDay = calendar.get(Calendar.DAY_OF_MONTH);
        if (days > 0) {
            if (actualDay + days <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                calendar.set(Calendar.DAY_OF_MONTH, actualDay + days);
            } else {
                int mounth = calendar.get(Calendar.MONTH);
                if (mounth < calendar.getActualMaximum(Calendar.MONTH)) {
                    calendar.set(Calendar.MONTH, mounth + 1);
                } else {
                    calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
                }
            }
        } else {
            if ((actualDay + days) > 0) {
                calendar.set(Calendar.DAY_OF_MONTH, actualDay + days);
            } else {
                int mounth = calendar.get(Calendar.MONTH);
                if (mounth > calendar.getActualMinimum(Calendar.MONTH)) {
                    calendar.set(Calendar.MONTH, mounth - 1);
                } else {
                    calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
                }
            }
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TestJavaUtilBirthdayCalculator.class);
}

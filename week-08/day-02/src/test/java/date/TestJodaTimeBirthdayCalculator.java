package date;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kicsen on 2016. 11. 30..
 */
public class TestJodaTimeBirthdayCalculator {

    private static final String EXPECTED_DATE_STR = "2016-11-30";
    private static final LocalDate EXPECTED_DATE = LocalDate.parse(EXPECTED_DATE_STR, DateTimeFormat.forPattern("yyyy-MM-dd"));

    private BirthdayCalculator<LocalDate> birthdayCalculator = new BirthdayWithJodaTime();

    @Test
    public void testParseDate() throws Exception {
        assertEquals(EXPECTED_DATE, birthdayCalculator.parseDate(EXPECTED_DATE_STR));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDateNonDate() throws Exception {
        birthdayCalculator.parseDate("nonDate");
    }

    @Test(expected = NullPointerException.class)
    public void testParseDateWithNull() throws Exception {
        birthdayCalculator.parseDate(null);
    }

    @Test
    public void testPrintMonthAndDay() throws Exception {
        String monthAndDay = birthdayCalculator.printMonthAndDay(EXPECTED_DATE);
        assertEquals("11. 30.", monthAndDay);
    }

    @Test(expected = NullPointerException.class)
    public void testPrintMonthAndDayWithNull() throws Exception {
        birthdayCalculator.printMonthAndDay(null);
    }

    @Test
    public void testIsAnniversaryToday() throws Exception {
        String pattern = "MM. dd.";
        boolean expected = EXPECTED_DATE.toString(pattern).equals(LocalDate.now().toString(pattern));
        assertEquals(expected, birthdayCalculator.isAnniversaryToday(EXPECTED_DATE));
    }

    @Test(expected = NullPointerException.class)
    public void testIsAnniversaryTodayWithNull() throws Exception {
        birthdayCalculator.isAnniversaryToday(null);
    }

    @Test
    public void testCalculateAgeInYears() throws Exception {
        int expected = LocalDate.now().getYear() - EXPECTED_DATE.getYear();
        assertEquals(expected, birthdayCalculator.calculateAgeInYears(EXPECTED_DATE));
    }

    @Test(expected = NullPointerException.class)
    public void testCalculateAgeInYearsWithNull() throws Exception {
        birthdayCalculator.calculateAgeInYears(null);
    }

    @Test
    public void testCalculateDaysToNextAnniversary() throws Exception {
        int expected = getExpectedDaysToNextAnniversary(EXPECTED_DATE);
        assertEquals(expected, birthdayCalculator.calculateDaysToNextAnniversary(EXPECTED_DATE));

        LocalDate localDate = LocalDate.parse("1980-01-12", DateTimeFormat.forPattern("yyyy-MM-dd"));
        expected = getExpectedDaysToNextAnniversary(localDate);
        assertEquals(expected, birthdayCalculator.calculateDaysToNextAnniversary(localDate));

        localDate = LocalDate.now();
        expected = getExpectedDaysToNextAnniversary(localDate);
        assertEquals(expected, birthdayCalculator.calculateDaysToNextAnniversary(localDate));
    }

    private int getExpectedDaysToNextAnniversary(LocalDate date) {
        DateTime now = DateTime.now();
        int expected;
        if (now.getDayOfYear() == date.getDayOfYear()) {
            expected = 0;
        } else if (now.getDayOfYear() > date.getDayOfYear()) {
            DateTime end = new DateTime(now.getYear()+1, date.getMonthOfYear(), date.getDayOfMonth(), now.getHourOfDay(), now.getMinuteOfHour(), now.getSecondOfMinute()+1);
            Interval interval = new Interval(now, end);
            expected = (int) interval.toDuration().getStandardDays();
        } else {
            DateTime end = new DateTime(now.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), now.getHourOfDay(), now.getMinuteOfHour(), now.getSecondOfMinute());
            Interval interval = new Interval(now, end);
            expected = (int) interval.toDuration().getStandardDays();
        }
        return expected;
    }

    @Test(expected = NullPointerException.class)
    public void testCalculateDaysToNextAnniversaryWithNull() throws Exception {
        birthdayCalculator.calculateDaysToNextAnniversary(null);
    }

}

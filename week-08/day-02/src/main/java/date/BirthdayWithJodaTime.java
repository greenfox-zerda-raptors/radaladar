package date;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by kicsen on 2016. 11. 30..
 */
public class BirthdayWithJodaTime implements BirthdayCalculator<LocalDate> {

    @Override
    public LocalDate parseDate(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        LocalDate date = new LocalDate(str);
        return date;
    }

    @Override
    public String printMonthAndDay(LocalDate date) {
        return date.toString("MM. dd.");
    }

    @Override
    public boolean isAnniversaryToday(LocalDate date) {
        return printMonthAndDay(date).equals(printMonthAndDay(LocalDate.now()));
    }

    @Override
    public int calculateAgeInYears(LocalDate birthday) {
        if (birthday == null) {
            throw new NullPointerException();
        }
        return Years.yearsBetween(birthday, LocalDate.now()).getYears();
    }

    @Override
    public int calculateDaysToNextAnniversary(LocalDate date) {
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

    public static void main(String[] args) {
        new BirthdayWithJodaTime().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        LocalDate birthdayDate = parseDate(birthdayStr);
        print("Your birthday: " + printMonthAndDay(birthdayDate));

        if (isAnniversaryToday(birthdayDate)) {
            int ageInYears = calculateAgeInYears(birthdayDate);
            print("Congratulations! Today is your " + ageInYears + "th birthday!");
        } else {
            int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
            print("You have to wait only " + daysLeft + " days for your next birthday.");
        }
    }

    private void print(String line) {
        System.out.println(line);
    }

    private String readInput(String message) {
        System.out.print(message + ": ");
        return input.nextLine();
    }

    private final Scanner input = new Scanner(System.in, "UTF-8");
}

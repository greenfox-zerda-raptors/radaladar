package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class BirthdayWithJavaUtilDate implements BirthdayCalculator<Date> {

    @Override
    public Date parseDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date birthDay = format.parse(str);
            return birthDay;
        } catch (Exception e) {
            System.out.println("Unparseable using " + format);
            return null;
        }
    }

    @Override
    public String printMonthAndDay(Date date) {
        SimpleDateFormat monthDay = new SimpleDateFormat("MM. dd.");
        return monthDay.format(date);
    }

    @Override
    public boolean isAnniversaryToday(Date date) {
        Date today = Calendar.getInstance().getTime();
        return printMonthAndDay(date).equals(printMonthAndDay(today));
    }

    @Override
    public int calculateAgeInYears(Date birthday) {
        Date today = Calendar.getInstance().getTime();
        int year1 = today.getYear();
        int year2 = birthday.getYear();
        int age = year1 - year2;
        return age;
    }

    @Override
    public int calculateDaysToNextAnniversary(Date date) {
        Date today = Calendar.getInstance().getTime();
        date.setYear(today.getYear());
        if (!date.after(today)) {
            date.setYear(date.getYear()+1);
        }
        long diff = date.getTime() - today.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        new BirthdayWithJavaUtilDate().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        Date birthdayDate = parseDate(birthdayStr);
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

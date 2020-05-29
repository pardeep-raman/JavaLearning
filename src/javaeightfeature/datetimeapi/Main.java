package javaeightfeature.datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {
        localDateTime();
        zonedDateTime();
        checkDuration();
        checkPeriod();
        temporalAdjusters();
    }

    private static void localDateTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Current date is : " + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("Current time is : " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current date and time is : " + localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy HH:mm:ss");
        String dateTime = localDateTime.format(dateTimeFormatter);
        System.out.println(dateTime);

        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        dateTime = localDateTime.format(dateTimeFormatter);
        System.out.println(dateTime);

        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int seconds = localDateTime.getSecond();
        System.out.println("Current month : " + month + ", current day : " +
                day + ", current seconds : " + seconds);

        dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy");

        LocalDate newLocalDate = LocalDate.of(1950, 1, 26);
        System.out.println("Date with mentioned day,month and year :" + newLocalDate.format(dateTimeFormatter));

        LocalDateTime specificDate = localDateTime.withDayOfMonth(24).withYear(2016);
        System.out.println("Specific date with current time : " + specificDate.format(dateTimeFormatter));
    }

    private static void zonedDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy HH:mm");

        System.out.println(localDateTime.format(dateTimeFormatter));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current zone is : " + zonedDateTime.getZone());

        ZoneId zoneId = ZoneId.of("Asia/Bangkok");
        ZonedDateTime thailandZoneTime = zonedDateTime.withZoneSameInstant(zoneId);
        System.out.println("Thailand zone  with same instant is : " + thailandZoneTime.getZone());

        thailandZoneTime = zonedDateTime.withZoneSameLocal(zoneId);
        System.out.println("Thailand zone  with same local is : " + thailandZoneTime.getZone());
    }

    private static void checkPeriod() {
        LocalDate localDateCurrent = LocalDate.now();
        LocalDate localDateOld = LocalDate.of(2018, 4, 15);
        Period diff = Period.between(localDateOld, localDateCurrent);
        System.out.println("Difference between dates is : " + diff);
        System.out.println("Days difference between dates is : " + diff.getDays());
        System.out.println("Months difference between dates is : " + diff.getMonths());
        System.out.println("Year difference between dates is : " + diff.getYears());
        System.out.println("Total months between dates is : " + diff.toTotalMonths());

    }

    private static void checkDuration() {
        LocalTime localTimeCurrent = LocalTime.now();
        LocalTime localTimeOld = LocalTime.of(6, 21);
        Duration duration = Duration.between(localTimeOld, localTimeCurrent);

        System.out.println("Difference between time is : " + duration);
        System.out.println("Hours difference between time is : " + duration.toHours());
        System.out.println("Minutes difference between time is : " + duration.toMinutes());
//        System.out.println("Seconds difference between time is : "+duration.toSeconds()); // since java 9

        Duration duration2 = Duration.between(LocalTime.of(3, 11), localTimeCurrent);
        System.out.println("duration is " + compareDuration(duration, duration2) + " duration2");

    }

    private static String compareDuration(Duration duration1, Duration duration2) {
        switch (duration1.compareTo(duration2)) {
            case -1:
                return "Smaller than";
            case 0:
                return "Equal to";
            case 1:
                return "Greater than";
            default:
                return "uncomparable to";
        }
    }

    private static void temporalAdjusters(){
        LocalDate localDate = LocalDate.now();
        System.out.println("First day of next month is : "+localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("First day of month is : "+localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("First day of next year is : "+localDate.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.println("First day of year is : "+localDate.with(TemporalAdjusters.firstDayOfYear()));
    }
}

package javaeightfeature.datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        localDateTime();
        zonedDateTime();
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

        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime thailandZoneTime = zonedDateTime.withZoneSameInstant(zoneId);
        System.out.println("Thailand zone  with same instant is : " + thailandZoneTime.getZone());

        thailandZoneTime = zonedDateTime.withZoneSameLocal(zoneId);
        System.out.println("Thailand zone  with same local is : " + thailandZoneTime.getZone());

    }
}

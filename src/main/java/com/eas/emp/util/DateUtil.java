package com.eas.emp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
  public static final String DD_MM_YYYY = "dd-MM-yyyy";
  public static final String DD_MMM_YYYY = "dd-MMM-yyyy";
  public static final String DDMMYY = "ddMMyy";
  public static final String YYYY_MM_DD = "yyyy-MM-dd";
  public static final String YYYY_MMM_DD = "yyyy-MMM_dd";
  public static final String DDMMYYYY = "dd/MM/yyyy";
  public static final String hh_mm = "hh:mm";

  public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
  public static final TemporalAdjuster FIRST_DAY_OF_MONTH = TemporalAdjusters.firstDayOfMonth();
  public static final TemporalAdjuster FIRST_DAY_OF_YEAR = TemporalAdjusters.firstDayOfYear();
  public static final TemporalAdjuster FIRST_DAY_OF_NEXT_MONTH =
      TemporalAdjusters.firstDayOfNextMonth();
  public static final TemporalAdjuster FIRST_DAY_OF_NEXT_YEAR =
      TemporalAdjusters.firstDayOfNextYear();
  public static final TemporalAdjuster LAST_DAY_OF_MONTH = TemporalAdjusters.lastDayOfMonth();
  public static final TemporalAdjuster LAST_DAY_OF_YEAR = TemporalAdjusters.lastDayOfYear();

  private static Date simpleDate(LocalDate localDate) {
    ZonedDateTime zonedDateTime = localDate.atStartOfDay(DEFAULT_ZONE);
    Instant instant = zonedDateTime.toInstant();
    return Date.from(instant);
  }

  private static Date simpleDateTime(LocalDateTime localDateTime) {
    ZonedDateTime zonedDateTime = localDateTime.atZone(DEFAULT_ZONE);
    Instant instant = zonedDateTime.toInstant();
    return Date.from(instant);
  }

  private static LocalDate localDate(Date date) {
    Instant instant = date.toInstant();
    ZonedDateTime zonedDateTime = instant.atZone(DEFAULT_ZONE);
    return zonedDateTime.toLocalDate();
  }

  private static Date applicationServerDate() {
    LocalDate localDate = LocalDate.now();
    return simpleDate(localDate);
  }

  public static Date applicationServerDateTime() {
    LocalDateTime localDateTime = LocalDateTime.now();
    return simpleDateTime(localDateTime);
  }

  private static String DayOfWeekFullLength(Date date) {
    LocalDate localDate = localDate(date);
    Month month = localDate.getMonth();
    return month.name();
  }

  private static String monthOfYearFullLength(Date date) {
    LocalDate localDate = localDate(date);
    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    return dayOfWeek.name();
  }

  private static int weekOfMonth(Date date) {
    LocalDate localDate = localDate(date);
    TemporalField temporalField = WeekFields.of(Locale.getDefault()).weekOfMonth();
    return localDate.get(temporalField);
  }

  private static int weekOfYear(Date date) {
    LocalDate localDate = localDate(date);
    TemporalField temporalField = WeekFields.of(Locale.getDefault()).weekOfYear();
    return localDate.get(temporalField);
  }

  private static int monthOfYear(Date date) {
    LocalDate localDate = localDate(date);
    Month month = localDate.getMonth();
    return month.getValue();
  }

  private static String yearFullLength(Date date) {
    LocalDate localDate = localDate(date);
    Integer year = localDate.getYear();
    return year.toString();
  }

  private static String yearLength(Date date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
    LocalDate localDate = localDate(date);
    return localDate.format(formatter);
  }

  private Date convertStringToTime(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat(hh_mm);

    try {
      return sdf.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String getDiffTime(Date startDate, Date endDate) {

    Duration duration =
        Duration.between(
            Instant.ofEpochMilli(startDate.getTime()), Instant.ofEpochMilli(endDate.getTime()));

    long hours = duration.toHours();
    long minutes = duration.toMinutes() % 60;

    return String.format("%02d:%02d", hours, minutes);
  }

  public static Date convertStringToDate(String stringDate) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = dateFormat.parse(stringDate);
      // System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

      // String output = dateFormat.format(date);
      // System.out.println(output); // 2013-12-04
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }
}

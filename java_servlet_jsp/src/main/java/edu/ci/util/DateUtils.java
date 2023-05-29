package edu.ci.util;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtils {

  public static Date asDate(LocalDate localDate) {
    return Date.valueOf(localDate);
  }
  
  public static LocalDate asLocalDate(Date date) {
    return date.toLocalDate();
  }
}
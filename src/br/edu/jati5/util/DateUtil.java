package br.edu.jati5.util;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public interface DateUtil {
	
	public static LocalDateTime getDateTime(LocalDate localDate, LocalTime localTime) {
		return LocalDateTime.of(localDate, localTime);
	}
	
	public static java.util.Date parseToDate(LocalDateTime localDateTime){
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDateTime parseToLocalDateTime(java.util.Date date){
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public static LocalDate parseToLocalDate(java.util.Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static java.util.Date parseToDate(LocalDate localDate){
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static String getLocalDateString(String format, LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}
	
	public static String getLocalDateTimeString(String format, LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDateTime.format(formatter);
	}
	
	public static Date getDataAtual(){
		return getDateSQL(new java.util.Date());
	}
	
	public static java.util.Date getDate(String yyyy_MM_dd){
		java.util.Date date = null;
		try {
			date =  new SimpleDateFormat("yyyy-MM-dd").parse(yyyy_MM_dd);
		} catch (ParseException e) {}
		
		return date;
	}
	
	public static java.util.Date getDate(Date date){
		return new java.util.Date(date.getTime());
	}
	
	public static Date getDateSQL(String date) {
		return Date.valueOf(date);
	}
	
	public static Date getDateSQL(java.util.Date date) {
		if(date == null) date = new java.util.Date();
		return Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}
	
	public static String getDateString(String format, Date date) {
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String getDateString(String format, java.util.Date date) {
		return new SimpleDateFormat(format).format(date);
	}
	
	public static Date getDateTime(java.util.Date date) {
		return Date.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
	}
	
	public static java.util.Date getDateString(String format, String dateString) throws ParseException {
		return new SimpleDateFormat(format).parse(dateString);
	}
	
	public static java.util.Date getDateTime()
	{
		return new java.util.Date();
	}
		
	public static Date getDateSQL(LocalDate localDate)
	{
		return getDateSQL(parseToDate(localDate));
	}
	
	
}
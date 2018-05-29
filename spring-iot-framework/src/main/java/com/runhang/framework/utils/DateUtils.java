package com.runhang.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * 
 * @author runhang
 *
 */
public class DateUtils {

	private static final long DAY = 24 * 60 * 60 * 1000;

	/**
	 * 返回date1和date2相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int dayDiff(Date date1, Date date2) {
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		return (int) ((d1 - d2) / DAY);
	}
	
	/**
	 * 返回date1和date2相差的毫秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long milliDiff(Date date1, Date date2) {
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		return d1 - d2;
	}

	public static String toStringWithFormat(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static String toStringYMDHMS(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dateStr = dateFormat.format(date);
		return dateStr.replaceAll("-", "");
	}

	public static String toStringHMS(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}

	public static Date toDateYMDHMS(String dateStr) {
		return toDateYMDHMS(dateStr, "yyyyMMddHHmmss");
	}

	public static Date toDateYMDHMS(String dateStr, String partern) {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(partern);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date clearTime(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date rollupTime(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static int compareTime(String t1Str, String t2Str) {
		Date t1 = toTimeHMS(t1Str);
		Date t2 = toTimeHMS(t2Str);
		return t1.compareTo(t2);
	}

	public static Date nowTime() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	public static Date toTimeHMS(String dateStr) {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getTheDayBeforeNow(Integer day) {
		return new Date(new Date().getTime() - day * DAY);
	}

	public static Date getTheDayAfterNow(Integer day) {
		return new Date(new Date().getTime() + day * DAY);
	}

	public static String getTheDayAfterNowAsString(Integer day) {
		Date d = getTheDayAfterNow(day);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return dateFormat.format(d.getTime());
	}

	public static Date getTheTimeAfterNow(Integer minute) {
		String time = getTheTimeAfterNowAsString(minute);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		try {
			return dateFormat.parse(dateFormat.format(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getTheTimeAfterNowAsString(Integer minute) {
		Calendar calendar = Calendar.getInstance();
		int mi = calendar.get(Calendar.MINUTE);
		calendar.set(Calendar.MINUTE, mi - minute);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return dateFormat.format(calendar.getTime());
	}

	public static int compare(Date d1, Date d2) {
		return d1.compareTo(d2);
	}

	public static int compare(String d1Str, String d2Str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		try {
			Date d1 = dateFormat.parse(d1Str);
			Date d2 = dateFormat.parse(d2Str);
			return compare(d1, d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

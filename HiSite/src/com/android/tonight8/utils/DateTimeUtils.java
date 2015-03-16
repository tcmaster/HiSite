package com.android.tonight8.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

	/**
	 * 获取更新的时间
	 * 
	 * @param dateStr
	 * @return
	 * @throws Exception
	 */
	public static String getUpdateDate(Date date) {
		SimpleDateFormat DATA_FORMAT_ENYYMMDD = new SimpleDateFormat(
				"yyyy-MM-dd", Locale.getDefault());
		Calendar calendar = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (calendar.get(Calendar.YEAR) - cal.get(Calendar.YEAR) > 0) {
			return DATA_FORMAT_ENYYMMDD.format(date);
		} else if (calendar.get(Calendar.MONTH) - cal.get(Calendar.MONTH) > 0) {
			return DATA_FORMAT_ENYYMMDD.format(date);
		} else if (calendar.get(Calendar.DAY_OF_MONTH)
				- cal.get(Calendar.DAY_OF_MONTH) > 6) {
			return DATA_FORMAT_ENYYMMDD.format(date);
		} else if ((calendar.get(Calendar.DAY_OF_MONTH)
				- cal.get(Calendar.DAY_OF_MONTH) > 0)
				&& (calendar.get(Calendar.DAY_OF_MONTH)
						- cal.get(Calendar.DAY_OF_MONTH) < 6)) {
			int i = calendar.get(Calendar.HOUR_OF_DAY)
					- cal.get(Calendar.HOUR_OF_DAY);
			return i + "天前";
		} else if (calendar.get(Calendar.HOUR_OF_DAY)
				- cal.get(Calendar.HOUR_OF_DAY) > 0) {
			int i = calendar.get(Calendar.HOUR_OF_DAY)
					- cal.get(Calendar.HOUR_OF_DAY);
			return i + "小时前";
		} else if (calendar.get(Calendar.MINUTE) - cal.get(Calendar.MINUTE) > 0) {
			int i = calendar.get(Calendar.MINUTE) - cal.get(Calendar.MINUTE);
			return i + "分钟前";
		} else if (calendar.get(Calendar.SECOND) - cal.get(Calendar.SECOND) > 0) {
			int i = calendar.get(Calendar.SECOND) - cal.get(Calendar.SECOND);
			return i + "秒前";
		} else if (calendar.get(Calendar.SECOND) - cal.get(Calendar.SECOND) == 0) {
			return "刚刚";
		} else {
			return DATA_FORMAT_ENYYMMDD.format(date);
		}
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.getDefault());
		String dateString = formatter.format(dateDate);
		return dateString;
	}
}

package com.android.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 字符串处理工具
 * 
 * @author LiXiaoSong
 * 
 */
public class StringUtils {

	/**
	 * 获取更新的时间
	 * 
	 * @param dateStr
	 * @return
	 * @throws Exception
	 */
	public static String getDateString(Date date) {
		Calendar calendar = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (calendar.get(Calendar.YEAR) - cal.get(Calendar.YEAR) > 0) {
			return DateFormat.DATA_FORMAT_ENYYMMDD.format(date);
		} else if (calendar.get(Calendar.MONTH) - cal.get(Calendar.MONTH) > 0) {
			return DateFormat.DATA_FORMAT_ENYYMMDD.format(date);
		} else if (calendar.get(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH) > 6) {
			return DateFormat.DATA_FORMAT_ENYYMMDD.format(date);
		} else if ((calendar.get(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH) > 0) && (calendar.get(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH) < 6)) {
			int i = calendar.get(Calendar.HOUR_OF_DAY) - cal.get(Calendar.HOUR_OF_DAY);
			return i + "天前";
		} else if (calendar.get(Calendar.HOUR_OF_DAY) - cal.get(Calendar.HOUR_OF_DAY) > 0) {
			int i = calendar.get(Calendar.HOUR_OF_DAY) - cal.get(Calendar.HOUR_OF_DAY);
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
			return DateFormat.DATA_FORMAT_ENYYMMDD.format(date);
		}
	}

	/**
	 * 公共的日期时间格式化对象，都要使用以下现成的方法
	 * 
	 * @author:PengGuoHua
	 * @see:
	 * @since:
	 * @copyright © soufun.com
	 * @Date:2014-11-4
	 */
	interface DateFormat {

		/** 格式：yyyy-MM-dd HH:mm */
		public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
		/** 格式：yyyy/MM/dd HH:mm:ss */
		public static final SimpleDateFormat DATE_FORMAT_YMDHMS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
		/** 格式：yy-MM-dd hh:mm:ss */
		public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yy-MM-dd hh:mm:ss", Locale.getDefault());
		/** 格式：MM-dd HH:mm */
		public static final SimpleDateFormat DATE_FORMAT_MDHM = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
		/** 格式：yyyyMMdd */
		public static final SimpleDateFormat DATE_FORMAT_YMD = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
		/** 格式：yyyyMMddHHmmss */
		public static final SimpleDateFormat DATE_FORMAT_YYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
		/** 格式：EEEE */
		public static final SimpleDateFormat DATE_FORMAT_EEE = new SimpleDateFormat("EEEE", Locale.getDefault());
		/** 格式：HH:mm */
		public static final SimpleDateFormat DATE_FORMAT_HM = new SimpleDateFormat("HH:mm", Locale.getDefault());
		/** 格式：yyyy年MM月dd日 */
		public static final SimpleDateFormat DATA_FORMAT_CHINES_YYMMDD = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
		/** 格式：yyyy-MM-dd */
		public static final SimpleDateFormat DATA_FORMAT_ENYYMMDD = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	}
}

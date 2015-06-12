package com.android.tonight8.base;

public class AppConstants {

	/** 邮箱的正则表达式 */
	public static final String strEMAIL = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

	// 手机相关信息
	/** 手机的dpi */
	public static String dpi;
	/** 手机的宽度(像素) */
	public static int widthPx;
	/** 手机的高度(像素) */
	public static int heightPx;
	/** 应用版本号 */
	public static String version;
	/** 设备类型,这里固定是0，代表android设备 */
	public static String device_type = "0";
	/** imei号 */
	public static String imei;
	/** 操作系统版本 */
	public static String os_version;
	/** 手机型号 */
	public static String phone_model;
	/** md5 */
	public static String auth_code;
	/** 定位得到的城市名称 */
	public static String city_name;
	/** 定位得到的经度 */
	public static String longitude;
	/** 定位得到的纬度 */
	public static String latitude;
	/** 定位得到的地址信息 */
	public static String address;
	// --------------------------微信分享用的全局变量--------------------
	/** 微信分享支持的最低版本号(二进制编码) */
	public static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

	// --------------------------微博授权时所需要的参数--------------------
	/** 根目录 */
	public static final String ROOT_DIR_PATH = "/tonight8/res";
	/** 缓存目录 */
	public static final String CACHE_DIR_PATH = ROOT_DIR_PATH + "/cache";
	// --------------------------接口返回的参数--------------------
	/** 成功 */
	public static final String SUCCESS = "success";
	/** 失败 */
	public static final String FAIL = "fail";
	/** 错误 */
	public static final String ERROR = "error";
}

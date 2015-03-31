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
    /** 当前 DEMO 应用的 APP_KEY，第三方应用应该使用自己的 APP_KEY 替换该 APP_KEY */
    public static final String APP_KEY      = "2045436852";

    /** 
     * 当前 DEMO 应用的回调页，第三方应用可以使用自己的回调页。
     * 
     * <p>
     * 注：关于授权回调页对移动客户端应用来说对用户是不可见的，所以定义为何种形式都将不影响，
     * 但是没有定义将无法使用 SDK 认证登录。
     * 建议使用默认回调页：https://api.weibo.com/oauth2/default.html
     * </p>
     */
    public static final String REDIRECT_URL = "http://www.sina.com";

    /**
     * Scope 是 OAuth2.0 授权机制中 authorize 接口的一个参数。通过 Scope，平台将开放更多的微博
     * 核心功能给开发者，同时也加强用户隐私保护，提升了用户体验，用户在新 OAuth2.0 授权页中有权利
     * 选择赋予应用的功能。
     * 
     * 我们通过新浪微博开放平台-->管理中心-->我的应用-->接口管理处，能看到我们目前已有哪些接口的
     * 使用权限，高级权限需要进行申请。
     * 
     * 目前 Scope 支持传入多个 Scope 权限，用逗号分隔。
     * 
     * 有关哪些 OpenAPI 需要权限申请，请查看：http://open.weibo.com/wiki/%E5%BE%AE%E5%8D%9AAPI
     * 关于 Scope 概念及注意事项，请查看：http://open.weibo.com/wiki/Scope
     */
    public static final String SCOPE = 
            "email,direct_messages_read,direct_messages_write,"
            + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
            + "follow_app_official_microblog," + "invitation_write";
	// --------------------------微博授权时所需要的参数--------------------
    
	/** 根目录 */
	public static final String ROOT_DIR_PATH = "/tonight8/res";
	/** 缓存目录 */
	public static final String CACHE_DIR_PATH = ROOT_DIR_PATH + "/cache";

}

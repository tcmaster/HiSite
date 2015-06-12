/**
 * 2014-12-26
 */
package com.android.tonight8.model;

import java.io.Serializable;

/**
 * @Description: 网络实体类，存放最基本的参数，所有的其他网络实体类必需继承
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-26
 */
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/** success/fail/error */
	public String status;
	/** 中英文消息内容 */
	public String message;

}

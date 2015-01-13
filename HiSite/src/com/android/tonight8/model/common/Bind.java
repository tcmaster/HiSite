package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:商家绑定对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Bind extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 商家绑定状态 */
	public boolean status;
	/** 商家绑定日期 */
	public String date;
	/** 商家被绑定的父级商家id */
	public int parentId;
}

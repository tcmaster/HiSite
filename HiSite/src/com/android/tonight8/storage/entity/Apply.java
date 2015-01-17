package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 
 * @Description:
 * @author LiXiaoSong
 * @date 2015-1-17
 */
@Table(name = "appl=y")
public class Apply extends EntityBase {
	/***/
	@Column(column = "rid")
	@NotNull()
	@Foreign(column="rid",foreign="")
	private 
}

package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @author liuzhao
 * @date 2015-1-17
 */
public class ParentEntity extends BaseEntity {
	/** */
	@Foreign(column = "oid", foreign = "id")
	private OrgEntity org;
	/** */
	@NotNull
	private int rid;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
}

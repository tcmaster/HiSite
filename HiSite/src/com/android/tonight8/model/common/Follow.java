package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:关注对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Follow implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 关注id */
	public int id;
	/** 用户外键 */
	public int rid;
	/** 商家外键 */
	public int oid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "Follow [id=" + id + ", rid=" + rid + ", oid=" + oid + "]";
	}
}

package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 第三方账号
 */
@Table(name = "thirdpartyaccount")
public class ThirdPartyAccount extends EntityBase {
	/** 引用外键 user_id*/
	@Foreign(column = "rid", foreign = "id")
	private User user;
	/** 第三方账号类型 */
	@NotNull
	@Column(column = "type")
	private int type;
	/** 第三方账号账号 */
	@NotNull
	@Column(column = "account")
	private String account;
	/** 第三方账号访问地址（微博url，微信公众号地址） */
	@Column(column = "url")
	private String url;
	/** 是否授权 */
	@Column(column = "isGrant", defaultValue = "0")
	private int isGrant;
	/** 授权码 */
	@Column(column = "grantCode")
	private String grantCode;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIsGrant() {
		return isGrant;
	}
	public void setIsGrant(int isGrant) {
		this.isGrant = isGrant;
	}
	public String getGrantCode() {
		return grantCode;
	}
	public void setGrantCode(String grantCode) {
		this.grantCode = grantCode;
	}
	@Override
	public String toString() {
		return "ThirdPartyAccount [user=" + user + ", type=" + type
				+ ", account=" + account + ", url=" + url + ", isGrant="
				+ isGrant + ", grantCode=" + grantCode + "]";
	}
}

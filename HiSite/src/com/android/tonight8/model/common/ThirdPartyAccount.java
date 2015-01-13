package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description: 第三方账号对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class ThirdPartyAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 第三方账号类型 */
	public int type;
	/** 第三方账号账号 */
	public String account;
	/** 第三方账号访问地址（微博url，微信公众号地址） */
	public String url;
	/** 是否授权 */
	public boolean isGrant;
	/** 授权码 */
	public String grantCode;

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

	public boolean isGrant() {
		return isGrant;
	}

	public void setGrant(boolean isGrant) {
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
		return "ThirdPartyAccount [type=" + type + ", account=" + account
				+ ", url=" + url + ", isGrant=" + isGrant + ", grantCode="
				+ grantCode + "]";
	}

}

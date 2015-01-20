package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 用户
 */
@Table(name = "user")
public class UserEntity extends EntityBaseEntity {
	/** 用户名称 */
	@Column(column = "name")
	private String name;
	/** 用户性别 */
	@Column(column = "gender")
	private int gender;
	/** 用户头像图片文件地址 */
	@Column(column = "pic")
	private String pic;
	/** 用户手机 */
	@Column(column = "mobilePhone")
	@NotNull()
	private String mobilePhone;
	/** 用户邮箱 */
	@Column(column = "email")
	private String email;
	/** 用户邮寄地址 */
	@Column(column = "address")
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", pic=" + pic
				+ ", mobilePhone=" + mobilePhone + ", email=" + email
				+ ", address=" + address + "]";
	}

}

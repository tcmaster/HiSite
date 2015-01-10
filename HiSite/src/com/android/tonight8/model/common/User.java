package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 用户对象
 * 
 * @author LiXiaoSong
 * 
 */
public class User extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 用户账号id */
	public int id;
	/** 用户名称 */
	public String name;
	/** 用户性别 */
	public boolean gender;
	/** 用户头像图片文件地址 */
	public String pic;
	/** 用户地理坐标 */
	public String coordinate;
	/** 用户手机 */
	public String mobilePhone;
	/** 用户邮箱 */
	public String email;
	/** 用户邮寄地址 */
	public String address;
	/** 用户密码 */
	public String password;
	/** 用户账号验证状态 */
	public boolean status;
	/** 用户手机验证码 */
	public String registValidateCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRegistValidateCode() {
		return registValidateCode;
	}

	public void setRegistValidateCode(String registValidateCode) {
		this.registValidateCode = registValidateCode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", pic=" + pic + ", coordinate=" + coordinate
				+ ", mobilePhone=" + mobilePhone + ", email=" + email
				+ ", address=" + address + ", password=" + password
				+ ", status=" + status + ", registValidateCode="
				+ registValidateCode + "]";
	}

}

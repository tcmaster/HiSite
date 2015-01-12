package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 商家对象
 * 
 * @author LiXiaoSong
 * 
 */
public class Org extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 商家id */
	public int id;
	/** 商家名称 */
	public String name;
	/** 商家简介 */
	public String description;
	/** 商家logo图片文件地址 */
	public String logo;
	/** 商家头像图片文件地址 */
	public String pic;
	/** 商家所地地理坐标 */
	public String coordinate;
	/** 商家距离 */
	public float distance;
	/** 商家地址 */
	public String address;
	/** 商家固定电话 */
	public String telphone;
	/** 商家邮箱 */
	public String email;
	/** 商家联系人 */
	public String contactPerson;
	/** 商家联系手机 */
	public String contactMobilPhone;
	/** 商家密码 */
	public String password;
	/** 商家注册手机验证码 */
	public String registValidateCode;
	/** 商家企业证件照图片文件地址 */
	public String paperPhoto;
	/** 商家企业营业执照证件编号 */
	public String paperCode;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactMobilPhone() {
		return contactMobilPhone;
	}

	public void setContactMobilPhone(String contactMobilPhone) {
		this.contactMobilPhone = contactMobilPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistValidateCode() {
		return registValidateCode;
	}

	public void setRegistValidateCode(String registValidateCode) {
		this.registValidateCode = registValidateCode;
	}

	public String getPaperPhoto() {
		return paperPhoto;
	}

	public void setPaperPhoto(String paperPhoto) {
		this.paperPhoto = paperPhoto;
	}

	public String getPaperCode() {
		return paperCode;
	}

	public void setPaperCode(String paperCode) {
		this.paperCode = paperCode;
	}

	@Override
	public String toString() {
		return "Org [id=" + id + ", name=" + name + ", description="
				+ description + ", logo=" + logo + ", pic=" + pic
				+ ", coordinate=" + coordinate + ", distance=" + distance
				+ ", address=" + address + ", telphone=" + telphone
				+ ", email=" + email + ", contactPerson=" + contactPerson
				+ ", contactMobilPhone=" + contactMobilPhone + ", password="
				+ password + ", registValidateCode=" + registValidateCode
				+ ", paperPhoto=" + paperPhoto + ", paperCode=" + paperCode
				+ "]";
	}

}

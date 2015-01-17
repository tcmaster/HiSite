package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17
 */
@Table(name = "org")
public class Org extends EntityBase {
	/** 商家名称 */
	@Column(column = "name")
	@NotNull
	public String name;
	/** 商家简介 */
	@NotNull
	@Column(column = "intro")
	public String intro;
	/** 商家logo图片文件地址 */
	@NotNull
	@Column(column = "logo")
	public String logo;
	/** 商家头像图片文件地址 */
	@Column(column = "pic")
	@NotNull
	public String pic;
	/** 商家所地地理坐标 */
	@Column(column = "coordinate")
	@NotNull
	public String coordinate;
	/** 商家地址 */
	@Column(column = "address")
	@NotNull
	public String address;
	/** 商家固定电话 */
	@Column(column = "telphone")
	@NotNull
	public String telphone;
	/** 商家邮箱 */
	@NotNull
	@Column(column = "email")
	public String email;
	/** 商家联系人 */
	@NotNull
	@Column(column = "contactPerson")
	public String contactPerson;
	/** 商家联系手机 */
	@NotNull
	@Column(column = "contactMobilPhone")
	public String contactMobilPhone;
	/** 商家企业证件照图片文件地址 */
	@Column(column = "paperPhoto")
	public String paperPhoto;
	/** 商家企业营业执照证件编号 */
	@Column(column = "paperCode")
	public String paperCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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
}

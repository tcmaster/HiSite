package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17
 * 商家数据库表
 */
@Table(name = "org")
public class OrgEntity extends BaseEntity {

	/** 商家名称 */
	@Column(column = "name")
	private String name;
	/** 商家简介 */
	@Column(column = "intro")
	private String intro;
	/** 商家logo图片文件地址 */
	@Column(column = "logo")
	private String logo;
	/** 商家头像图片文件地址 */
	@Column(column = "pic")
	private String pic;
	/** 商家所地地理坐标 */
	@Column(column = "coordinate")
	private String coordinate;
	/** 省份编码 */
	@Column(column = "provinceCode")
	private String provinceCode;
	/** 城市编码 */
	@Column(column = "cityCode")
	private String cityCode;
	/** 地区编码 */
	@Column(column = "areaCode")
	private String areaCode;
	/** 商家地址 */
	@Column(column = "address")
	private String address;
	/** 商家固定电话 */
	@Column(column = "telphone")
	private String telphone;
	/** 商家邮箱 */
	@Column(column = "email")
	private String email;
	/** 商家联系人 */
	@Column(column = "contactPerson")
	private String contactPerson;
	/** 商家联系手机 */
	@Column(column = "contactMobilPhone")
	private String contactMobilPhone;
	/** 商家企业证件照图片文件地址 */
	@Column(column = "paperPhoto")
	private String paperPhoto;
	/** 商家企业营业执照证件编号 */
	@Column(column = "paperCode")
	private String paperCode;
	/** 身份类型 */
	@Column(column = "identityType")
	private int identityType;
	/** 身份编码 */
	@Column(column = "identityCode")
	private String identityCode;
	/** 该商家的某个兑奖对象 */
	@Column(column = "exchangeId")
	private String exchangeId;
	/** 商家身份证照正面图片文件地址 */
	@Column(column = "identityPhotoFront")
	private String identityPhotoFront;
	/** 商家身份证照反面图片文件地址 */
	@Column(column = "identityPhotoReverse")
	private String identityPhotoReverse;

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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getIdentityType() {
		return identityType;
	}

	public void setIdentityType(int identityType) {
		this.identityType = identityType;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getIdentityPhotoFront() {
		return identityPhotoFront;
	}

	public void setIdentityPhotoFront(String identityPhotoFront) {
		this.identityPhotoFront = identityPhotoFront;
	}

	public String getIdentityPhotoReverse() {
		return identityPhotoReverse;
	}

	public void setIdentityPhotoReverse(String identityPhotoReverse) {
		this.identityPhotoReverse = identityPhotoReverse;
	}

	@Override
	public String toString() {
		return "OrgEntity [name=" + name + ", intro=" + intro + ", logo="
				+ logo + ", pic=" + pic + ", coordinate=" + coordinate
				+ ", provinceCode=" + provinceCode + ", cityCode=" + cityCode
				+ ", areaCode=" + areaCode + ", address=" + address
				+ ", telphone=" + telphone + ", email=" + email
				+ ", contactPerson=" + contactPerson + ", contactMobilPhone="
				+ contactMobilPhone + ", paperPhoto=" + paperPhoto
				+ ", paperCode=" + paperCode + ", identityType=" + identityType
				+ ", identityCode=" + identityCode + ", exchangeId="
				+ exchangeId + ", identityPhotoFront=" + identityPhotoFront
				+ ", identityPhotoReverse=" + identityPhotoReverse + "]";
	}

}

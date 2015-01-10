/**
 * 2015-1-6
 */
package com.android.tonight8.dbentity;

import com.lidroid.xutils.db.annotation.Id;

/**
 * @Description:定位得到的城市信息
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2015-1-6
 */
public class Table_MyCity {

	@Id
	private int id;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 地址
	 */
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Table_MyCity [city=" + city + ", longitude=" + longitude + ", latitude=" + latitude + ", address=" + address + "]";
	}
}

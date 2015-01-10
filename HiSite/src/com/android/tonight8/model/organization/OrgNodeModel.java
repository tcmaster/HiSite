package com.android.tonight8.model.organization;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Area;
import com.android.tonight8.model.common.Bind;
import com.android.tonight8.model.common.City;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Province;

/**
 * 商家经销商
 */
public class OrgNodeModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	/** 商家对象*/
	public Org org;
	/** 省份对象*/
	public Province province;
	/** 城市对象*/
	public City city;
	/** 地区对象*/
	public Area area;
	/** 绑定对象*/
	public Bind bind;
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Bind getBind() {
		return bind;
	}
	public void setBind(Bind bind) {
		this.bind = bind;
	}
	
}

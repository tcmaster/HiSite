package com.android.tonight8.model.organization;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Bind;
import com.android.tonight8.model.common.BindTree;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Regional;

/**
 * 商家经销商
 */
public class OrgNodeModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 商家对象 */
	public Org org;
	/** 省份对象 */
	public Regional province;
	/** 城市对象 */
	public Regional city;
	/** 地区对象 */
	public Regional area;
	/** 绑定对象 */
	public Bind bind;
	/** 商家绑定树对象 */
	public BindTree bindTree;
	
	
	public BindTree getBindTree() {
		return bindTree;
	}

	
	public void setBindTree(BindTree bindTree) {
		this.bindTree = bindTree;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Regional getProvince() {
		return province;
	}

	public void setProvince(Regional province) {
		this.province = province;
	}

	public Regional getCity() {
		return city;
	}

	public void setCity(Regional city) {
		this.city = city;
	}

	public Regional getArea() {
		return area;
	}

	public void setArea(Regional area) {
		this.area = area;
	}

	public Bind getBind() {
		return bind;
	}

	public void setBind(Bind bind) {
		this.bind = bind;
	}

}

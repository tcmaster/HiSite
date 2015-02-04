/**
 * 2015-2-4
 */
package com.android.tonight8.io.common.entity;

import java.util.List;

import com.android.tonight8.io.net.NetEntityBase;

/**
 * @Description: 省市区接口结构
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class RegionalNetEntity extends NetEntityBase {

	private List<ArrayData> common_regional;

	public List<ArrayData> getCommon_regional() {
		return common_regional;
	}

	public void setCommon_regional(List<ArrayData> common_regional) {
		this.common_regional = common_regional;
	}

	@Override
	public String toString() {
		return "RegionalNetEntity [common_regional=" + common_regional + "]";
	}

}

/**
 * 2015-2-4
 */
package com.android.tonight8.io.common.entity;


/**
 * @Description: 省市区接口结构
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class RegionalNetEntity {

	private ArrayData common_regional;

	public ArrayData getCommon_regional() {
		return common_regional;
	}

	public void setCommon_regional(ArrayData common_regional) {
		this.common_regional = common_regional;
	}

	@Override
	public String toString() {
		return "RegionalNetEntity [common_regional=" + common_regional + "]";
	}

}

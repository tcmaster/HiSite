/**
 * 2015-2-4
 */
package com.android.tonight8.io.common.entity;

import java.util.ArrayList;

import com.android.tonight8.model.common.Regional;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class ArrayData {

	private ArrayList<Regional> regional;

	public ArrayList<Regional> getRegional() {
		return regional;
	}

	public void setRegional(ArrayList<Regional> regional) {
		this.regional = regional;
	}

	@Override
	public String toString() {
		return "ArrayData [regional=" + regional + "]";
	}
}

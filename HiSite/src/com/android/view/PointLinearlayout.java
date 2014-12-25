/**
 * 2014-12-25
 */
package com.android.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.android.hisite.R;

/**
 * @Description:带有若干点的线性布局（配合ViewPager使用）
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-25
 */
public class PointLinearlayout extends LinearLayout {

	/** 本界面的点集合 */
	private List<ImageView> list_iv;
	/** 点的个数，默认为0 */
	private int pointCount = 0;

	public PointLinearlayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		list_iv = new ArrayList<ImageView>();
	}

	/**
	 * 
	 * @Description:设置点的数量
	 * @param count
	 *            数量值
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	public void setPointCount(int count) {
		pointCount = count;
		update();
	}

	/**
	 * @Description:在修改数量的时候，更新界面
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private void update() {
		list_iv.clear();
		this.removeAllViews();
		for (int i = 0; i < pointCount; i++) {
			ImageView iv = new ImageView(getContext());
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			iv.setLayoutParams(lp);
			iv.setScaleType(ScaleType.FIT_XY);
			iv.setImageResource(R.drawable.point_white);
			list_iv.add(iv);
			this.addView(iv, i);
		}
	}

	/**
	 * @Description:改变某个点的图像
	 * @param pos
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	public void changePoint(int pos) {
		for (int i = 0; i < list_iv.size(); i++) {
			if (i == pos)
				list_iv.get(i).setImageResource(R.drawable.point_black);
			else
				list_iv.get(i).setImageResource(R.drawable.point_white);
		}
	}
}

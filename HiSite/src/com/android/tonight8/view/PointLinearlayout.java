/**
 * 2014-12-25
 */
package com.android.tonight8.view;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.R;
import com.android.tonight8.base.AppConstants;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

/**
 * @Description:带有若干点的线性布局（配合ViewPager使用）
 * @author:LiXiaoSong
 * @copyright @tonight8
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
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
					android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
			iv.setLayoutParams(lp);
			iv.setScaleType(ScaleType.FIT_XY);
			iv.setImageResource(R.drawable.rb_point_h);
			if (AppConstants.widthPx <= 480) {
				iv.setPadding(10, 0, 0, 10);
			} else
				iv.setPadding(25, 0, 0, 25);
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
				list_iv.get(i).setImageResource(R.drawable.rb_point_n);
			else
				list_iv.get(i).setImageResource(R.drawable.rb_point_h);
		}
	}
}

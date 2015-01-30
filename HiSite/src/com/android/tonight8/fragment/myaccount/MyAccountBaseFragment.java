/**
 * 2015-1-12
 */
package com.android.tonight8.fragment.myaccount;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.utils.StringUtils;

/**
 * @Description: 该fragment封装了一些"我"中所用到的特有的方法
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-12
 */
public class MyAccountBaseFragment extends BaseFragment {

	/**
	 * 
	 * @Description:设置“我”中专门的include控件的内容,为空的话，则该项自动隐藏
	 * @param includeView
	 *            要进行设置的视图
	 * @param leftRes
	 *            左边的文字
	 * @param leftLogo
	 *            左边的图片
	 * @param rightPoint
	 *            右边的红点文字
	 * @param rightText
	 *            右边的文字
	 * @author: LiXiaoSong
	 * @date:2015-1-12
	 */
	protected void setTextAndContent(View includeView, int leftRes, int leftLogo, String rightPoint, String rightText) {
		if (includeView == null)
			return;
		ImageView iv_left = (ImageView) includeView.findViewById(R.id.iv_left_icon);
		TextView tv_left = (TextView) includeView.findViewById(R.id.tv_left_text);
		TextView tv_right = (TextView) includeView.findViewById(R.id.tv_right_text);
		TextView tv_right_point = (TextView) includeView.findViewById(R.id.tv_red_point_text);
		if (leftRes <= 0)
			tv_left.setVisibility(View.INVISIBLE);
		else
			tv_left.setText(leftRes);
		if (StringUtils.isNullOrEmpty(rightPoint))
			tv_right_point.setVisibility(View.GONE);
		else
			tv_right_point.setText(rightPoint);
		if (leftLogo <= 0)
			iv_left.setVisibility(View.INVISIBLE);
		else
			iv_left.setImageResource(leftLogo);
		if (StringUtils.isNullOrEmpty(rightText))
			tv_right.setVisibility(View.GONE);
		else
			tv_right.setText(rightText);
	}
}

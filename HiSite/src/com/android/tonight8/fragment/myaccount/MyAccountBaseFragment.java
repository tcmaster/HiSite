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
	 * 初始化”我“的每项布局
	 * 
	 * @param includeView
	 *            要初始化的布局
	 * @param leftRes
	 *            左边的文字
	 * @param leftLogo
	 *            左边的logo
	 * @param no
	 *            该项的数量
	 * @param rightInfo
	 *            右边的文字
	 * @param rightIsVisible
	 *            右边的图标是否可见
	 */
	protected void setTextAndContent(View includeView, int leftRes,
			int leftLogo, String no, String rightInfo, boolean rightIsVisible) {
		ImageView iv_left_icon = (ImageView) includeView
				.findViewById(R.id.iv_left_icon);
		TextView tv_left_text = (TextView) includeView
				.findViewById(R.id.tv_left_text);
		TextView tv_no = (TextView) includeView.findViewById(R.id.tv_no);
		ImageView iv_right_arrow = (ImageView) includeView
				.findViewById(R.id.iv_right_arrow);
		TextView tv_right_info = (TextView) includeView
				.findViewById(R.id.tv_right_info);
		if (leftRes != -1)
			iv_left_icon.setImageResource(leftRes);
		if (leftLogo != -1)
			tv_left_text.setText(leftLogo);
		if (!StringUtils.isNullOrEmpty(no)) {
			tv_no.setText(no);
			tv_no.setVisibility(View.VISIBLE);
		}
		if (!StringUtils.isNullOrEmpty(rightInfo)) {
			tv_right_info.setText(rightInfo);
			tv_right_info.setVisibility(View.VISIBLE);
		}
		if (rightIsVisible)
			iv_right_arrow.setVisibility(View.VISIBLE);
		else
			iv_right_arrow.setVisibility(View.INVISIBLE);

	}

	protected void setNo(View includeView, String no) {
		TextView tv_no = (TextView) includeView.findViewById(R.id.tv_no);
		if (!StringUtils.isNullOrEmpty(no)) {
			tv_no.setText(no);
			tv_no.setVisibility(View.VISIBLE);
		} else
			tv_no.setVisibility(View.INVISIBLE);
	}

	/**
	 * @Description:设置“设置”界面的include项的文字
	 * @param includeView
	 *            要进行设置的视图
	 * @param leftRes
	 *            左边的文字
	 * @param rightText
	 *            右边的文字
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	protected void setTextAndContent(View includeView, int leftRes,
			String rightText) {
		if (includeView == null)
			return;
		TextView tv_left = (TextView) includeView
				.findViewById(R.id.tv_left_text);
		TextView tv_right = (TextView) includeView
				.findViewById(R.id.tv_red_point_text);
		if (leftRes < 0)
			tv_left.setVisibility(View.INVISIBLE);
		else
			tv_left.setText(leftRes);
		if (StringUtils.isNullOrEmpty(rightText))
			tv_right.setVisibility(View.INVISIBLE);
		else
			tv_right.setText(rightText);
	}
}

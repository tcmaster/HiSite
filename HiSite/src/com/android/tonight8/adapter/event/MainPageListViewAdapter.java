/**
 * 2014-12-25
 */
package com.android.tonight8.adapter.event;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.utils.HSAnimationUtils;
import com.android.tonight8.view.ListViewForScrollView;

/**
 * @Description:
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MainPageListViewAdapter extends BaseListAdapter<EventListModel> {
	private List<Boolean> infos;// 本界面的数据源附加信息,目前是记录该条项目是否为开启状态,默认为全部关闭

	public MainPageListViewAdapter(Context context, List<EventListModel> values) {
		super(context, values);
		infos = new ArrayList<Boolean>();
		resetInfos();
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		EventListModel model = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_home_lv, null, false);
		}
		RelativeLayout rl_show_more_info = ViewHolder.get(convertView,
				R.id.rl_show_more_info);// 标题布局
		TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);// 首页标题
		ImageView iv_compere_pic = ViewHolder.get(convertView,
				R.id.iv_compere_pic);// 主持人头像
		TextView tv_compere_name = ViewHolder.get(convertView,
				R.id.tv_compere_name);// 主持人姓名
		TextView tv_compere_info = ViewHolder.get(convertView,
				R.id.tv_compere_info);// 主持人信息
		ListViewForScrollView lv_prgram = ViewHolder.get(convertView,
				R.id.lv_prgram);// 节目单列表
		final LinearLayout ll_info = ViewHolder.get(convertView, R.id.ll_info);// 附加信息
		ImageView iv_bpic = ViewHolder.get(convertView, R.id.iv_bpic);// 商品图片
		ImageView iv_bg = ViewHolder.get(convertView, R.id.iv_bg);// 说明图片
		TextView tv_awards = ViewHolder.get(convertView, R.id.tv_awards);// 奖品名称
		TextView tv_prize = ViewHolder.get(convertView, R.id.tv_prize);// 奖品价值
		TextView tv_count = ViewHolder.get(convertView, R.id.tv_count);// 奖品数量
		TextView tv_sign = ViewHolder.get(convertView, R.id.tv_sign);// 奖品标识
		LinearLayout ll_win = ViewHolder.get(convertView, R.id.ll_win);// 现场
		LinearLayout ll_apply = ViewHolder.get(convertView, R.id.ll_apply);// 报名
		if (infos.get(position))
			ll_info.setVisibility(View.VISIBLE);
		else
			ll_info.setVisibility(View.GONE);
		rl_show_more_info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HSAnimationUtils.playShowOrHideAnimation(ll_info,
						new AnimationListener() {

							@Override
							public void onAnimationStart(Animation animation) {

							}

							@Override
							public void onAnimationRepeat(Animation animation) {

							}

							@Override
							public void onAnimationEnd(Animation animation) {
								if (infos.get(position))
									ll_info.setVisibility(View.GONE);
								else
									ll_info.setVisibility(View.VISIBLE);
								infos.set(position, !infos.get(position));
							}
						}, infos.get(position));
			}
		});
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<EventListModel> models) {
		mValues.addAll(models);
		resetInfos();
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<EventListModel> models) {
		mValues.clear();
		mValues.addAll(models);
		resetInfos();
		notifyDataSetChanged();
	}

	/**
	 * 重置额外信息
	 */
	private void resetInfos() {
		infos.clear();
		for (int i = 0; i < mValues.size(); i++) {
			infos.add(false);
		}
	}
}

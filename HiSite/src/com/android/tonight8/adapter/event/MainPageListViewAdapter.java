/**
 * 2014-12-25
 */
package com.android.tonight8.adapter.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.event.EventList;
import com.android.tonight8.dao.model.event.PlayBillList;
import com.android.tonight8.io.event.EventIOController;
import com.android.tonight8.io.event.entity.PlayListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.utils.HSAnimationUtils;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.exception.HttpException;

/**
 * @Description:
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MainPageListViewAdapter extends BaseListAdapter<EventList> {
	private List<Boolean> infos;// 本界面的数据源附加信息,目前是记录该条项目是否为开启状态,默认为全部关闭
	private Map<Long, List<PlayBillList>> playBillMaps;// 本界面的节目单数据

	public MainPageListViewAdapter(Context context, List<EventList> values) {
		super(context, values);
		infos = new ArrayList<Boolean>();
		playBillMaps = new HashMap<Long, List<PlayBillList>>();
		resetInfos();
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		final EventList model = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_home_lv, null, false);
		}
		RelativeLayout rl_show_more_info = ViewHolder.get(convertView,
				R.id.rl_show_more_info);// 标题布局
		TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);// 首页标题
		final ProgressBar pb_program_loading = ViewHolder.get(convertView,
				R.id.pb_program_loading);
		final ListViewForScrollView lv_prgram = ViewHolder.get(convertView,
				R.id.lv_prgram);// 节目单列表
		final RelativeLayout rl_info = ViewHolder
				.get(convertView, R.id.ll_info);// 附加信息
		ImageView iv_bpic = ViewHolder.get(convertView, R.id.iv_bpic);// 商品图片
		ImageView iv_bg = ViewHolder.get(convertView, R.id.iv_bg);// 说明图片
		TextView tv_awards = ViewHolder.get(convertView, R.id.tv_awards);// 奖品名称
		TextView tv_prize = ViewHolder.get(convertView, R.id.tv_prize);// 奖品价值
		TextView tv_count = ViewHolder.get(convertView, R.id.tv_count);// 奖品数量
		TextView tv_sign = ViewHolder.get(convertView, R.id.tv_sign);// 奖品标识
		LinearLayout ll_win = ViewHolder.get(convertView, R.id.ll_win);// 现场
		LinearLayout ll_apply = ViewHolder.get(convertView, R.id.ll_apply);// 报名
		tv_title.setText(model.getEvent().getName());
		bmUtils.display(iv_bpic, model.getPopPic().getUrl());
		tv_awards.setText(model.getPrize().getName());
		tv_prize.setText(model.getPrize().getPrice() + "");
		tv_count.setText(model.getEvent().getWinningLimit() + "");
		if (infos.get(position))
			rl_info.setVisibility(View.VISIBLE);
		else
			rl_info.setVisibility(View.GONE);
		rl_show_more_info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HSAnimationUtils.playShowOrHideAnimation(rl_info,
						new AnimationListener() {

							@Override
							public void onAnimationStart(Animation animation) {

							}

							@Override
							public void onAnimationRepeat(Animation animation) {

							}

							@SuppressLint("HandlerLeak")
							@Override
							public void onAnimationEnd(Animation animation) {
								if (infos.get(position)) {
									rl_info.setVisibility(View.GONE);
								} else {
									pb_program_loading
											.setVisibility(View.VISIBLE);
									lv_prgram.setVisibility(View.INVISIBLE);
									rl_info.setVisibility(View.VISIBLE);
									List<PlayBillList> list = playBillMaps
											.get(model.getEvent().getId());
									if (list == null) {
										final long eventId = model.getEvent()
												.getId();
										EventIOController
												.eventPlayBillRead(
														eventId,
														new RequestResult<PlayListNetEntity>(
																PlayListNetEntity.class,
																null) {
															@Override
															public void getData(
																	NetEntityBase netEntityBase,
																	final PlayListNetEntity t,
																	Handler handler) {
																Activity activity = (Activity) mContext;
																activity.runOnUiThread(new Runnable() {

																	@Override
																	public void run() {
																		pb_program_loading
																				.setVisibility(View.INVISIBLE);
																		lv_prgram
																				.setVisibility(View.VISIBLE);
																		playBillMaps
																				.put(eventId,
																						t.getPlaybillList());
																		if (eventId == model
																				.getEvent()
																				.getId()) {
																			showProgramList(
																					lv_prgram,
																					t.getPlaybillList());
																		}
																	}
																});

															}

															@Override
															public void onFailure(
																	HttpException error,
																	String msg) {

															}

														});
									} else {
										pb_program_loading
												.setVisibility(View.INVISIBLE);
										lv_prgram.setVisibility(View.VISIBLE);
										showProgramList(lv_prgram, list);
									}
								}
								infos.set(position, !infos.get(position));
							}
						}, infos.get(position), true);
			}
		});
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<EventList> models) {
		mValues.addAll(models);
		resetInfos();
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<EventList> models) {
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

	/**
	 * 显示节目单
	 */
	private void showProgramList(ListViewForScrollView lv,
			List<PlayBillList> data) {
		PlayBillListAdapter adapter = (PlayBillListAdapter) lv.getAdapter();
		if (adapter == null) {
			adapter = new PlayBillListAdapter(getContext(), data);
			lv.setAdapter(adapter);
			return;
		}
		adapter.update(data);
	}
}

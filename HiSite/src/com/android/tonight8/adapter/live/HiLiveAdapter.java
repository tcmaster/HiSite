package com.android.tonight8.adapter.live;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.adapter.live.HiLiveGalleryAdapter.OnItemClickLitener;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveCommentModel;
import com.android.tonight8.model.live.LiveListModel;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.SharePopupWindow;

/**
 * @author liuzhao hi现场的数据适配器
 */
public class HiLiveAdapter extends BaseListAdapter<LiveListModel> {

	/** 话题列表数据适配器 */
	private LiveListCommentAdapter subjectListAdapter;
	private List<LiveCommentModel> listComment = null;
	/** 底部头像数据适配器 */
	private HiLiveGalleryAdapter mAdapter;
	/** 轮播大图数据适配器 */
	private MyPagerAdapter pagerAdapter;
	/** 当前第几张图，默认第一个 */
	private int index = 0;
	/** 头像图片张数 */
	private int ivCount = 8;
	private PopupWindow popWindow;

	public HiLiveAdapter(Context context, List<LiveListModel> values) {
		super(context, values);
		popWindow = new SharePopupWindow(context, onItemsClick);
	}

	private OnClickListener onItemsClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			popWindow.dismiss();
		}
	};

	@Override
	protected View getItemView(View convertView, final int position) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_hilive, null);
			holder.tv_title_hilive = (TextView) convertView
					.findViewById(R.id.tv_title_hilive);
			holder.tv_place_time = (TextView) convertView
					.findViewById(R.id.tv_place_time);
			holder.iv_camera_icon = (ImageView) convertView
					.findViewById(R.id.iv_camera_icon);
			holder.tv_subjectCount = (TextView) convertView
					.findViewById(R.id.tv_subjectcount);
			int margin = mContext.getResources().getDimensionPixelSize(
					R.dimen.tonight_iv_margin);
			int margin_error = Utils.dip2px(mContext, ivCount * margin);
			int iv_with = (AppConstants.widthPx - margin_error) / ivCount;
			holder.tv_subjectCount.setHeight(iv_with);
			holder.tv_subjectCount.setWidth(iv_with);
			holder.vp_adapter_hilive = (ViewPager) convertView
					.findViewById(R.id.vp_adapter_hilive);
			holder.mRecyclerView = (RecyclerView) convertView
					.findViewById(R.id.rv_recyclerview_horizontal);
			holder.tv_share = (TextView) convertView
					.findViewById(R.id.tv_share);
			holder.cb_subject = (CheckBox) convertView
					.findViewById(R.id.cb_subject);
			holder.lv_subject = (ListView) convertView
					.findViewById(R.id.lv_subject);
			holder.tv_signInCount = (TextView) convertView
					.findViewById(R.id.tv_signInCount);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		// 签到的大图
		LiveListModel liveListModel = mValues.get(position);
		holder.tv_title_hilive.setText(liveListModel.getEvent().getName());
		holder.tv_place_time.setText(liveListModel.getEvent()
				.getTimeRangeStart());
		// 话题数量
		holder.tv_subjectCount.setText(liveListModel.getEvent().subjectCount
				+ "");
		// 签到数量
		holder.tv_signInCount
				.setText(liveListModel.getEvent().signInCount + "");
		// 签到大图
		List<String> mdata = new ArrayList<String>();
		for (int i = 0; i < liveListModel.getSignIn().size(); i++) {
			mdata.add(liveListModel.getSignIn().get(i).pic);
		}
		pagerAdapter = new MyPagerAdapter(mContext, mdata);
		holder.vp_adapter_hilive.setAdapter(pagerAdapter);
		holder.vp_adapter_hilive.setCurrentItem(index);

		// 底部头像
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
				mContext);
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		holder.mRecyclerView.setLayoutManager(linearLayoutManager);
		List<String> galleryData = new ArrayList<String>();
		int tempCount = liveListModel.getSignIn().size();
		if (tempCount > ivCount) {
			tempCount = ivCount;
		}
		for (int i = 0; i < tempCount; i++) {
			galleryData.add(liveListModel.getSignIn().get(i).user.pic);
		}
		mAdapter = new HiLiveGalleryAdapter(mContext, galleryData);
		holder.mRecyclerView.setAdapter(mAdapter);
		mAdapter.setOnItemClickLitener(new OnItemClickLitener() {

			@Override
			public void onItemClick(View view, int position1) {
				Toast.makeText(mContext, position + "  " + position1 + " ",
						Toast.LENGTH_SHORT).show();
				holder.vp_adapter_hilive.setTag(position);
				holder.vp_adapter_hilive.setCurrentItem(position1);
			}
		});
		holder.tv_share.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				popWindow.showAtLocation(arg0.getRootView(), Gravity.BOTTOM, 0,
						0);
			}
		});
		// 话题列表
		holder.cb_subject
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean isChecked) {
						holder.lv_subject.setTag(position);
						// true展开话题
						if (isChecked) {
							listComment = new ArrayList<LiveCommentModel>();
							for (int i = 0; i < 5; i++) {
								LiveCommentModel liveCommentModel = new LiveCommentModel();
								Comment comment = new Comment();
								comment.content = "很好很好！！！！！";
								comment.date = "2012-12-12";
								comment.time = "12:12:12";
								User user = new User();
								user.pic = "http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg";
								user.name = "晓松";
								liveCommentModel.setComment(comment);
								liveCommentModel.setUser(user);
								listComment.add(liveCommentModel);
							}
							subjectListAdapter = new LiveListCommentAdapter(
									mContext, listComment);
							holder.lv_subject.setAdapter(subjectListAdapter);
							holder.lv_subject.setVisibility(View.VISIBLE);
						} else {
							holder.lv_subject.setVisibility(View.GONE);
						}
					}

				});

		return convertView;
	}

	class ViewHolder {

		/** 头部标题 */
		TextView tv_title_hilive;
		/** 地点 时间 */
		TextView tv_place_time;
		/** 照相机 */
		ImageView iv_camera_icon;
		/** 签到的大图 */
		ViewPager vp_adapter_hilive;
		/** 底部头像 */
		RecyclerView mRecyclerView;
		/** 分享 */
		TextView tv_share;
		/** 话题 */
		CheckBox cb_subject;
		/** 话题的列表 */
		ListView lv_subject;
		/** 话题数量 */
		TextView tv_subjectCount;
		/** 签到数量 */
		TextView tv_signInCount;

	}
}

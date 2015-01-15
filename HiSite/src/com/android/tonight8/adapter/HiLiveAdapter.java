package com.android.tonight8.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonight8.R;
import com.android.tonight8.adapter.HiLiveGalleryAdapter.OnItemClickLitener;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.live.LiveSubjectModel;

public class HiLiveAdapter extends BaseListAdapter<LiveSubjectModel> {

	private SubjectListAdapter subjectListAdapter;
	private List<Comment> list = null;
	private HiLiveGalleryAdapter mAdapter;
	private List<Integer> galleryData;
	// private ImageView mImg;
	private ViewPager viewpager;
	private MyPagerAdapter pagerAdapter;
	/** 当前第几张图，默认第一个 */
	private int index = 0;

	public HiLiveAdapter(Context context, List<LiveSubjectModel> values) {
		super(context, values);
		subjectListAdapter = new SubjectListAdapter(mContext, list);
		mAdapter = new HiLiveGalleryAdapter(mContext, galleryData);

	}

	@Override
	protected View getItemView(View convertView, final int position) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_hilive, null);
			holder.tv_title_hilive = (TextView) convertView.findViewById(R.id.tv_title_hilive);
			holder.tv_place_time = (TextView) convertView.findViewById(R.id.tv_place_time);
			holder.iv_camera_icon = (ImageView) convertView.findViewById(R.id.iv_camera_icon);
			holder.vp_adapter_hilive = (ViewPager) convertView.findViewById(R.id.vp_adapter_hilive);
			holder.mRecyclerView = (RecyclerView) convertView.findViewById(R.id.rv_recyclerview_horizontal);
			holder.tv_share = (TextView) convertView.findViewById(R.id.tv_share);
			holder.cb_subject = (CheckBox) convertView.findViewById(R.id.cb_subject);
			holder.lv_subject = (ListView) convertView.findViewById(R.id.lv_subject);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.cb_subject.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1) {
					list = mValues.get(position).getComments();
					List<String> mDatas = new ArrayList<String>();
					pagerAdapter = new MyPagerAdapter(mContext, mDatas);
					viewpager.setAdapter(pagerAdapter);
					viewpager.setCurrentItem(index);

					LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
					linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
					holder.mRecyclerView.setLayoutManager(linearLayoutManager);
					holder.mRecyclerView.setAdapter(mAdapter);
					mAdapter.setOnItemClickLitener(new OnItemClickLitener() {

						@Override
						public void onItemClick(View view, int position1) {
							Toast.makeText(mContext, position1 + "", Toast.LENGTH_SHORT).show();
							// mImg.setImageResource(mDatas.get(position));
							viewpager.setCurrentItem(position);
						}
					});
				} else {
					list = null;
				}
				holder.lv_subject.setAdapter(subjectListAdapter);
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
	}
}

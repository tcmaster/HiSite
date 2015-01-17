package com.android.tonight8.adapter.live;

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
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.adapter.live.HiLiveGalleryAdapter.OnItemClickLitener;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.live.LiveSubjectModel;

public class HiLiveAdapter extends BaseListAdapter<LiveSubjectModel> {

	/** 话题列表数据适配器 */
	private SubjectListAdapter subjectListAdapter;
	private List<Comment> list = null;
	/** 底部头像数据适配器 */
	private HiLiveGalleryAdapter mAdapter;
	private List<String> galleryData;
	/** 轮播大图数据适配器 */
	private MyPagerAdapter pagerAdapter;
	/** 当前第几张图，默认第一个 */
	private int index = 0;
	private List<String> mDatas;

	public HiLiveAdapter(Context context, List<LiveSubjectModel> values) {
		super(context, values);
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
		// 轮播大图
		mDatas = new ArrayList<String>();
		mDatas.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		mDatas.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		mDatas.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		mDatas.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		pagerAdapter = new MyPagerAdapter(mContext, mDatas);
		holder.vp_adapter_hilive.setAdapter(pagerAdapter);
		holder.vp_adapter_hilive.setCurrentItem(index);
		// 底部头像
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		holder.mRecyclerView.setLayoutManager(linearLayoutManager);
		galleryData = new ArrayList<String>();
		galleryData.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		galleryData.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		galleryData.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		galleryData.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		galleryData.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		galleryData.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		galleryData.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		galleryData.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		galleryData.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		galleryData.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		galleryData.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		galleryData.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		mAdapter = new HiLiveGalleryAdapter(mContext, galleryData);
		holder.mRecyclerView.setAdapter(mAdapter);
		mAdapter.setOnItemClickLitener(new OnItemClickLitener() {

			@Override
			public void onItemClick(View view, int position1) {
				Toast.makeText(mContext, position+"  "+position1 + " ", Toast.LENGTH_SHORT).show();
				// mImg.setImageResource(mDatas.get(position));
				holder.vp_adapter_hilive.setTag(position);
				holder.vp_adapter_hilive.setCurrentItem(position1);
			}
		});
		// 话题列表

		holder.cb_subject.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					// list = mValues.get(position).getComments();
					list = new ArrayList<Comment>();
					for (int i = 0; i < 5; i++) {
						Comment comment = new Comment();
						comment.setDate("2012-12-12");
						list.add(comment);
					}
					subjectListAdapter = new SubjectListAdapter(mContext, list);
					holder.lv_subject.setAdapter(subjectListAdapter);
					subjectListAdapter.notifyDataSetChanged();
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
	}
}

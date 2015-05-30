/**
 * 2014-12-25
 */
package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.tonight8.R;
import com.android.tonight8.dao.model.event.EventRecommends;
import com.lidroid.xutils.BitmapUtils;

/**
 * @Description:
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MyPagerAdapter extends PagerAdapter {

	private LayoutInflater inflater;
	/** 数据源 */
	private List<EventRecommends> dataSource;
	private BitmapUtils bmUtils;

	public MyPagerAdapter(Context context, List<EventRecommends> source) {
		inflater = LayoutInflater.from(context);
		dataSource = source;
		bmUtils = new BitmapUtils(context);
	}

	@Override
	public int getCount() {
		return dataSource.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		EventRecommends result = dataSource.get(position);
		View view = inflater.inflate(R.layout.item_home_vp, null, false);
		/**
		 * 以后要用到的图片
		 */
		ImageView iv = (ImageView) view.findViewById(R.id.iv_mplay);
		bmUtils.display(iv, result.getPopPic().getUrl());
		Log.v("test", iv.getLayoutParams().height + "");
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}

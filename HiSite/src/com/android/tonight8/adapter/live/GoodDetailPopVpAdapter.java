package com.android.tonight8.adapter.live;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.android.tonight8.dao.entity.PopPic;
import com.lidroid.xutils.BitmapUtils;

/**
 * @Descripton 商品详情海报适配器
 * @author LiXiaoSong
 * @2015-6-25
 * @Tonight8
 */
public class GoodDetailPopVpAdapter extends PagerAdapter {
	private List<PopPic> datas;
	private BitmapUtils bmUtils;

	public GoodDetailPopVpAdapter(List<PopPic> datas) {
		this.datas = datas;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		if (bmUtils == null)
			bmUtils = new BitmapUtils(container.getContext());
		ImageView iv = new ImageView(container.getContext());
		iv.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
		iv.setScaleType(ScaleType.FIT_XY);
		bmUtils.display(iv, datas.get(position).getUrl());
		container.addView(iv);
		return iv;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((ImageView) object);
	}

}

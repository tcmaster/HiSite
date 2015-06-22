package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishProgressPostAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.GridViewForScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz心愿历程发布
 * 
 */
public class WishProcessPostActivity extends BaseActivity {
	@ViewInject(R.id.gv_wishprogress)
	private GridViewForScrollView gv_wishprogress;
	private WishProgressPostAdapter adapter;
	private List<String> values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState,
				R.layout.activity_wish_progress_post);
		getActionBarRight("历程发布", "发布", new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		initData();
	}

	private void initData() {
		values = new ArrayList<String>();
		adapter = new WishProgressPostAdapter(mContext, values);
		gv_wishprogress.setAdapter(adapter);
	}
}

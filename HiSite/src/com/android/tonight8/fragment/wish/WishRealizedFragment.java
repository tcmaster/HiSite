package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.WishLiveActivity;
import com.android.tonight8.adapter.wish.WishRealizedListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.User;
import com.android.tonight8.dao.entity.Wish;
import com.android.tonight8.model.wish.WishListModel;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 愿望列表(未实现)
 */
public class WishRealizedFragment extends BaseFragment {
	private WishRealizedListAdapter wishListAdapter;
	private List<WishListModel> list;
	@ViewInject(R.id.gv_wish)
	private GridView gv_wish;
	private View rootView;
	private BaseActivity mActivity;

	public static final WishRealizedFragment newInstance() {
		WishRealizedFragment wUnrealizedFragment = new WishRealizedFragment();
		return wUnrealizedFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (BaseActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_wish_list, container,
				false);
		ViewUtils.inject(this, rootView);
		list = new ArrayList<WishListModel>();
		WishListModel wListModel = new WishListModel();
		PopPic poppic = new PopPic();
		Wish wish = new Wish();
		User user = new User();
		wish.setName("我想去大理");
		wish.setPublishTime("2015年10月1日 8:00");
		wish.setSupportCount(200);
		wish.setProgress((float) 0.23);
		wish.setDescribe("给我三个月假期和2万元钱助我一臂之力去大理，嗷嗷嗷叫");
		poppic.setUrl("http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		user.setPic("http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		user.setName("明月");
		wListModel.setPopPic(poppic);
		wListModel.setWish(wish);
		wListModel.setUser(user);
		list.add(wListModel);
		list.add(wListModel);
		list.add(wListModel);
		list.add(wListModel);
		list.add(wListModel);
		wishListAdapter = new WishRealizedListAdapter(activity, list);
		gv_wish.setAdapter(wishListAdapter);
		gv_wish.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(),
						WishLiveActivity.class);
				startActivityForAnima(intent, mActivity);

			}

		});
		return rootView;
	}

}

package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.wish.WishAboutMeFragment;
import com.android.tonight8.fragment.wish.WishProgressFragment;
import com.android.tonight8.fragment.wish.WishSponsorFragment;
import com.android.tonight8.fragment.wish.WishTalkFragment;
import com.android.tonight8.function.CirculateFunction;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.utils.SharedUtils.ShareThirdEntity;
import com.android.tonight8.view.PointLinearlayout;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 心愿现场页面
 */
public class WishLiveActivity extends BaseActivity implements OnCheckedChangeListener{
	/** 滑动的图片viewpager控件 */
	@ViewInject(R.id.vp_wish_live)
	private ViewPager viewPager;
	private List<String> data;
	/** 图片轮播底部的圆点父布局 */
	@ViewInject(R.id.ll_wishlive_container)
	private PointLinearlayout ll_wishlive_container;
	/** vp轮播功能 */
	private CirculateFunction cFunction;
	@ViewInject(R.id.rg_wish_detail)
	private RadioGroup rg_wish_detail;
	@ViewInject(R.id.rb_wish_talk)
	private RadioButton rb_wish_talk;
	@ViewInject(R.id.rb_wish_process)
	private RadioButton rb_wish_process;
	@ViewInject(R.id.rb_wish_sponsor)
	private RadioButton rb_wish_sponsor;
	@ViewInject(R.id.rb_wish_aboutme)
	private RadioButton rb_wish_aboutme;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] baseFragments;

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		int radioButtonId = arg0.getCheckedRadioButtonId();
		LogUtils.i(arg1+"");
		switch (radioButtonId) {
		case R.id.rb_wish_talk:
			doFragmentShow(0);
			break;
		case R.id.rb_wish_process:
			doFragmentShow(1);
			break;
		case R.id.rb_wish_sponsor:
			doFragmentShow(2);
			break;
		case R.id.rb_wish_aboutme:
			doFragmentShow(3);
			break;
		default:
			break;
		}

	}

	/**
	 * @Description:显示当前的fragment对象
	 * @param which
	 *            第几个对象
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	private void doFragmentShow(int which) {
		ft = fm.beginTransaction();
		for (int i = 0; i < baseFragments.length; i++) {
			if (which == i) {
				ft.show(baseFragments[i]);
			} else
				ft.hide(baseFragments[i]);
		}
		ft.commit();
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			ShareThirdEntity shareThirdEntity = new ShareThirdEntity();
			DialogUtils.showSelectShareDialog(WishLiveActivity.this, shareThirdEntity);

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_wish_live);
		super.onCreate(savedInstanceState);
		getActionBarNormal("心愿详情", R.drawable.ic_launcher, onClickListener);
		initView();
		initData();
		doFragmentShow(0);
	}

	private void initData() {
		
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		baseFragments = new BaseFragment[4];
		baseFragments[0] = WishTalkFragment.newInstance();
		baseFragments[1] = WishProgressFragment.newInstance();
		baseFragments[2] = WishSponsorFragment.newInstance();
		baseFragments[3] = WishAboutMeFragment.newInstance();
		ft.add(R.id.ll_wish_fourcontent, baseFragments[0]);
		ft.add(R.id.ll_wish_fourcontent, baseFragments[1]);
		ft.add(R.id.ll_wish_fourcontent, baseFragments[2]);
		ft.add(R.id.ll_wish_fourcontent, baseFragments[3]);
		ft.commit();
		rg_wish_detail.setOnCheckedChangeListener(this);
	}

	private void initView() {
		data = new ArrayList<String>();
		data.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		data.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		data.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		data.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		ll_wishlive_container.setPointCount(4);
		ll_wishlive_container.changePoint(0);
		viewPager.setAdapter(new MyPagerAdapter(WishLiveActivity.this, data));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				ll_wishlive_container.changePoint(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		cFunction = new CirculateFunction(viewPager.getAdapter().getCount(), 5, new Handler() {

			@Override
			public void handleMessage(Message msg) {
				viewPager.setCurrentItem(msg.what);
				super.handleMessage(msg);
			}
		});
		cFunction.start();// 开始轮播
	}

	@Override
	public void onDestroy() {
		if (cFunction != null)
			cFunction.stop();// 结束轮播
		super.onDestroy();
	}

	@Override
	public void onStart() {
		if (cFunction != null)
			cFunction.resume();
		super.onResume();
	}

	@Override
	public void onStop() {
		if (cFunction != null)
			cFunction.pause();
		super.onStop();
	}
}

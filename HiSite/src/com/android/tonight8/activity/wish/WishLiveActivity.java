package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.TextView.BufferType;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.model.event.EventRecommends;
import com.android.tonight8.dao.model.wish.WishDetailModel;
import com.android.tonight8.fragment.wish.WishSponsorFragment;
import com.android.tonight8.fragment.wish.WishTalkFragment;
import com.android.tonight8.function.CirculateFunction;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.utils.IntentUtils;
import com.android.tonight8.view.CircleImageView;
import com.android.tonight8.view.CollapsibleTextView;
import com.android.tonight8.view.MyProgressBar;
import com.android.tonight8.view.PointLinearlayout;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @author lz 心愿详情页面
 */
public class WishLiveActivity extends BaseActivity implements
		OnCheckedChangeListener {
	/** 滑动的图片viewpager控件 */
	@ViewInject(R.id.vp_wish_live)
	private ViewPager viewPager;
	private List<EventRecommends> data;
	/** 图片轮播底部的圆点父布局 */
	@ViewInject(R.id.ll_wishlive_container)
	private PointLinearlayout ll_wishlive_container;
	/** vp轮播功能 */
	private CirculateFunction cFunction;
	@ViewInject(R.id.rg_wish_detail)
	private RadioGroup rg_wish_detail;
	@ViewInject(R.id.rb_wish_talk)
	private RadioButton rb_wish_talk;
	@ViewInject(R.id.rb_wish_sponsor)
	private RadioButton rb_wish_sponsor;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] baseFragments;
	/** 心愿详情 */
	private WishDetailModel wishDetailModel;
	/** 心愿内容 */
	@ViewInject(R.id.ctv_wish_content)
	private CollapsibleTextView ctv_wish_content;
	/** 发心愿的头像 */
	@ViewInject(R.id.civ_wishlive_userpic)
	private CircleImageView civ_wishlive_userpic;
	/** 心愿支持数 */
	@ViewInject(R.id.tv_wish_supportcount)
	private TextView tv_wish_supportcount;
	/** 心愿进度 */
	@ViewInject(R.id.pb_wish_live)
	private MyProgressBar pb_wish_live;
	@ViewInject(R.id.tv_callme)
	private TextView tv_callme;
	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			if (msg.what == HandlerConstants.WISH.WISH_DETAIL
					&& msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
				wishDetailModel = (WishDetailModel) msg.obj;
				ctv_wish_content
						.setDesc(
								"啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊",
								BufferType.NORMAL);
				Tonight8App.getSelf().bitmapUtils.display(civ_wishlive_userpic,
						wishDetailModel.getUser().getPic());
				tv_wish_supportcount.setText(wishDetailModel.getWish()
						.getSupportCount() + "");
				pb_wish_live.setProgress(20);
			}

		};
	};

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		int radioButtonId = arg0.getCheckedRadioButtonId();
		LogUtils.i(arg1 + "");
		switch (radioButtonId) {
		case R.id.rb_wish_talk:
			doFragmentShow(0);
			break;
		case R.id.rb_wish_sponsor:
			doFragmentShow(1);
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
			// ShareThirdEntity shareThirdEntity = new ShareThirdEntity();
			// DialogUtils.showSelectShareDialog(WishLiveActivity.this,
			// shareThirdEntity);
			Intent intent = new Intent(WishLiveActivity.this,
					WishSponsorActivity.class);
			startActivityForAnima(intent, null);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_wish_live);
		getActionBarNormal("心愿详情", R.drawable.ic_launcher, onClickListener);
		initView();
		initData();
		doFragmentShow(0);
	}

	private void initData() {

		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		baseFragments = new BaseFragment[2];
		baseFragments[0] = WishTalkFragment.newInstance();
		baseFragments[1] = WishSponsorFragment.newInstance();
		ft.add(R.id.ll_wish_fourcontent, baseFragments[0]);
		ft.add(R.id.ll_wish_fourcontent, baseFragments[1]);
		ft.commit();
		rg_wish_detail.setOnCheckedChangeListener(this);
		Map<String, String> params = new HashMap<String, String>();
		wishDetailModel = new WishDetailModel();
		WishIOController.getWishLiveDetail(handler, params,
				HandlerConstants.WISH.WISH_DETAIL, REFRESH);

	}

	private void initView() {
		data = new ArrayList<EventRecommends>();
		EventRecommends eventRecommends = new EventRecommends();
		PopPic popPic = new PopPic();
		popPic.setUrl("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		eventRecommends.setPopPic(popPic);
		data.add(eventRecommends);
		data.add(eventRecommends);
		data.add(eventRecommends);
		data.add(eventRecommends);
		ll_wishlive_container.setPointCount(data.size());
		ll_wishlive_container.changePoint(data.size());
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
		cFunction = new CirculateFunction(viewPager.getAdapter().getCount(), 5,
				new Handler() {

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

	@OnClick({ R.id.tv_callme })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_callme:
			IntentUtils.showCallPhoneDialog(mContext, "15210162168");
			break;

		default:
			break;
		}
	}

}

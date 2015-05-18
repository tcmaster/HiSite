package com.android.tonight8.activity.event;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventFragmentPagerAdapter;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.event.AwardSendFragment;
import com.android.tonight8.fragment.event.CouponSettingsFragment;
import com.android.tonight8.fragment.event.CouponUseFragment;
import com.android.tonight8.fragment.event.EventDetailFragment;
import com.android.tonight8.fragment.event.LiveSettingsFragment;
import com.android.tonight8.fragment.event.OrdersSendFragment;
import com.android.tonight8.model.other.EventTabItem;
import com.android.tonight8.view.ColumnHorizontalScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 活动管理
 * 
 */
public class EventManageActivity extends BaseActivity implements
		OnCheckedChangeListener {

	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] fragments;
	/** 自定义HorizontalScrollView */
	private ColumnHorizontalScrollView mColumnHorizontalScrollView;
	private LinearLayout mRadioGroup_content;
	/** 选择的列表 */
	private ArrayList<EventTabItem> userChannelList = new ArrayList<EventTabItem>();
	/** 当前选中的栏目 */
	private int columnSelectIndex = 0;
	@ViewInject(R.id.vp_evnetmanage)
	private ViewPager vp_evnetmanage;
	/** 左阴影部分 */
	@ViewInject(R.id.shade_left)
	public ImageView shade_left;
	/** 右阴影部分 */
	@ViewInject(R.id.shade_right)
	public ImageView shade_right;
	/** 屏幕宽度 */
	private int mScreenWidth = 0;
	/** Item宽度 */
	private int mItemWidth = 0;
	private RelativeLayout rl_column;
	private String[] strEventTab = { "开奖详情", "赠券设置", "赠券使用", "现场设置", "直播管理",
			"奖品寄送", "订单寄送" };

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		int switchid = Integer.parseInt(mRadioButton.getTag().toString());
		selectTab(switchid);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_event_manage);
		super.onCreate(savedInstanceState);
		initData();
		initTabColumn();
	}

	private void initData() {
		// fm = getSupportFragmentManager();
		// ft = fm.beginTransaction();
		fragments = new BaseFragment[6];
		fragments[0] = EventDetailFragment.newInstance();
		fragments[1] = CouponSettingsFragment.newInstance();
		fragments[2] = CouponUseFragment.newInstance();
		fragments[3] = LiveSettingsFragment.newInstance();
		fragments[4] = OrdersSendFragment.newInstance();
		fragments[5] = AwardSendFragment.newInstance();
		// ft.add(R.id.ll_wish_container, fragments[0]);
		// ft.add(R.id.ll_wish_container, fragments[1]);
		// ft.add(R.id.ll_wish_container, fragments[2]);
		// ft.add(R.id.ll_wish_container, fragments[3]);
		// ft.add(R.id.ll_wish_container, fragments[4]);
		// ft.add(R.id.ll_wish_container, fragments[5]);
		// ft.add(R.id.ll_wish_container, fragments[7]);
		// ft.commit();
		// rg_evnetmanage.setOnCheckedChangeListener(this);
		mColumnHorizontalScrollView = (ColumnHorizontalScrollView) findViewById(R.id.chsv_evnetmanage_tab);
		mRadioGroup_content = (LinearLayout) findViewById(R.id.ll_evnetmanage_content);

		for (int i = 0; i < strEventTab.length; i++) {
			EventTabItem eventTabItem = new EventTabItem();
			eventTabItem.name = strEventTab[i];
			userChannelList.add(eventTabItem);
		}

		EventFragmentPagerAdapter mAdapetr = new EventFragmentPagerAdapter(
				getSupportFragmentManager(), fragments);
		// mViewPager.setOffscreenPageLimit(0);
		vp_evnetmanage.setAdapter(mAdapetr);
		vp_evnetmanage.setOnPageChangeListener(pageListener);
	}

	/**
	 * 初始化Column栏目项
	 * */
	private void initTabColumn() {
		mRadioGroup_content.removeAllViews();
		int count = userChannelList.size();
		mColumnHorizontalScrollView.setParam(this, mScreenWidth,
				mRadioGroup_content, shade_left, shade_right, rl_column);
		mItemWidth = AppConstants.widthPx / 5;
		for (int i = 0; i < count; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					mItemWidth, LayoutParams.WRAP_CONTENT);
			params.leftMargin = 5;
			params.rightMargin = 5;
			// TextView localTextView = (TextView)
			// mInflater.inflate(R.layout.column_radio_item, null);
			TextView columnTextView = new TextView(this);
			columnTextView.setTextAppearance(this,
					R.style.top_category_scroll_view_item_text);
			// localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
			columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
			columnTextView.setGravity(Gravity.CENTER);
			columnTextView.setPadding(5, 5, 5, 5);
			columnTextView.setId(i);
			columnTextView.setText(userChannelList.get(i).getName());
			columnTextView.setTextColor(getResources().getColorStateList(
					R.color.top_category_scroll_text_color_day));
			if (columnSelectIndex == i) {
				columnTextView.setSelected(true);
			}
			columnTextView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
						View localView = mRadioGroup_content.getChildAt(i);
						if (localView != v)
							localView.setSelected(false);
						else {
							localView.setSelected(true);
							vp_evnetmanage.setCurrentItem(i);
						}
					}
					Toast.makeText(getApplicationContext(),
							userChannelList.get(v.getId()).getName(),
							Toast.LENGTH_SHORT).show();
				}
			});
			mRadioGroup_content.addView(columnTextView, i, params);
		}
	}

	/**
	 * @Description:显示当前的fragment对象
	 * @param which
	 *            第几个对象
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	public void selectFragmentShow(int tab_postion) {
		ft = fm.beginTransaction();
		for (int i = 0; i < fragments.length; i++) {
			if (tab_postion == i) {
				ft.show(fragments[i]);
			} else
				ft.hide(fragments[i]);
		}
		ft.commit();
	}

	/**
	 * ViewPager切换监听方法
	 * */
	public OnPageChangeListener pageListener = new OnPageChangeListener() {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int position) {
			vp_evnetmanage.setCurrentItem(position);
			selectTab(position);
		}
	};

	/**
	 * 选择的Column里面的Tab
	 * */
	private void selectTab(int tab_postion) {
		columnSelectIndex = tab_postion;
		for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
			View checkView = mRadioGroup_content.getChildAt(tab_postion);
			int k = checkView.getMeasuredWidth();
			int l = checkView.getLeft();
			int i2 = l + k / 2 - (AppConstants.widthPx) / 2;
			// rg_nav_content.getParent()).smoothScrollTo(i2, 0);
			mColumnHorizontalScrollView.smoothScrollTo(i2, 0);
			// mColumnHorizontalScrollView.smoothScrollTo((position - 2) *
			// mItemWidth , 0);
		}
		// 判断是否选中
		for (int j = 0; j < mRadioGroup_content.getChildCount(); j++) {
			View checkView = mRadioGroup_content.getChildAt(j);
			boolean ischeck;
			if (j == tab_postion) {
				ischeck = true;
			} else {
				ischeck = false;
			}
			checkView.setSelected(ischeck);
		}
	}

}

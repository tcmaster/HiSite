package com.android.tonight8.activity.live;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.live.EventLive;
import com.android.tonight8.fragment.livemanage.LiveCommitListFragment;
import com.android.tonight8.fragment.livemanage.ProgramListFragment;
import com.android.tonight8.fragment.livemanage.VoteFragment;
import com.android.tonight8.fragment.livemanage.WinnerListFragment;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.LiveIOController;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Descripton 活动现场界面,现场界面用到的4个fragment（）
 * @author LiXiaoSong
 * @2015-5-11
 * @Tonight8
 */
public class EventLivePlayActivity extends BaseActivity {
	/** 滑动布局 */
	@ViewInject(R.id.sv_lv_main)
	private ScrollView sv_lv_main;
	/** 直播界面的ViewPager */
	@ViewInject(R.id.vp_play_screen)
	private ViewPager vp_play_screen;
	/** 额外功能按钮 */
	@ViewInject(R.id.iv_function)
	private ImageView iv_function;
	/** 当前页数/总页数 */
	@ViewInject(R.id.tv_play_num)
	private TextView tv_play_num;
	/** 前一页 */
	@ViewInject(R.id.iv_prev_page)
	private ImageView iv_prev_page;
	/** 播放或暂停 */
	@ViewInject(R.id.iv_play_or_pause)
	private ImageView iv_play_or_pause;
	/** 下一页 */
	@ViewInject(R.id.iv_next_page)
	private ImageView iv_next_page;
	/** 关闭当前直播页 */
	@ViewInject(R.id.iv_power_off)
	private ImageView iv_power_off;
	/** 下载 */
	@ViewInject(R.id.iv_download)
	private ImageView iv_download;
	/** 静音 */
	@ViewInject(R.id.iv_volume)
	private ImageView iv_volume;
	/** 全屏 */
	@ViewInject(R.id.iv_full_screen)
	private ImageView iv_full_screen;
	/** 页面四个选项的radioGroup */
	@ViewInject(R.id.rg_tab)
	private RadioGroup rg_tab;
	/** 商品信息 */
	@ViewInject(R.id.tv_goods_info)
	private TextView tv_goods_info;
	/** 开关附件布局 */
	@ViewInject(R.id.iv_attachment)
	private ImageView iv_attachment;
	/** 输入文字 */
	@ViewInject(R.id.et_content)
	private EditText et_content;
	/** 发送消息 */
	@ViewInject(R.id.tv_send_message)
	private TextView tv_send_message;

	/** 4个页面的fragment列表 */
	private BaseFragment[] bfs;
	/** fg管理器 */
	private FragmentManager fm;
	/** 本界面的handler */
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Live.LIVE_TITLE:
				switch (msg.arg1) {
				case HandlerConstants.NETWORK_BEGIN:

					break;
				case HandlerConstants.RESULT_OK:
					EventLive result = (EventLive) msg.obj;
					getActionBarSpeical(result.getEvent().getName(),
							R.drawable.ic_launcher, true, false,
							new View.OnClickListener() {

								@Override
								public void onClick(View v) {
								}
							});
					break;
				default:
					break;
				}

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_event_live_play);
		initDatas();
	}

	private void initDatas() {
		initInterface();
		initFragments();
	}

	private void initInterface() {
		LiveIOController.readLiveTitle(handler);

	}

	private void initFragments() {
		getActionBarSpeical("某活动现场", R.drawable.ic_launcher, true, false, null);
		bfs = new BaseFragment[4];
		bfs[0] = LiveCommitListFragment.newInstance();
		bfs[1] = WinnerListFragment.newInstance();
		bfs[2] = VoteFragment.newInstance();
		bfs[3] = ProgramListFragment.newInstance();
		if (fm == null)
			fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		for (BaseFragment bf : bfs) {
			ft.add(R.id.ll_lv_container, bf);
			ft.hide(bf);
		}
		ft.commit();
		rg_tab.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_live:
					changeFragment(0);
					break;
				case R.id.rb_winner_list:
					changeFragment(1);
					break;
				case R.id.rb_vote:
					changeFragment(2);
					break;
				case R.id.rb_program_list:
					changeFragment(3);
					break;
				default:
					break;
				}

			}
		});
		rg_tab.check(R.id.rb_live);
	}

	/**
	 * 切换当前显示的fragment
	 * 
	 * @param pos
	 */
	private void changeFragment(int pos) {
		FragmentTransaction ft = fm.beginTransaction();
		for (int i = 0; i < 4; i++) {
			if (i == pos)
				ft.show(bfs[i]);
			else
				ft.hide(bfs[i]);
		}
		ft.commit();
	}

	/** 滑到顶端 */
	public void scrollTop() {
		sv_lv_main.scrollTo(0, 0);
	}
}

package com.android.tonight8.fragment.event;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventAwardListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.model.manageevent.ManageAwardModel;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 奖品发单
 * 
 */
public class AwardSendFragment extends BaseFragment {
	private View rootView;
	/** 活动中奖名单数据适配器 */
	private EventAwardListAdapter listAdapter1;
	private EventAwardListAdapter listAdapter2;
	private EventAwardListAdapter listAdapter3;
	@ViewInject(R.id.lv_fragment_awardlist1)
	private XListView lv_fragment_awardlist1;
	@ViewInject(R.id.lv_fragment_awardlist2)
	private XListView lv_fragment_awardlist2;
	@ViewInject(R.id.lv_fragment_awardlist3)
	private XListView lv_fragment_awardlist3;
	private XListView[] xlistview;
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;
	/** 下拉刷新标识 */
	private final int REFRESH = 1;
	/** 上拉加载标识 */
	private final int LOAD_MORE = 2;
	/** 首次加载标识 */
	private final int INIT = 3;
	@ViewInject(R.id.rg_fragment_awardlist)
	private RadioGroup rg_fragment_awardlist;
	@ViewInject(R.id.rb_award_waiting)
	private RadioButton rb_award_waiting;
	@ViewInject(R.id.rb_award_sended)
	private RadioButton rb_award_sended;
	@ViewInject(R.id.rb_award_signed)
	private RadioButton rb_award_signed;
	/** 已发订单 */
	@ViewInject(R.id.tv_award_sended)
	private TextView tv_award_sended;
	private List<ManageAwardModel> waitinglist;
	private List<ManageAwardModel> sendedlist;
	private List<ManageAwardModel> signedlist;

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.arg1) {
			case HandlerConstants.RESULT_OK:
				if (msg.obj == null)
					return;
				List<ManageAwardModel> data = (List<ManageAwardModel>) msg.obj;
				if (msg.arg2 == INIT) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_fragment_awardlist1.setPullLoadEnable(false);
					else
						lv_fragment_awardlist1.setPullLoadEnable(true);
					listAdapter1 = new EventAwardListAdapter(activity, data);
					lv_fragment_awardlist1.setAdapter(listAdapter1);
				} else if (msg.arg2 == REFRESH) {

					if (data == null || data.size() < ITEM_COUNT)
						lv_fragment_awardlist1.setPullLoadEnable(false);
					listAdapter1.initData(data);
					lv_fragment_awardlist1.stopRefresh();
				} else if (msg.arg2 == LOAD_MORE) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_fragment_awardlist1.setPullLoadEnable(false);
					listAdapter1.addData(data);
					lv_fragment_awardlist1.stopLoadMore();
				}
				break;
			case HandlerConstants.NETWORK_BEGIN:

				break;
			case HandlerConstants.NETWORK_END:

				break;
			case HandlerConstants.RESULT_FAIL:
				List<ManageAwardModel> datafail = (List<ManageAwardModel>) msg.obj;
				listAdapter1.addData(datafail);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}

	};

	public static final AwardSendFragment newInstance() {
		AwardSendFragment awardSendFragment = new AwardSendFragment();
		return awardSendFragment;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_award_send, null);
		ViewUtils.inject(this, rootView);
		initData();
		rg_fragment_awardlist
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup arg0, int arg1) {
						switch (arg1) {
						case R.id.rb_award_waiting:
							waitinglist = new ArrayList<ManageAwardModel>();
							xlistview[0].setAdapter(listAdapter1);
							setListViewVisiable(0);
							listAdapter1.notifyDataSetChanged();
							break;
						case R.id.rb_award_sended:
							waitinglist = new ArrayList<ManageAwardModel>();
							setListViewVisiable(1);
							xlistview[1].setAdapter(listAdapter2);
							break;
						case R.id.rb_award_signed:
							waitinglist = new ArrayList<ManageAwardModel>();
							setListViewVisiable(2);
							xlistview[2].setAdapter(listAdapter3);
							break;

						default:
							break;
						}
					}
				});

		return rootView;
	}

	private void initData() {
		xlistview = new XListView[3];
		xlistview[0] = lv_fragment_awardlist1;
		xlistview[1] = lv_fragment_awardlist2;
		xlistview[2] = lv_fragment_awardlist3;
		waitinglist = new ArrayList<ManageAwardModel>();
		for (int i = 0; i < 10; i++) {
			ManageAwardModel model = new ManageAwardModel();
			waitinglist.add(model);
		}
		sendedlist = new ArrayList<ManageAwardModel>();
		for (int i = 0; i < 10; i++) {
			ManageAwardModel model = new ManageAwardModel();
			sendedlist.add(model);
		}
		signedlist = new ArrayList<ManageAwardModel>();
		for (int i = 0; i < 10; i++) {
			ManageAwardModel model = new ManageAwardModel();
			signedlist.add(model);
		}
		setListViewVisiable(0);
		listAdapter1 = new EventAwardListAdapter(activity, waitinglist);
		xlistview[0].setPullLoadEnable(true);
		xlistview[0].setAdapter(listAdapter1);
		listAdapter2 = new EventAwardListAdapter(activity, sendedlist);
		xlistview[1].setPullLoadEnable(true);
		xlistview[1].setAdapter(listAdapter2);
		listAdapter3 = new EventAwardListAdapter(activity, signedlist);
		xlistview[2].setPullLoadEnable(true);
		xlistview[2].setAdapter(listAdapter3);
	}

	private void setListViewVisiable(int pos) {
		for (int i = 0; i < 3; i++) {
			if (i == pos) {
				xlistview[i].setVisibility(View.VISIBLE);
			} else {
				xlistview[i].setVisibility(View.GONE);
			}
		}
	}
}

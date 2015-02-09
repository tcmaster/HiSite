package com.android.tonight8.fragment.main;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.live.HiLiveAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveListModel;

/**
 * @Description:Hi现场
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class HiLiveFragment extends BaseFragment {

	private View rootView;
	private ListView lv_hiLive;
	private HiLiveAdapter hiLiveAdapter;
	private List<LiveListModel> liveListModels;

	/** 创建一个静态的实例 */
	public static final HiLiveFragment newInstance() {
		HiLiveFragment hiFragment = new HiLiveFragment();
		return hiFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (rootView != null) {
			/* 已存在空的view */
			return rootView;
		}
		rootView = inflater.inflate(R.layout.fragment_hi_live, container, false);
		lv_hiLive = (ListView) rootView.findViewById(R.id.lv_hiLive);
		liveListModels = new ArrayList<LiveListModel>();

		for (int i = 0; i < 10; i++) {
			LiveListModel liveListModel = new LiveListModel();
			Event event = new Event();
			Org org = new Org();
			List<SignIn> signIns = new ArrayList<SignIn>();
			User user = new User();
			user.pic = "http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg";
			user.name = "小明";
			liveListModel.setEvent(event);
			liveListModel.setOrg(org);
			for (int j = 0; j < 5; j++) {
				SignIn signIn = new SignIn();
				signIn.uid = 11032;
				signIn.pic = "http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg";
				signIns.add(signIn);
			}
			liveListModel.setSignIn(signIns);
			liveListModels.add(liveListModel);
		}
		hiLiveAdapter = new HiLiveAdapter(getActivity(), liveListModels);
		lv_hiLive.setAdapter(hiLiveAdapter);
		return rootView;
	}
}

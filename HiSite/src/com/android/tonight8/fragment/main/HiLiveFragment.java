package com.android.tonight8.fragment.main;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.model.live.LiveSubjectModel;

/**
 * @Description:Hi现场
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class HiLiveFragment extends Fragment {

	private View rootView;
	private ListView lv_hiLive;
	// private HiLiveAdapter hiLiveAdapter;
	private List<LiveSubjectModel> liveSubjectModels;

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
		liveSubjectModels = new ArrayList<LiveSubjectModel>();

		for (int i = 0; i < 10; i++) {
			LiveSubjectModel liveSubjectModel = new LiveSubjectModel();
			liveSubjectModels.add(liveSubjectModel);
		}
		// hiLiveAdapter = new HiLiveAdapter(getActivity(), liveSubjectModels);
		// lv_hiLive.setAdapter(hiLiveAdapter);
		return rootView;
	}
}

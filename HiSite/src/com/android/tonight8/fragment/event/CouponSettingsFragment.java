package com.android.tonight8.fragment.event;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.CouponListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz赠券设置
 * 
 */
public class CouponSettingsFragment extends BaseFragment {
	private View rootView;
	private List<String> list;
	@ViewInject(R.id.lv_only_list)
	private XListView xlist;
	private CouponListAdapter couponListAdapter;
	/** 红包类型 */
	@ViewInject(R.id.spinner_redpacket_type)
	private Spinner spinner_redpacket_type;
	/** 金额 */
	private EditText et_coupon_amount;
	/** 满多少金额可用 */
	private EditText et_amount_limit;
	/** 赠券数量 */
	private EditText et_coupon_number;
	/** 保存按钮 */
	private Button btn_savesetting;
	private SpinnerAdapter spinnerAdapter;
	private String[] mItems = { "代金券", "折扣券", "赠品" };

	public static final CouponSettingsFragment newInstance() {
		CouponSettingsFragment couponSettingsFragment = new CouponSettingsFragment();
		return couponSettingsFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_coupon_settings,
				container, false);
		ViewUtils.inject(this, rootView);
		list = new ArrayList<String>();
		// 建立Adapter并且绑定数据源
		ArrayAdapter<String> array_Adapter = new ArrayAdapter<String>(activity,
				android.R.layout.simple_spinner_item, mItems);
		// 绑定 Adapter到控件
		spinner_redpacket_type.setAdapter(array_Adapter);
		couponListAdapter = new CouponListAdapter(getActivity(), list);
		xlist.setAdapter(couponListAdapter);
		return rootView;

	}

	public void updateData(List<String> list) {
		
	}
}

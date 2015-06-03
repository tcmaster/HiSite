package com.android.tonight8.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.tonight8.R;

public class RolePopupWindow extends PopupWindow implements OnClickListener {

	private TextView tv_user;
	private TextView tv_org;
	private TextView tv_seller;
	private RolePopupWindowCallBack callBack;
	private Context context;

	@SuppressWarnings("deprecation")
	public RolePopupWindow(Context c, RolePopupWindowCallBack callBack) {
		this.context = c;
		View view = LayoutInflater.from(context).inflate(R.layout.pw_role_list,
				null);
		tv_user = (TextView) view.findViewById(R.id.tv_user);
		tv_org = (TextView) view.findViewById(R.id.tv_org);
		tv_seller = (TextView) view.findViewById(R.id.tv_seller);
		tv_user.setOnClickListener(this);
		tv_org.setOnClickListener(this);
		tv_seller.setOnClickListener(this);
		setWidth(LayoutParams.WRAP_CONTENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		setBackgroundDrawable(new BitmapDrawable());
		setOutsideTouchable(true);
		setContentView(view);
		this.callBack = callBack;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_user:
			callBack.onUser(tv_user.getText().toString());
			hideWindow();
			break;
		case R.id.tv_org:
			callBack.onOrg(tv_org.getText().toString());
			hideWindow();
			break;
		case R.id.tv_seller:
			callBack.onSeller(tv_seller.getText().toString());
			hideWindow();
			break;
		default:
			break;
		}

	}

	public void showWindow(View v) {
		if (!isShowing()) {
			this.showAsDropDown(v);
		}
	}

	public void hideWindow() {
		if (isShowing()) {
			this.dismiss();
		}
	}

	public interface RolePopupWindowCallBack {
		public void onUser(String userText);

		public void onOrg(String orgText);

		public void onSeller(String sellerText);
	}

}

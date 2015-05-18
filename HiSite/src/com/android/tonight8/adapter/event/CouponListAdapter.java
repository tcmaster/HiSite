package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;

/**
 * @author lz 优惠券列表数据适配器
 *
 */
public class CouponListAdapter extends BaseListAdapter<String> {
	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			int posClick = (Integer) arg0.getTag();
			switch (arg0.getId()) {

			case R.id.btn_coupon_change:

				break;
			case R.id.btn_coupon_delete:

				break;

			default:
				break;
			}
		}
	};

	public CouponListAdapter(Context context, List<String> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_coupon_listitem,
					null, false);
		}
		Button btn_coupon_change = ViewHolder.get(convertView,
				R.id.btn_coupon_change);// 修改
		Button btn_coupon_delete = ViewHolder.get(convertView,
				R.id.btn_coupon_delete);// 删除
		btn_coupon_change.setTag(position);
		btn_coupon_delete.setTag(position);
		btn_coupon_change.setOnClickListener(onClickListener);
		btn_coupon_delete.setOnClickListener(onClickListener);
		return convertView;
	}

}

package com.android.tonight8.adapter.wish;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.MakeWishActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.other.WishAddItem;

/**
 * @author lz 心愿故事数据适配器
 * 
 */
public class WishItemAdapter extends BaseListAdapter<WishAddItem> {
	private MakeWishActivity mActivity;
	public ArrayAdapter adapter;
	private int btn_add = R.drawable.add_item;
	private int btn_reduce = R.drawable.reduce_item;

	public WishItemAdapter(Context context, List<WishAddItem> values) {
		super(context, values);
		mActivity = (MakeWishActivity) mContext;
		List<String> list = new ArrayList<String>();
		list.add("物品");
		list.add("现金");

		adapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_spinner_item, list);
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_wish_story, null);
		}

		Spinner sp_request_type = ViewHolder.get(convertView,
				R.id.sp_request_type);
		EditText et_request_thing = ViewHolder.get(convertView,
				R.id.et_request_thing);
		EditText et_request_reason = ViewHolder.get(convertView,
				R.id.et_request_reason);
		final WishAddItem wishAddItem = mValues.get(position);
		TextView tv_add_item = ViewHolder.get(convertView, R.id.tv_add_item);
		ImageView iv_add_item = ViewHolder.get(convertView, R.id.iv_add_item);
		LinearLayout ll_add_item = ViewHolder
				.get(convertView, R.id.ll_add_item);

		if (wishAddItem.isAdd()) {
			tv_add_item.setText("添加赞助项");
			iv_add_item.setBackgroundResource(btn_add);
		} else {
			tv_add_item.setText("删除赞助项");
			iv_add_item.setBackgroundResource(btn_reduce);
		}
		// et_request_thing.addTextChangedListener(watcher);
		// sp_request_type.setOnItemSelectedListener(new
		// OnItemSelectedListener() {
		//
		// @Override
		// public void onItemSelected(AdapterView<?> parent, View view,
		// int position, long id) {
		// wishAddItem.setType(position);
		// mActivity.updateClickPosition(position,
		// MakeWishActivity.UPDATA_DATA, wishAddItem);
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> parent) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		ll_add_item.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (wishAddItem.isAdd()) {
					mActivity.updateClickPosition(position,
							MakeWishActivity.ADD_DATA, null);

				} else {
					mActivity.updateClickPosition(position,
							MakeWishActivity.DELETE_DATA, null);
				}

			}
		});
		sp_request_type.setAdapter(adapter);
		return convertView;
	}

	private TextWatcher watcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};
}

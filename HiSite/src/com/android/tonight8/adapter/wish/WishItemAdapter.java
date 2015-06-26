package com.android.tonight8.adapter.wish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
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
	private Integer thingindex = -1;
	private Integer reasonindex = -1;

	public WishItemAdapter(Context context, List<WishAddItem> values,
			List<Map<String, Object>> data) {
		super(context, values);
		mInflater = LayoutInflater.from(context);
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
		TextView tv_add_item = ViewHolder.get(convertView, R.id.tv_add_item);
		final TextView tv_wishitem_thing = ViewHolder.get(convertView,
				R.id.tv_wishitem_thing);
		ImageView iv_add_item = ViewHolder.get(convertView, R.id.iv_add_item);
		LinearLayout ll_add_item = ViewHolder
				.get(convertView, R.id.ll_add_item);
		tv_add_item.setTag(position);
		iv_add_item.setTag(position);
		if (mValues.get(position).isAdd()) {
			tv_add_item.setText("添加赞助项");
			iv_add_item.setBackgroundResource(R.drawable.add_item);
		} else {
			tv_add_item.setText("删除赞助项");
			iv_add_item.setBackgroundResource(R.drawable.reduce_item);
		}
		sp_request_type.setSelection(mValues.get(position).getType());
		ll_add_item.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mValues.get(position).isAdd()) {
					mActivity.updateClickPosition(position,
							MakeWishActivity.ADD_DATA, null);

				} else {
					mActivity.updateClickPosition(position,
							MakeWishActivity.DELETE_DATA, null);
				}

			}
		});
		sp_request_type.setAdapter(adapter);
		et_request_thing.setTag(position);
		et_request_thing.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					thingindex = (Integer) v.getTag();
				}
				return false;
			}
		});
		et_request_reason.setTag(position);
		et_request_reason.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					reasonindex = (Integer) v.getTag();
				}
				return false;
			}
		});

		et_request_thing.addTextChangedListener(new MyTextWatcher(
				et_request_thing));
		et_request_reason.addTextChangedListener(new MyTextWatcher(
				et_request_reason));

		et_request_thing.setText(mValues.get(position).getThings());
		et_request_reason.setText(mValues.get(position).getReason());

		et_request_thing.clearFocus();
		if (thingindex != -1 && thingindex == position) {
			et_request_thing.requestFocus();
		}
		et_request_reason.clearFocus();
		if (reasonindex != -1 && reasonindex == position) {
			et_request_reason.requestFocus();
		}
		sp_request_type.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (position == 0) {
					tv_wishitem_thing.setText("物品名称：");
				} else {
					tv_wishitem_thing.setText("金额(元)：");
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		return convertView;
	}

	class MyTextWatcher implements TextWatcher {
		private EditText meditText;

		public MyTextWatcher(EditText editText) {
			meditText = editText;
		}

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
			if (s != null) {
				int position = (Integer) meditText.getTag();
				WishAddItem wItem = null;
				// 当EditText数据发生改变的时候存到data变量中
				if (R.id.et_request_thing == meditText.getId()) {
					wItem = mValues.get(position);
					wItem.setThings(meditText.getText().toString());
					mValues.set(position, wItem);
				} else if (R.id.et_request_reason == meditText.getId()) {
					wItem = mValues.get(position);
					wItem.setReason(meditText.getText().toString());
					mValues.set(position, wItem);
				}

			}
		}
	}
}

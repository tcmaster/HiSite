package com.android.hisite.adapter;

import java.util.List;

import com.android.hisite.R;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class HiLiveAdapter extends BaseListAdapter {

	public HiLiveAdapter(Context context, List values) {
		super(context, values);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected View getItemView(View convertView, int position) {
		mInflater.inflate(R.layout.adapter_hilive, null);
		return convertView;
	}

	class ViewHolder{
//		TextView 
	}
}

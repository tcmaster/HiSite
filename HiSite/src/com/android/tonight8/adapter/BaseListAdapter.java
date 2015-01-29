package com.android.tonight8.adapter;

import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @Description: 关于listview的适配器基类
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

	protected final String TAG = this.getClass().getSimpleName();

	protected Context mContext;
	protected List<T> mValues;
	protected String mRemark;
	protected LayoutInflater mInflater;

	public BaseListAdapter(Context context) {
		super();
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public BaseListAdapter(Context context, List<T> values) {
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mValues = values;
	}

	public BaseListAdapter(Context context, List<T> values, String remark) {
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mValues = values;
		mRemark = remark;
	}

	public BaseListAdapter(Context context, List<T> values, Handler handler) {
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mValues = values;
	}

	public Context getContext() {
		return mContext;
	}

	@Override
	public int getCount() {
		if (mValues != null)
			return mValues.size();
		return 0;
	}

	@Override
	public T getItem(int position) {
		if (position == getCount() - 1 || mValues == null) {
			return null;
		}
		return mValues.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getItemView(convertView, position);
	}

	protected abstract View getItemView(View convertView, int position);

	public void update(List<T> values) {
		mValues = values;
		notifyDataSetInvalidated();
		notifyDataSetChanged();
	}
}

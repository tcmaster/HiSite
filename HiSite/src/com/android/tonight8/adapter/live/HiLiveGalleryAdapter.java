package com.android.tonight8.adapter.live;

import java.util.List;

import com.android.tonight8.R;
import com.lidroid.xutils.BitmapUtils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HiLiveGalleryAdapter extends RecyclerView.Adapter<HiLiveGalleryAdapter.ViewHolder> {

	public interface OnItemClickLitener {

		void onItemClick(View view, int position);
	}

	private OnItemClickLitener mOnItemClickLitener;

	public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
		this.mOnItemClickLitener = mOnItemClickLitener;
	}

	private LayoutInflater mInflater;
	private List<String> mDatas;
	private BitmapUtils bmUtils;

	public HiLiveGalleryAdapter(Context context, List<String> datats) {
		mInflater = LayoutInflater.from(context);
		mDatas = datats;
		bmUtils = new BitmapUtils(context);
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		public ViewHolder(View arg0) {
			super(arg0);
		}

		ImageView mImg;
		RelativeLayout rl_ivparent;
	}

	@Override
	public int getItemCount() {
		if (mDatas == null) {
			return 0;
		}
		return mDatas.size();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View view = mInflater.inflate(R.layout.adapter_index_gallery_item, viewGroup, false);
		ViewHolder viewHolder = new ViewHolder(view);
		viewHolder.rl_ivparent = (RelativeLayout) view.findViewById(R.id.rl_ivparent);
		viewHolder.mImg = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
		bmUtils.display(viewHolder.mImg, mDatas.get(i));
		if (mOnItemClickLitener != null) {
			viewHolder.itemView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mOnItemClickLitener.onItemClick(viewHolder.itemView, i);
				}
			});

		}

	}

}

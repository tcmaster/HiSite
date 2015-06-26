package com.android.tonight8.adapter.wish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.utils.DialogUtils.ReplayNODialogInterface;
import com.android.tonight8.utils.DialogUtils.ReplayOKDialogInterface;
import com.android.tonight8.view.CircleImageView;
import com.android.tonight8.view.xlistview.XListView;

/**
 * @author lz 我的心愿赞助列表
 * 
 */
public class CheckSponsorAdapter extends
		BaseListAdapter<MyWishSponsorListModel> {
	/** 选中的是哪个item */
	private int clickPos;
	/** 回复接受 */
	private final static int REPLAY_OK = 1;
	/** 回复拒绝 */
	private final static int REPLAY_NO = 0;
	private AlertDialog alertDialog;

	public CheckSponsorAdapter(Context context,
			List<MyWishSponsorListModel> values, XListView listView) {
		super(context, values);
	}

	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == HandlerConstants.WISH.MYWISH_REPLAY) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					if (alertDialog != null && alertDialog.isShowing()) {
						alertDialog.dismiss();
					}
					if (msg.arg2 == REPLAY_OK) {
						mValues.get(clickPos).getWishSponsor().setStatus(1);
					} else {
						mValues.get(clickPos).getWishSponsor().setStatus(0);
					}
					notifyDataSetChanged();
				}
			}
		};
	};
	private ReplayOKDialogInterface replayOkListener = new ReplayOKDialogInterface() {

		@Override
		public void getEditText(EditText et_commit, AlertDialog dlg,
				Button btn_replay_right) {
			final String replay = et_commit.getText().toString();
			alertDialog = dlg;
			btn_replay_right.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Map<String, String> params = new HashMap<String, String>();
					params.put("wishSponsor.id", mValues.get(clickPos)
							.getWishSponsor().getId()
							+ "");// 心愿赞助id
					params.put("wishSponsor.status", "1");
					params.put("wishSponsor.sponsorId", mValues.get(clickPos)
							.getWishSponsor().getSponsorId()
							+ "");// 心愿赞助者id
					params.put("content", replay);
					WishIOController.postWishSponsor(handler, params,
							HandlerConstants.WISH.MYWISH_REPLAY, REPLAY_OK);
				}
			});
		}
	};
	private ReplayNODialogInterface replayNoListener = new ReplayNODialogInterface() {

		@Override
		public void getEditText(EditText et_commit, AlertDialog dlg,
				Button btn_replay_right) {
			final String replay = et_commit.getText().toString();
			alertDialog = dlg;
			btn_replay_right.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					Map<String, String> params = new HashMap<String, String>();
					params.put("wishSponsor.id", mValues.get(clickPos)
							.getWishSponsor().getId()
							+ "");// 心愿赞助id
					params.put("wishSponsor.status", "0");
					params.put("wishSponsor.sponsorId", mValues.get(clickPos)
							.getWishSponsor().getSponsorId()
							+ "");// 心愿赞助者id
					params.put("content", replay);
					WishIOController.postWishSponsor(handler, params,
							HandlerConstants.WISH.MYWISH_REPLAY, REPLAY_NO);
				}
			});
		}
	};
	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			clickPos = (Integer) v.getTag();
			Map<String, String> params = null;
			switch (v.getId()) {
			case R.id.btn_check_accept:
				// DialogUtils.showSponsorReplayDialog((BaseActivity) mContext,
				// replayOkListener, null);
				params = new HashMap<String, String>();
				params.put("wishSponsor.id", mValues.get(clickPos)
						.getWishSponsor().getId()
						+ "");// 心愿赞助id
				params.put("wishSponsor.status", "0");
				params.put("wishSponsor.sponsorId", mValues.get(clickPos)
						.getWishSponsor().getSponsorId()
						+ "");// 心愿赞助者id

				WishIOController.postWishSponsor(handler, params,
						HandlerConstants.WISH.MYWISH_REPLAY, REPLAY_OK);
				break;
			case R.id.btn_check_refuse:
				// DialogUtils.showSponsorReplayDialog((BaseActivity) mContext,
				// null, replayNoListener);
				params = new HashMap<String, String>();
				params.put("wishSponsor.id", mValues.get(clickPos)
						.getWishSponsor().getId()
						+ "");// 心愿赞助id
				params.put("wishSponsor.status", "0");
				params.put("wishSponsor.sponsorId", mValues.get(clickPos)
						.getWishSponsor().getSponsorId()
						+ "");// 心愿赞助者id

				WishIOController.postWishSponsor(handler, params,
						HandlerConstants.WISH.MYWISH_REPLAY, REPLAY_NO);
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_check_sponsor,
					null);
		}

		CircleImageView civ_mywish_userpic = ViewHolder.get(convertView,
				R.id.civ_mywishcheck_userpic);
		TextView tv_mywishcheck_username = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_username);
		TextView tv_mywishcheck_sponsortype = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsortype);
		TextView tv_mywishcheck_sponsoritem = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsoritem);
		TextView tv_mywishcheck_sponsorrequest = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsorrequest);
		ImageView iv_mywishcheck_status = ViewHolder.get(convertView,
				R.id.iv_mywishcheck_status);
		TextView tv_mywishcheck_datetime = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_datetime);
		LinearLayout ll_checksponsor_button = ViewHolder.get(convertView,
				R.id.ll_checksponsor_button);
		Button btn_accept = ViewHolder.get(convertView, R.id.btn_check_accept);
		Button btn_refuse = ViewHolder.get(convertView, R.id.btn_check_refuse);

		MyWishSponsorListModel myModel = mValues.get(position);
		tv_mywishcheck_username.setText("北京相宜本化妆品有限公司");
		tv_mywishcheck_sponsorrequest.setText(myModel.getWishSponsor()
				.getDescribe());
		tv_mywishcheck_sponsoritem.setText("赞助的项目");
		tv_mywishcheck_sponsortype.setText(myModel.getWishSponsor().getType()
				+ "");
		if (myModel.getWishSponsor().getStatus() == 1) {
			iv_mywishcheck_status.setVisibility(View.VISIBLE);
			iv_mywishcheck_status.setBackgroundResource(R.drawable.vright_icon);
			ll_checksponsor_button.setVisibility(View.GONE);
		} else if (myModel.getWishSponsor().getStatus() == 0) {
			iv_mywishcheck_status.setVisibility(View.VISIBLE);
			iv_mywishcheck_status.setBackgroundResource(R.drawable.vwrong_icon);
			ll_checksponsor_button.setVisibility(View.GONE);
		} else {
			iv_mywishcheck_status.setVisibility(View.INVISIBLE);
			ll_checksponsor_button.setVisibility(View.VISIBLE);
		}

		tv_mywishcheck_datetime.setText("2015-12-14 11:15");

		btn_accept.setTag(position);
		btn_refuse.setTag(position);
		btn_accept.setOnClickListener(onClickListener);
		btn_refuse.setOnClickListener(onClickListener);
		return convertView;
	}

}

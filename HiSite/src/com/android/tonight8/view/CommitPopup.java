package com.android.tonight8.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.android.tonight8.R;
import com.android.tonight8.utils.Utils;

/**
 * @author 功能描述：评论提交弹出框（继承自PopupWindow）
 */
public class CommitPopup extends PopupWindow {

	/** 发送编辑框 */
	private EditText et_commit;
	private Context mContext;
	// 列表弹窗的间隔
	protected final int LIST_PADDING = 10;
	// 坐标的位置（x、y）
	private final int[] mLocation = new int[2];
	// 弹窗子类项选中时的监听
	private onPostClick onPostClick;
	private View itemPosView;

	public CommitPopup(Context context) {
		// 设置布局的参数
		this(context, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	}

	public CommitPopup(Context context, int width, int height) {
		this.mContext = context;

		// 设置可以获得焦点
		setFocusable(true);
		// 设置弹窗内可点击
		setTouchable(true);
		// 设置弹窗外可点击
		setOutsideTouchable(true);

		// 获得屏幕的宽度和高度
		// mScreenWidth = Util.getScreenWidth(mContext);
		// mScreenHeight = Util.getScreenHeight(mContext);

		// 设置弹窗的宽度和高度
		setWidth(width);
		setHeight(height);

		setBackgroundDrawable(new BitmapDrawable());

		// 设置弹窗的布局界面
		View view = LayoutInflater.from(mContext).inflate(R.layout.dlg_commit,
				null);
		setContentView(view);
		setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		et_commit = (EditText) view.findViewById(R.id.et_commit);
		Button btn_commit_ok = (Button) view.findViewById(R.id.btn_commit_ok);
		btn_commit_ok.setOnClickListener(onclick);
	}

	/**
	 * 显示弹窗列表界面
	 */
	public void show(final View c, View itemPosView) {
		this.itemPosView = itemPosView;
		// 获得点击屏幕的位置坐标
		c.getLocationOnScreen(mLocation);
		// 显示弹窗的位置
		showAtLocation(c, Gravity.BOTTOM, 0, 0);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Utils.showSoftKeyBroad(mContext, et_commit);
			}
		}, 200);

	}

	OnClickListener onclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			dismiss();
			onPostClick.onButtonClick(v, itemPosView, et_commit);
		}

	};

	/**
	 * 设置监听事件
	 */
	public void setPostClick(onPostClick postClick) {
		this.onPostClick = postClick;
	}

	/**
	 * @author 弹窗子类项发送按钮监听事件
	 */
	public static interface onPostClick {
		public void onButtonClick(View v, View itemPosView, EditText et_commit);
	}
}

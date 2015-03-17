package com.android.tonight8.activity.createevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:文本编辑页
 * @author:LiuZhao
 * @Date:2015年2月13日
 */
public class TextEditActivity extends BaseActivity {

	/** 关闭按钮 */
	@ViewInject(R.id.tv_head_close)
	private TextView tv_head_close;
	/** 保存按钮 */
	@ViewInject(R.id.tv_head_save)
	private TextView tv_head_save;
	/** 内容编辑框 */
	@ViewInject(R.id.et_comm)
	private EditText et_comm;
	public static final String INPUT_STRING = "inutString";

	@OnClick({ R.id.tv_head_close, R.id.tv_head_save })
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tv_head_close:
			this.finish();
			break;
		case R.id.tv_head_save:
			Intent intent = new Intent();
			intent.putExtra(INPUT_STRING, et_comm.getText().toString());
			setResult(RESULT_OK, intent);
			this.finish();
			break;

		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_text_edit);
		super.onCreate(savedInstanceState);
	}
}

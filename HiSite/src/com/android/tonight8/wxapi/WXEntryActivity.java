package com.android.tonight8.wxapi;

import android.os.Bundle;

import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.util.LogUtils;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * @Description：微信发出的请求将回调到onReq方法，发送到微信请求的响应结果将回调到onResp方法
 * @date 2015-3-20下午3:52:57
 * @author liuzhao
 */
public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {

	@Override
	public void onReq(BaseReq arg0) {
		LogUtils.i("==onReq()arg0-->" + arg0.getType());

	}

	@Override
	public void onResp(BaseResp arg0) {
		LogUtils.i("==onResp()arg0-->" + arg0.getType());
		switch (arg0.errCode) {
		case BaseResp.ErrCode.ERR_OK:
			Utils.toast("分享成功");
			break;
		case BaseResp.ErrCode.ERR_USER_CANCEL:
			Utils.toast("分享取消");
			break;
		case BaseResp.ErrCode.ERR_AUTH_DENIED:
			Utils.toast("分享被拒绝");
			break;
		default:

			break;
		}

		// TODO 微信分享 成功之后调用接口
		this.finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogUtils.i("==onCreate()");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		LogUtils.i("==onRestart()");
	}

	@Override
	protected void onStart() {
		super.onStart();
		LogUtils.i("==onStart()");
		this.finish();// 分享（成功或失败后）不做任何处理
	}
}

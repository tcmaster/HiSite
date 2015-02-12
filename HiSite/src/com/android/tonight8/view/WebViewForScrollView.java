package com.android.tonight8.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * @Description:webview 和 scrollview事件冲突处理解决方案
 * @author:LiuZhao   
 * @Date:2015年2月12日
 */
public class WebViewForScrollView extends WebView {

	public WebViewForScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public WebViewForScrollView(Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		requestDisallowInterceptTouchEvent(true);
		return super.onTouchEvent(event);
	}

}

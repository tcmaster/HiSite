/**
 * 2015-1-4
 */
package com.android.tonight8.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2015-1-4
 */
public class ListViewForScrollView extends ListView {

	public ListViewForScrollView(Context context) {
		super(context);
	}

	public ListViewForScrollView(Context context, AttributeSet set) {
		super(context, set);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}

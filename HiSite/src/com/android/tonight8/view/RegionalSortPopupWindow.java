package com.android.tonight8.view;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.view.sortlistview.CharacterParser;
import com.android.tonight8.view.sortlistview.PinyinComparator;
import com.android.tonight8.view.sortlistview.SideBar;
import com.android.tonight8.view.sortlistview.SideBar.OnTouchingLetterChangedListener;
import com.android.tonight8.view.sortlistview.SortAdapter;
import com.android.tonight8.view.sortlistview.SortModel;

/**
 * @Descripton 用来显示城市排序的对话框
 * @author LiXiaoSong
 * @2015-3-18
 * @Tonight8
 */
public class RegionalSortPopupWindow {
	private PopupWindow popupWindow;
	private View contentView;
	private Context context;

	public RegionalSortPopupWindow(Context context, int width, int height) {
		this.context = context;
		contentView = LayoutInflater.from(context).inflate(
				R.layout.dlg_regional_search, null);
		popupWindow = new PopupWindow(contentView, width, height);
		popupWindow.setAnimationStyle(R.style.popup_animation);
	}

	/**
	 * 显示popupWindow
	 */
	public void showRegionalDialog(View dropDownView,
			final SortListViewCallBack callBack) {
		popupWindow.showAsDropDown(dropDownView, 0, 20);// 这里的y轴便宜不太准确，后续需要精确计算
		final ListView lv_regional_search = (ListView) contentView
				.findViewById(R.id.lv_regional_search);
		SideBar sb_right = (SideBar) contentView.findViewById(R.id.sb_right);
		TextView tv_pinyin = (TextView) contentView
				.findViewById(R.id.tv_pinyin);
		sb_right.setTextView(tv_pinyin);
		// 测试数据
		String[] data = new String[] { "北京", "天津", "河北", "法国", "安徽", "内蒙古",
				"印度", "尼泊尔", "英国", "土耳其", "西班牙", "北京", "天津", "河北", "法国", "安徽",
				"内蒙古", "印度", "尼泊尔", "英国", "土耳其", "西班牙", "北京", "天津", "河北", "法国",
				"安徽", "内蒙古", "印度", "尼泊尔", "英国", "土耳其", "西班牙" };
		final CharacterParser parser = CharacterParser.getInstance();
		List<SortModel> models = parser.filledData(data);
		final SortAdapter adapter = new SortAdapter(context, models);
		PinyinComparator comparator = new PinyinComparator();
		Collections.sort(models, comparator);// 按拼音牌序
		lv_regional_search.setAdapter(adapter);
		sb_right.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {
				lv_regional_search.setSelection(adapter
						.getPositionForSection(s.getBytes()[0]));
			}
		});
		lv_regional_search.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View item,
					int position, long id) {
				SortModel model = (SortModel) parent.getAdapter().getItem(
						position);
				callBack.getSortModel(model);
				dismissPopWindow();
			}
		});
	}

	/**
	 * @Descripton 用于返回得到的拼音数据
	 * @author LiXiaoSong
	 * @2015-3-18
	 * @Tonight8
	 */
	public interface SortListViewCallBack {
		/**
		 * 当有城市的数据被点击时，该方法被调用
		 * 
		 * @param model
		 */
		public void getSortModel(SortModel model);
	}

	/**
	 * 隐藏popupWindow
	 */
	public void dismissPopWindow() {
		if (isShowing())
			popupWindow.dismiss();
	}

	/**
	 * 当前的popupWindow是否在显示
	 */
	public boolean isShowing() {
		if (popupWindow != null) {
			return popupWindow.isShowing();
		} else
			return false;
	}
}

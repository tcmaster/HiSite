package com.android.tonight8.activity.createevent;

import java.util.Date;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.CalendarView;
import com.android.tonight8.view.CalendarView.OnItemClickListener;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:选择日期的页面
 * @author:LiuZhao
 * @Date:2015年2月13日
 */
public class CalendarActivity extends BaseActivity {

	/** */
	@ViewInject(R.id.cv_select_calendar)
	private CalendarView cv_select_calendar;
	private String[] selectData = { "2015-2-25","2015-2-23","2015-2-18","2014-12-25", "2015-03-25", "2015-4-25", "2015-2-15", "2015-2-2" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_select_calendar);
		super.onCreate(savedInstanceState);
		cv_select_calendar.setSelectMore(false);
		cv_select_calendar.setSelectedOtherDay(selectData);
		cv_select_calendar.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void OnItemClick(Date selectedStartDate, Date selectedEndDate, Date downDate) {
				// TODO Auto-generated method stub

			}
		});
	}

}

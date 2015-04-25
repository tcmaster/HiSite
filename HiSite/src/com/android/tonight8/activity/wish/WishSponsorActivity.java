package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz心愿赞助页面
 * 
 */
public class WishSponsorActivity extends BaseActivity {
	/** 赞助总额 */
	@ViewInject(R.id.tv_spnosor_sum)
	private TextView tv_spnosor_sum;
	/** 差额 */
	@ViewInject(R.id.tv_spnosor_balance)
	private TextView tv_spnosor_balance;
	/** 要赞助的总额 */
	@ViewInject(R.id.et_spnosor_money)
	private EditText et_spnosor_money;
	/** 要赞助的东西 */
	@ViewInject(R.id.lv_sponsor_something)
	private XListView lv_sponsor_something;
	private List<SponsorEntity> list;
	private SomethingSponsorAdapter somethingSponsorAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_wish_sponsor);
		super.onCreate(savedInstanceState);
		getActionBarBase("赞助页面");
		list = new ArrayList<SponsorEntity>();
		SponsorEntity sponsorEntity = new SponsorEntity();
		sponsorEntity.setCheckedSponsor(false);
		sponsorEntity.setSponsorThingName("测试测试");
		list.add(sponsorEntity);
		somethingSponsorAdapter = new SomethingSponsorAdapter(mContext, list);
		lv_sponsor_something.setAdapter(somethingSponsorAdapter);
	}

	private class SomethingSponsorAdapter extends BaseListAdapter<SponsorEntity> {

		public SomethingSponsorAdapter(Context context, List<SponsorEntity> values) {
			super(context, values);

		}

		@Override
		protected View getItemView(View convertView, final int position) {
			convertView = mInflater.inflate(R.layout.adapter_sponsor_something, null);
			TextView tv_sponsor_name = ViewHolder.get(convertView, R.id.tv_sponsor_name);
			CheckBox cb_sponsor_something = ViewHolder.get(convertView, R.id.cb_sponsor_something);
			tv_sponsor_name.setText(list.get(position).getSponsorThingName());
			cb_sponsor_something.setChecked(list.get(position).isCheckedSponsor());
			cb_sponsor_something.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
					SponsorEntity sponsorEntity = new SponsorEntity();
					sponsorEntity.setCheckedSponsor(arg1);
					sponsorEntity.setSponsorThingName(list.get(position).getSponsorThingName());
					list.set(position, sponsorEntity);
				}
			});
			return convertView;
		}
	}

	private class SponsorEntity {
		private String sponsorThingName;
		private boolean isCheckedSponsor = false;

		public String getSponsorThingName() {
			return sponsorThingName;
		}

		public void setSponsorThingName(String sponsorThingName) {
			this.sponsorThingName = sponsorThingName;
		}

		public boolean isCheckedSponsor() {
			return isCheckedSponsor;
		}

		public void setCheckedSponsor(boolean isCheckedSponsor) {
			this.isCheckedSponsor = isCheckedSponsor;
		}

	}
}

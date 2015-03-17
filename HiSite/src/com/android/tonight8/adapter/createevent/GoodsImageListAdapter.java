package com.android.tonight8.adapter.createevent;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.utils.DialogUtils;

/**
 * @Description:发活动第一步用到的奖品详情列表数据适配器
 * @author:LiuZhao
 * @Date:2015年1月29日
 */
public class GoodsImageListAdapter extends BaseListAdapter<Goods> {

	public GoodsImageListAdapter(Context context, List<Goods> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHoler holer = null;
		if (convertView == null) {
			holer = new ViewHoler();
			convertView = mInflater.inflate(R.layout.adapter_goodsimage_list,
					null);
			holer.iv_adapter_goods = (ImageView) convertView
					.findViewById(R.id.iv_adapter_goods_temp);
			holer.tv_adapter_goods_price = (TextView) convertView
					.findViewById(R.id.tv_adapter_goodsName);
			convertView.setTag(holer);
		} else {
			holer = (ViewHoler) convertView.getTag();
		}
		Goods goods = mValues.get(position);
		Tonight8App.getSelf().bitmapUtils.display(holer.iv_adapter_goods,
				goods.getPic());
		holer.tv_adapter_goods_price.setText(goods.getPic() + "");
		// holer.iv_adapter_goods.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// DialogUtils.showSelectPicDialog((BaseActivity) mContext);
		//
		// }
		// });
		// holer.tv_adapter_goods_price.setOnClickListener(new OnClickListener()
		// {
		//
		// @Override
		// public void onClick(View arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		return convertView;
	}

	class ViewHoler {

		ImageView iv_adapter_goods;
		TextView tv_adapter_goods_price;
	}

}

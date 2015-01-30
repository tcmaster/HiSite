package com.android.tonight8.adapter.createevent;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.common.Goods;

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
			convertView = mInflater.inflate(R.layout.adapter_goodsimage_list, null);
			holer.iv_adapter_goods = (ImageView) convertView.findViewById(R.id.iv_adapter_goods);
			holer.tv_adapter_goods_price = (TextView) convertView.findViewById(R.id.tv_adapter_goods_price);
			convertView.setTag(holer);
		} else {
			holer = (ViewHoler) convertView.getTag();
		}
		Goods goods = mValues.get(position);
		Tonight8App.getSelf().bitmapUtils.display(holer.iv_adapter_goods, goods.getPic());
		holer.tv_adapter_goods_price.setText(goods.getPic() + "");
		return convertView;
	}

	class ViewHoler {

		ImageView iv_adapter_goods;
		TextView tv_adapter_goods_price;
	}

}

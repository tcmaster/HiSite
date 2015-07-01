package com.android.tonight8.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.dao.model.live.EventGoodsOrder;
import com.android.tonight8.view.CustomerDialog.CustomerViewInterface;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class GoodsOrderPopupWindow {
	/** 订单号标题 */
	@ViewInject(R.id.tv_title)
	private TextView tv_title;
	/** 海报图片 */
	@ViewInject(R.id.iv_bpic)
	private ImageView iv_bpic;
	/** 商品名称 */
	@ViewInject(R.id.tv_awards)
	private TextView tv_awards;
	/** 商品价值 */
	@ViewInject(R.id.tv_prize)
	private TextView tv_prize;
	/** 商品数量 */
	@ViewInject(R.id.tv_count)
	private TextView tv_count;
	/** 商品已售 */
	@ViewInject(R.id.tv_sold)
	private TextView tv_sold;
	/** 发布商家 */
	@ViewInject(R.id.tv_publish)
	private TextView tv_publish;
	/** 商品尺寸 */
	@ViewInject(R.id.lv_standard)
	private ListViewForScrollView lv_standard;
	/** 减数量 */
	@ViewInject(R.id.ib_sub)
	private ImageButton ib_sub;
	/** 数量输入框 */
	@ViewInject(R.id.et_count)
	private EditText et_count;
	/** 增加数量 */
	@ViewInject(R.id.ib_add)
	private ImageButton ib_add;
	/** 优惠券选择 */
	@ViewInject(R.id.tv_which_coupon)
	private TextView tv_which_coupon;
	/** 商品保障项 */
	@ViewInject(R.id.gv_promise_item)
	private GridViewForScrollView gv_promise_item;
	/** 收货地址 */
	@ViewInject(R.id.tv_address)
	private TextView tv_address;
	/** 修改地址 */
	@ViewInject(R.id.btn_change_address)
	private Button btn_change_address;
	/** 现场价 */
	@ViewInject(R.id.tv_value_scene)
	private TextView tv_value_scene;
	/** 实付价 */
	@ViewInject(R.id.tv_value_net)
	private TextView tv_value_net;
	/** 取消 */
	@ViewInject(R.id.btn_cancel)
	private Button btn_cancel;
	/** 确认 */
	@ViewInject(R.id.btn_cancel)
	private Button btn_ok;

	private Context context;
	private GoodsOrderPWCallBack callBack;
	private CustomerDialog cdlg;
	private BitmapUtils bmUtils;
	/** 商品订单 */
	private EventGoodsOrder order;

	public GoodsOrderPopupWindow(Activity context,
			GoodsOrderPWCallBack callBack, final EventGoodsOrder order) {
		this.context = context;
		this.callBack = callBack;
		cdlg = new CustomerDialog(context, R.layout.pw_goods_order);
		cdlg.setLayoutGravity(Gravity.BOTTOM);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				ViewUtils.inject(GoodsOrderPopupWindow.this,
						window.findViewById(R.id.sv_parent));
				tv_awards.setText(order.getGoods().getName());
				tv_prize.setText(order.getGoods().getCurrentValue() + "");
				tv_count.setText(order.getGoods().getLimitNumber() + "");
				tv_sold.setText(order.getGoods().getSaleCount() + "");
				tv_publish.setText(order.getOrg().getName());
				et_count.setText("1");
				et_count.setHint("请输入购买数量");
				tv_address.setText("");
			}
		});
	}

	public void showWindow() {
		if (cdlg != null)
			cdlg.showDlg();
	}

	public void hideWindow() {
		if (cdlg != null)
			cdlg.dismissDlg();
	}

	public interface GoodsOrderPWCallBack {

	}
}

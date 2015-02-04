package com.android.tonight8.storage.createevent;

import java.util.List;
import android.content.Context;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Ready;
import com.android.tonight8.model.createevent.CreateEventModel;

/**
 * @Description:活动预览
 * @author:LiuZhao
 * @Date:2015年2月3日
 */
public class CreateEventPreviewStepNativeController {

	public static String STORE_NAME = "CREATE_EVENT";
	private Context context;

	public CreateEventPreviewStepNativeController(Context context) {
		super();
		this.context = context;
	}

	/**
	 * @Description:获取活动预览信息详情
	 * @return
	 * @author: LiuZhao
	 * @date:2015年2月3日
	 */

	public CreateEventModel getEventDetailModelData() {
		CreateEventModel createEventModel = new CreateEventModel();
		CreateEventFirstStepNativeController fistController = new CreateEventFirstStepNativeController(context);
		CreateEventSecondStepNativeController secondController = new CreateEventSecondStepNativeController(context);
		CreateEventThirdStepNativeController thirdController = new CreateEventThirdStepNativeController(context);

		Event event = fistController.readCreateEventFirstStepEvent();
		event.setCityAll(thirdController.readCreateEventSecondStepEvent().isCityAll());
		createEventModel.setEvent(event);

		Ready ready = fistController.readCreateEventFirstStepReady();
		ready.setIsCouponNoneAward(secondController.readCreateEventSecondStepReady().isCouponNoneAward);
		createEventModel.setReady(ready);

		CouponProvide couponProvide = secondController.readCreateEventSecondStepCouponProvide();
		createEventModel.setCouponProvide(couponProvide);

		List<Goods> goodses = fistController.readCreateEventFirstStepGoods();
		createEventModel.setGoodses(goodses);

		Exchange exchange = thirdController.readCreateEventSecondStepExchange();
		createEventModel.setExchange(exchange);
		return createEventModel;
	}

}

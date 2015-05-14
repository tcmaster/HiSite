/**
 * 2015-3-3
 */
package com.android.tonight8.activity.event;

import android.os.Bundle;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:兑奖地址显示
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-3-3
 */
public class ExchangeLocationActivity extends BaseActivity {

	/** 地图视图 */
	@ViewInject(R.id.mv_exchange_location)
	private MapView mv_exchange_location;
	// ****************************其他成员***************************//
	private BaiduMap bm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_exchange_location);
		super.onCreate(savedInstanceState);
		getActionBarBase("商家地址");
		initDatas();

	}

	private void initDatas() {
		bm = mv_exchange_location.getMap();
		setOrgLocation();
	}

	/**
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-3-3
	 */
	private void setOrgLocation() {
		LatLng latLng = new LatLng(39.9, 116.3);
		MapStatus mapStatus = new MapStatus.Builder().zoom(15).target(latLng)
				.build();
		bm.setMapStatus(MapStatusUpdateFactory.newMapStatus(mapStatus));
		BitmapDescriptor descriptor = BitmapDescriptorFactory
				.fromResource(R.drawable.location_middle);
		OverlayOptions options = new MarkerOptions().position(latLng)
				.draggable(false).icon(descriptor).title("北京正统");
		bm.addOverlay(options);
		View view = new View(this);
		view.setBackgroundResource(R.drawable.talk_red);
		InfoWindow infoWindow = new InfoWindow(view, latLng, -40);
		bm.showInfoWindow(infoWindow);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mv_exchange_location.onDestroy();

	}

	@Override
	protected void onPause() {
		super.onPause();
		mv_exchange_location.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mv_exchange_location.onResume();
	}
}

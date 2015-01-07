/**
 * 2015-1-6
 */
package com.android.hisite.function;

import android.content.Context;

import com.android.utils.Utils;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

/**
 * @Description: 定位
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-6
 */
public class LocationFunction {

	private LocationClient client;
	private Context context;

	public LocationFunction(Context con) {
		this.context = con;
		client = new LocationClient(context);
		LocationClientOption lco = new LocationClientOption();
		lco.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		lco.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
		lco.setOpenGps(true);// 设置打开gps
		lco.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
		lco.setIsNeedAddress(true);// 返回的定位结果包含地址信息
		lco.setNeedDeviceDirect(true);
		client.setLocOption(lco);
	}

	/**
	 * 开始定位
	 * 
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-1-6
	 */
	public void beginLocation(BDLocationListener listener) {
		if (client != null) {
			client.registerLocationListener(listener);
			client.start();
			if (Utils.isNetConn(context)) {
				if (client.isStarted())
					client.requestLocation();
			} else {
				if (client.isStarted())
					client.requestOfflineLocation();
			}
		}
	}

	/**
	 * 
	 * @Description:关闭定位服务
	 * @author: LiXiaoSong
	 * @date:2015-1-6
	 */
	public void stopLocation() {
		if (client != null && client.isStarted())
			client.stop();
	}
}

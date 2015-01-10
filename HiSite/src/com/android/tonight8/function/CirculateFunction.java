/**
 * 2014-12-29
 */
package com.android.tonight8.function;

import android.os.Handler;

/**
 * @Description:轮播逻辑类，根据总大小，每隔固定间隔按顺序返回相应的数字
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-29
 */
public class CirculateFunction {

	private Handler mHandler;
	private int maxSize;
	private int second;
	private boolean isStop = false;
	private boolean isPause = false;

	public CirculateFunction(int maxSize, int second, Handler handler) {
		mHandler = handler;
		this.maxSize = maxSize;
		this.second = second;
	}

	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				/**
				 * 当前需要返回的页数
				 */
				int i = 0;
				while (!isStop) {
					try {
						while (isPause && !isStop)
							// 如果设置了暂停，则暂时停止轮播
							Thread.sleep(100);
						Thread.sleep(1000 * second);
						if (i == maxSize - 1) {
							i = 0;
						} else {
							i++;
						}
						mHandler.sendEmptyMessage(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void stop() {
		isStop = true;
	}

	public void pause() {
		isPause = true;
	}

	public void resume() {
		isPause = false;
	}
}

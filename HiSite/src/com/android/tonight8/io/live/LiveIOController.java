package com.android.tonight8.io.live;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.live.entity.LiveCommentsNetEntity;
import com.android.tonight8.io.live.entity.LiveListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.net.NetUtils;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.live.LiveCommentModel;
import com.android.tonight8.model.live.LiveDetailModel;
import com.android.tonight8.model.live.LiveListModel;
import com.android.tonight8.storage.live.LiveStorage;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Description:读取活动现场列表数据
 * @author:LiuZhao
 * @Date:2015年2月5日
 */
public class LiveIOController {

	private static final String LIVE_LIST_URL = NetRequest.BASE_URL + "";
	private static final String LIVE_DETAIL_URL = NetRequest.BASE_URL + "";
	private static final String LIVE_SUBJECT_URL = NetRequest.BASE_URL + "/api/scene/subject";
	private static final String LIVE_SUBJECT_WRITE_URL = NetRequest.BASE_URL + "/api/scene/subject_write";
	private static final String LIVE_COMMENT_URL = NetRequest.BASE_URL + "/api/scene/comments_list";
	private static final String LIVE_COMMENT_WRITE_URL = NetRequest.BASE_URL + "/api/scene/comment_write";

	/**
	 * @Description：从接口中获取活动现场列表 2015-2-5下午8:36:39
	 * @author liuzhao
	 */
	public static void liveListRead(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_LIST_URL);
		NetRequest.doGetRequest(params, new RequestResult<LiveListNetEntity>(LiveListNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, LiveListNetEntity t, Handler handler) {
				if (t != null) {
					List<LiveListModel> listModel = t.getArrayLiveEventsData().getEvent_live_events();
					// 数据库存储逻辑
					LiveStorage.getLiveListDBController().insertData(listModel);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("LiveListRead is failed");
			}

		});
	}

	/**
	 * @Description：从接口中获取活动详情 2015-2-5下午8:59:19
	 * @author liuzhao
	 */
	public static void liveDetailRead(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_DETAIL_URL);
		NetRequest.doGetRequest(params, new RequestResult<LiveDetailModel>(LiveDetailModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, LiveDetailModel t, Handler handler) {
				if (t != null) {
					// 数据库存储逻辑
					LiveStorage.getLiveDetailDBController().insertData(t);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("liveDetailRead is failed");
			}

		});
	}

	/**
	 * @Description：从接口中获取现场话题列表
	 * @date 2015-2-5下午9:02:29
	 * @author liuzhao
	 */
	public static void liveSubjectsRead(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_SUBJECT_URL);
		NetRequest.doGetRequest(params, new RequestResult<LiveDetailModel>(LiveDetailModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, LiveDetailModel t, Handler handler) {
				if (t != null) {
					// 数据库存储逻辑
					LiveStorage.getLiveDetailDBController().insertData(t);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("liveSubjectsRead is failed");
			}

		});
	}

	/**
	 * @Description：现场话题录入
	 * @date 2015-2-5下午9:02:29
	 * @author liuzhao
	 */
	// public static void liveSubjectWrite() {
	// Map<String, String> params = new HashMap<String, String>();
	// params.put(NetRequest.REQUEST_URL, LIVE_SUBJECT_WRITE_URL);
	// NetRequest.doPostRequest(params, new RequestResult<LiveSubjectModel>(
	// LiveSubjectModel.class) {
	//
	// @Override
	// public void getData(NetEntityBase netEntityBase, LiveSubjectModel t) {
	// if (t != null) {
	//
	// // 数据库存储逻辑
	// LiveStorage.getLiveSubjectNativeController().insertData(t);
	// }
	// }
	//
	// @Override
	// public void onFailure(HttpException arg0, String arg1) {
	// LogUtils.v("liveSubjectWrite is failed");
	// }
	//
	// });
	// }

	/**
	 * @Description：现场评论列表
	 * @date 2015-2-5下午9:02:29
	 * @author liuzhao
	 */
	public static void liveCommentsRead(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_COMMENT_URL);
		NetRequest.doGetRequest(params, new RequestResult<LiveCommentsNetEntity>(LiveCommentsNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, LiveCommentsNetEntity t, Handler handler) {
				if (t != null) {
					List<LiveCommentModel> listModel = t.getArrayLiveCommentsData().getEvent_live_subjects();
					// // 数据库存储逻辑
					LiveStorage.getLiveCommentsController().insertData(listModel);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("liveSubjectWrite is failed");
			}

		});
	}

	/**
	 * @Description：现场评论录入
	 * @date 2015-2-5下午9:02:29
	 * @author liuzhao
	 */
	public static void liveCommentWrite(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_COMMENT_WRITE_URL);
		NetRequest.doPostRequest(params, new RequestResult<Comment>(Comment.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, Comment t, Handler handler) {
				if (NetUtils.checkResult(netEntityBase)) {
					// 数据库存储逻辑
					LiveStorage.getLiveCommentNativeController().insertData(t);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("liveCommentWrite is failed");
			}

		});
	}

	/**
	 * @Description：现场评论回复录入
	 * @date 2015-2-5下午9:02:29
	 * @author liuzhao
	 */
	public static void liveCommentReplyWrite(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_COMMENT_WRITE_URL);
		NetRequest.doPostRequest(params, new RequestResult<Comment>(Comment.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, Comment t, Handler handler) {

				if (NetUtils.checkResult(netEntityBase)) {
					// // 数据库存储逻辑
					// LiveStorage.getLiveCommentNativeController().insertData(t);

				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("liveCommentReplyWrite is failed");
			}

		});
	}
}

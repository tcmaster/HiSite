package com.android.tonight8.dao.entity;

/**
 * 消息列表中的消息实体
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-4-20
 * @Tonight8
 */
public class TMessage {
	private String userPic;// 用户头像
	private String userName;// 用户名称
	private String userLastMessage;// 用户最后一条信息
	private String lastTime;// 用户最后一条消息的时间

	public TMessage() {
		userLastMessage = "";
		lastTime = "";
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastMessage() {
		return userLastMessage;
	}

	public void setUserLastMessage(String userLastMessage) {
		this.userLastMessage = userLastMessage;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

}

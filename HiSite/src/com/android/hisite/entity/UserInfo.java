/**
 * 2014-12-29
 */
package com.android.hisite.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2014-12-29
 */
public class UserInfo implements Serializable {

	public String username;
	public String age;
	public String sex;
	List<String> hobby = new ArrayList<String>();
	Girl girlInfo = new Girl();

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", age=" + age + ", sex=" + sex + ", hobby=" + hobby + ", girlInfo=" + girlInfo + "]";
	}

}

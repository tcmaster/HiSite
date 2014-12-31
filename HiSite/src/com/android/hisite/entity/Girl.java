/**
 * 2014-12-29
 */
package com.android.hisite.entity;

import java.io.Serializable;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2014-12-29
 */
public class Girl implements Serializable {

	public String name;
	public String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + ", age=" + age + "]";
	}

}

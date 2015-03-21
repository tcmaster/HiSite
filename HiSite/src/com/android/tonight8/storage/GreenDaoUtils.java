package com.android.tonight8.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.tonight8.dao.DaoMaster;
import com.android.tonight8.dao.DaoSession;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.async.AsyncSession;

/**
 * @Descripton 数据库操作工具类
 * @author LiXiaoSong
 * @2015-3-20
 * @Tonight8
 */
public class GreenDaoUtils {
	private static DaoMaster master;

	public static void init(Context context) {
		SQLiteDatabase db = new DaoMaster.DevOpenHelper(context, "tonight_8",
				null).getWritableDatabase();
		master = new DaoMaster(db);
	}

	public static DaoSession getDaoSession() {
		return master.newSession();
	}

	public static AsyncSession getAsyncDaoSession() {
		return master.newSession().startAsyncSession();
	}

	/**
	 * 插入或更新操作，先从数据库查询是否有该条数据，有进行插入，没有进行更新（指定列）
	 * 
	 * @param dao
	 *            dao接口
	 * @param data
	 *            要进行存入或更新的数据
	 * @param property
	 *            更新时的条件的key
	 * @param value
	 *            更新时条件的value
	 * @param columns
	 */
	public static <T> void insertOrUpdate(AbstractDao<T, Long> dao, T data,
			Property property, Object value, String... columns) {
		if (dao.queryBuilder().where(property.eq(value)).build().list().size() == 0)
			dao.insert(data);
		else
			dao.update(data, columns);
	}
}

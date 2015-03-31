package com.android.tonight8.storage;

import java.util.Date;
import java.util.List;

import android.R.bool;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.tonight8.dao.DaoMaster;
import com.android.tonight8.dao.DaoSession;
import com.tencent.wxop.stat.t;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.async.AsyncSession;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;

/**
 * @Descripton 数据库操作工具类
 * @author LiXiaoSong
 * @2015-3-20
 * @Tonight8
 */
public class GreenDaoUtils {
	private static DaoMaster master;

	public static void init(Context context) {
		SQLiteDatabase db = new DaoMaster.DevOpenHelper(context, "tonight_8", null).getWritableDatabase();
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
	public static <T> void insertOrUpdate(AbstractDao<T, Long> dao, T data, Property property, Object value,
			String... columns) {
		if (dao.queryBuilder().where(property.eq(value)).build().list().size() == 0)
			dao.insert(data);
		else
			dao.update(data, columns);
	}

	/**
	 * 插入或更新操作（异步版），先从数据库查询是否有该条数据，有进行插入，没有进行更新（指定列）
	 * 
	 */
	public static <T> void insertOrUpdate(AsyncSession session, AbstractDao<T, Long> dao, Property property,
			Object value, T data, String... columns) {
		if (dao.queryBuilder().where(property.eq(value)).build().list().size() == 0) {
			session.insert(data);
		} else
			session.update(data, columns);
	}

	/**
	 * @Title: delelteData
	 * @Description: 删除操作
	 * @param @param dao
	 * @param @param key 主键
	 * @return void 返回类型
	 * @throws
	 */
	public static <T> void delelteData(AbstractDao<T, Long> dao, long key) {
		dao.deleteByKey(key);
	}

	/**
	 * @Title: delelteAllData
	 * @Description: 删除单表所有数据
	 * @param @param dao
	 * @return void 返回类型
	 * @throws
	 */
	public static void delelteAllData(AbstractDao<t, Long> dao) {
		dao.deleteAll();
	}

	/**
	 * @Title: selectData
	 * @Description: 查询操作(单条)
	 * @param @param dao
	 * @param @param data
	 * @param @param property
	 * @param @param whereCondition
	 * @param @return 设定文件
	 * @return T 返回类型
	 * @throws
	 */
	public static <T> T selectData(AbstractDao<T, Long> dao, T data, Property property, WhereCondition whereCondition) {
		T t = dao.queryBuilder().where(whereCondition).build().unique();
		return t;
	}

	/**
	 * @Title: selectListData
	 * @Description: 查询操作(多条)
	 * @param @param dao
	 * @param @param whereCondition 检索条件
	 * @param @param offset 跳过多少条
	 * @param @param limit 最大检索条数
	 * @param @param isDesc 是否降序排列
	 * @param @param descProperty 排序的字段
	 * @param @return 设定文件
	 * @return List<T> 返回类型
	 * @throws
	 */
	public static <T> List<T> selectListData(AbstractDao<T, Long> dao, WhereCondition whereCondition, int offset,
			int limit, boolean isDesc, Property descProperty) {
		QueryBuilder<T> queryBuilder2 = dao.queryBuilder();
		if (whereCondition != null) {
			queryBuilder2.where(whereCondition);
		}
		if (isDesc) {
			queryBuilder2.limit(limit).offset(offset).orderDesc(descProperty);
		} else {
			queryBuilder2.limit(limit).offset(offset).orderAsc(descProperty);
		}
		List<T> list = queryBuilder2.list();

		return list;
	}

}

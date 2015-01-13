package com.android.tonight8.storage;

import java.util.List;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

/**
 * 数据库基类
 * 
 * @author LiXiaoSong
 * 
 */
public class DBUtil {
	private static DbUtils utils;

	public static void initDB(Context context) {
		utils = DbUtils.create(context);
	}

	/**
	 * 查询表中所有数据
	 * 
	 * @param clazz
	 *            确定是哪个表
	 * @return
	 */
	public static <T> List<T> getData(Class<T> clazz) {
		List<T> result = null;
		try {
			result = utils.findAll(clazz);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据条件查询数据
	 * 
	 * @param clazz
	 *            什么表
	 * @param expr
	 *            查询子句
	 * @return
	 */
	public static <T> List<T> getData(Class<T> clazz, String expr) {
		List<T> result = null;
		try {
			result = utils.findAll(Selector.from(clazz).expr(expr));
		} catch (DbException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 向数据库增加一条数据
	 * 
	 * @param entity
	 *            存入的实体
	 */
	public static void addData(Object entity) {
		try {
			utils.save(entity);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量增加数据
	 * 
	 * @param entities
	 *            批量增加的数据
	 */
	public static void addData(List<Object> entities) {
		try {
			utils.saveAll(entities);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 *            要更新的实体
	 * @param builder
	 *            条件
	 * @param updateColumnNames
	 *            要更新哪一列
	 */
	public static void updateData(Object entity, WhereBuilder builder,
			String... updateColumnNames) {
		try {
			utils.update(entity, builder, updateColumnNames);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param entities
	 *            要删除的数据实体
	 */
	public static void deleteData(List<Object> entities) {
		try {
			utils.deleteAll(entities);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}

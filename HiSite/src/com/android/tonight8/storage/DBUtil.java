package com.android.tonight8.storage;

import java.lang.reflect.Field;
import java.util.Arrays;
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
	 * 查询某条数据
	 * 
	 * @param clazz
	 *            什么表
	 * @param expr
	 *            查询子句
	 * @return 返回的子集
	 */
	public static <T> T getDataFirst(Class<T> clazz, String expr) {
		T t = null;
		try {
			t = utils.findFirst(Selector.from(clazz).expr(expr));
		} catch (DbException e) {
			e.printStackTrace();
		}
		return t;

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
	public static void updateData(Object entity, WhereBuilder builder, String... updateColumnNames) {
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

	/**
	 * 
	 * @Description:将对象一中名称和类型相同的数值赋值给类型二的对象（必须保证同名的对象的类型也相同）
	 * @param clazz1
	 *            对象一的类型
	 * @param clazz2
	 *            对象二的类型
	 * @param t1
	 *            对象一
	 * @param t2
	 *            对象二
	 * @author: LiXiaoSong
	 * @date:2015-1-20
	 */
	public static <T1, T2> void copyData(Class<T1> clazz1, Class<T2> clazz2, T1 t1, T2 t2) {
		Field[] fields1 = getDeclaedFields(clazz1);
		Field[] fields2 = getDeclaedFields(clazz2);
		for (int i = 0; i < fields1.length; i++) {
			if (fields1[i].getName().equals("serialVersionUID")) {
				continue;
			}
			for (int j = 0; j < fields2.length; j++) {
				Field f1 = fields1[i];
				Field f2 = fields2[j];
				f1.setAccessible(true);
				f2.setAccessible(true);
				if (f1.getName().equals(f2.getName()) && f1.getType().getSimpleName().equals(f2.getType().getSimpleName())) {// 两个变量名称相同，可以进行赋值
					try {
						f2.set(t2, f1.get(t1));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @Description:得到父类和本类的所有成员变量类
	 * @param clazz
	 *            确定是什么类
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-21
	 */
	private static <T> Field[] getDeclaedFields(Class<T> clazz) {
		Field[] first = clazz.getDeclaredFields();
		Field[] second = clazz.getSuperclass().getDeclaredFields();
		return concat(first, second);
	}

	/**
	 * 合并两个数组
	 */
	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
}

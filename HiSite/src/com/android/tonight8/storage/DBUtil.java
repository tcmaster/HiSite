package com.android.tonight8.storage;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;

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
	 * 查询若干条数据，列表用
	 */
	public static <T> List<T> getData(Class<T> clazz, int limit, int offset) {
		List<T> result = null;
		try {
			result = utils.findAll(Selector.from(clazz).limit(limit)
					.offset(offset).orderBy("id", true));
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
	public static void addDataAll(List<?> entities) {
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
	 * 按某列更新或插入单条数据
	 */
	public static <T> void saveOrUpdate(Object myEntity, Class<T> clazz,
			WhereBuilder where, String... updateColumns) {
		try {
			utils.saveOrUpdate(myEntity, where, updateColumns);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入或更新数据(没有该数据则插入，有则更新)，单条
	 * 
	 * 仅适用于继承BaseEntity的实体
	 * 
	 * @param updateColumns
	 *            在更新的情况下，指定更新哪些行，如果参数为0，则代表所有行都更新
	 */
	public static <T> void saveOrUpdate(Object myEntity, Class<T> clazz,
			String... updateColumns) {
		try {
			utils.saveOrUpdateNoTransaction(myEntity, null, updateColumns);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 得到数据库工具对象，用于自订制操作
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-2-4
	 */
	public static DbUtils getDB() {
		return utils;
	}

	/**
	 * 插入或更新数据(没有该数据则插入，有则更新),多条
	 * 
	 * 仅适用于继承BaseEntity的实体
	 * 
	 * @param updateColumns
	 *            在更新的情况下，指定更新哪些行，如果参数为0，则代表所有行都更新
	 */
	public static <T> void saveOrUpdateAll(List<T> entities, Class<T> clazz,
			String... updateColumns) {
		try {
			utils.saveOrUpdateAllNoTransaction(entities, WhereBuilder.b(),
					updateColumns);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 开启事务
	 */
	public static void beginTransation() {
		utils.beginBatTransaction();
	}

	/**
	 * 设置事务成功
	 */
	public static void setTransactionSuccessful() {
		utils.setBatTransactionSuccessful();
	}

	/**
	 * 结束事务
	 */
	public static void endTransation() {
		utils.endBatTransactionSuccessful();
	}

	public static <T> void saveOrUpdateAll(List<T> entities, Class<T> clazz,
			List<WhereBuilder> builders, String... updateColumns) {
		try {
			utils.saveOrUpdateAllNoTransaction(entities, builders,
					updateColumns);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	public static void updateAll(List<?> entities, String... updateColumnNames) {
		try {
			utils.updateAll(entities, updateColumnNames);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	public static void updateAll(List<?> entities, WhereBuilder builder,
			String... updateColumnNames) {
		try {
			utils.updateAll(entities, builder, updateColumnNames);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	public static void saveOrUpdateAll(List<?> entities) {
	}

	public static void saveOrUpdate(Object object) {
		// 防报错
	}

	/**
	 * 删除某条数据
	 * 
	 * @param entities
	 *            要删除的数据实体
	 * @param id
	 *            要删除的id值
	 */
	public static <T> void deleteData(Class<T> clazz, Object id) {
		try {
			utils.deleteById(clazz, id);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 条件删除数据
	 * 
	 */
	public static <T> void deleteData(Class<T> clazz, String sql) {
		try {
			utils.delete(clazz, WhereBuilder.b().expr(sql));
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除所有数据
	 */
	public static <T> void deleteData(Class<T> clazz) {
		try {
			utils.deleteAll(clazz);
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
	public static <T1, T2> void copyData(Class<T1> clazz1, Class<T2> clazz2,
			T1 t1, T2 t2) {
		Field[] fields1 = getDeclaedFields(clazz1);
		Field[] fields2 = getDeclaedFields(clazz2);
		if (t1 == null || t2 == null) {
			LogUtils.v("解析内容出错,类型1" + clazz1.getSimpleName() + "类型2"
					+ clazz2.getSimpleName());
			return;
		}
		for (int i = 0; i < fields1.length; i++) {
			if (fields1[i].getName().equals("serialVersionUID")) {
				continue;
			}
			for (int j = 0; j < fields2.length; j++) {
				Field f1 = fields1[i];
				Field f2 = fields2[j];
				f1.setAccessible(true);
				f2.setAccessible(true);
				if (f1.getName().equals(f2.getName())
						&& f1.getType().getSimpleName()
								.equals(f2.getType().getSimpleName())) {// 两个变量名称相同，可以进行赋值
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

	public static void close() {
		utils.close();
	}
}

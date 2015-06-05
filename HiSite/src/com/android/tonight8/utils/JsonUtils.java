package com.android.tonight8.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.util.LogUtils;

/**
 * 解析JSON的实体类
 * 
 * @author LiXiaoSong
 * 
 */
public class JsonUtils {

	public static String newJsonkey = "";
	private static String key1 = "";//
	private static List<String> classList;// 实体类列表
	private static String[] imgs = {
			"http://img4.imgtn.bdimg.com/it/u=2352711400,4289515900&fm=11&gp=0.jpg",
			"http://img4.imgtn.bdimg.com/it/u=3923171974,2721923014&fm=21&gp=0.jpg",
			"http://img0.imgtn.bdimg.com/it/u=3934165751,994592123&fm=21&gp=0.jpg",
			"http://img4.imgtn.bdimg.com/it/u=3027043412,2228507304&fm=21&gp=0.jpg",
			"http://img2.imgtn.bdimg.com/it/u=3255667149,1938179631&fm=21&gp=0.jpg",
			"http://img1.gamersky.com/image2013/05/20130518u_6/gamersky_24small_48_20135181047D16.jpg",
			"http://image.tianjimedia.com/uploadImages/2013/081/77E8DL96VPZ4_0000784667.jpg",
			"http://img4.imgtn.bdimg.com/it/u=1195536478,3585633064&fm=21&gp=0.jpg" };

	public static <T> T parseJsonStr(String jsonStr, Class<T> clazz) {
		T t = JSON.parseObject(jsonStr, clazz);
		LogUtils.v(t.toString());
		return t;
	}
	public static <T> List<T> parseJsonList(String jsonStr, Class<T> clazz) {
		List<T> t = (List<T>) JSON.parseArray(jsonStr, clazz);
		LogUtils.v(t.toString());
		return t;
	}
	public static String getObjectToString(JSONObject jsonObject) {

		Iterator<Entry<String, Object>> it = jsonObject.entrySet().iterator();
		Set<String> keysey = jsonObject.keySet();
		key1 = key1 + "," + keysey.toString().replace("[", "").replace("]", "");
		while (it.hasNext()) {
			Entry<String, Object> entiy = it.next();
			String key = entiy.getKey();
			Object value = entiy.getValue();
			newJsonkey = newJsonkey + key + ",";

			if (value instanceof Integer) {
				// newJson = newJson + key;
			} else if (value instanceof String) {
				// newJson = newJson + key;
			} else if (value instanceof List) {
				String str = value.toString().substring(1,
						value.toString().length() - 1);
				if (str.contains("}},")) {
					str = str.substring(0, str.indexOf("}},") + 2);
				}

				JSONObject jsonObject2 = JSON.parseObject(str);
				Set<String> keysey2 = jsonObject2.keySet();
				key1 = key1 + ","
						+ keysey2.toString().replace("[", "").replace("]", "");
				for (int i = 0; i < keysey2.size(); i++) {
					newJsonkey = newJsonkey + key + ",";
					getObjectToString(jsonObject2);
				}

			} else if (value instanceof JSONObject) {
				getObjectToString((JSONObject) value);

			}
		}

		return newJsonkey.substring(0, newJsonkey.length() - 1);
	}

	public static String getStringData(String jsonkey, JSONObject jsonObject) {
		String jsonObjectString = jsonObject.toString();
		String[] json = jsonkey.split(",");
		for (int i = 0; i < json.length; i++) {
			if (json[i].contains("_")) {
				String tempString = json[i];
				String newStr = getFirstLetterToUpper(json[i]);
				jsonObjectString = jsonObjectString.replace(tempString, newStr);
			}
		}
		if (jsonObjectString.contains("_")) {
			String tempString = "";
			String[] tempJson = jsonObjectString.split("_");
			for (int j = 1; j < tempJson.length; j++) {
				String str1 = StringUtils.firstLetterToUpper(tempJson[j]);
				tempString = tempString + str1;
			}
			tempString = tempJson[0] + tempString;
			jsonObjectString = tempString;
		}
		return jsonObjectString;
	}

	private static String getFirstLetterToUpper(String keyStr) {
		String tempJsonStr = "";
		if (!StringUtils.isNullOrEmpty(keyStr) && keyStr.contains("_")) {
			String[] tempJson = keyStr.split("_");
			for (int i = 1; i < tempJson.length; i++) {
				keyStr = StringUtils.firstLetterToUpper(tempJson[i]);
				tempJsonStr = tempJsonStr + keyStr;
			}
			tempJsonStr = tempJson[0] + tempJsonStr;
		} else {
			tempJsonStr = keyStr;
		}
		return tempJsonStr;
	}

	public static <T> T getVirualData(Class<T> clazz) {
		T result = null;
		try {
			result = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				Type type = field.getGenericType();
				if (type instanceof ParameterizedType) {
					Type rawType = ((ParameterizedType) type).getRawType();
					if (rawType.toString().equals(List.class.toString())
							|| rawType.toString().equals(
									ArrayList.class.toString())) {
						Type[] actualType = ((ParameterizedType) type)
								.getActualTypeArguments();
						String name = actualType[0].toString().substring(6,
								actualType[0].toString().length());
						field.set(result,
								getVirualDataList(Class.forName(name)));
					}
				} else {
					String name = type.toString();
					System.out.println("base is" + name);
					if (name.equals("int")
							|| name.equals(Integer.class.toString())) {
						// æ¨¡æ‹Ÿä¸€æ?¡intæ•°æ?®
						field.set(result, 919);
					} else if (name.equals("float")
							|| name.equals(Float.class.toString())) {
						field.set(result, 1.0f);
					} else if (type.toString().equals(String.class.toString())) {
						if (field.getName().toLowerCase().contains("url")
								|| field.getName().toLowerCase()
										.contains("pic")) {
							field.set(result,
									imgs[(int) (Math.random() * imgs.length)]);
						} else
							field.set(result, "字符串测试");
					} else if (name.equals("long")
							|| name.equals(Long.class.toString())) {
						field.set(result, 919L);
					} else if (name.equals("double")
							|| name.equals(Double.class.toString())) {
						field.set(result, 1.0d);
					} else {
						if (classList == null || classList.size() == 0) {
							classList = getEntityName();
						}
						if (!classList.contains(clazz.getSimpleName())) {
							if (name.contains("class"))
								name = name.substring(6, name.length());
							field.set(result,
									getVirualData(Class.forName(name)));
						}

					}
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <T> List<T> getVirualDataList(Class<T> clazz) {
		List<T> value = new ArrayList<T>();
		for (int i = 0; i < 10; i++)
			value.add(getVirualData(clazz));
		return value;
	}

	private static List<String> getEntityName() {
		List<String> names = new ArrayList<String>();
		names.add("Address");
		names.add("Apply");
		names.add("Audio");
		names.add("Award");
		names.add("Comment");
		names.add("Consult");
		names.add("Coordinate");
		names.add("Coupon");
		names.add("CouponDispatch");
		names.add("CouponProvide");
		names.add("DetailPic");
		names.add("Direct");
		names.add("Event");
		names.add("Exchange");
		names.add("ExchangeAddress");
		names.add("ExchangeCity");
		names.add("Express");
		names.add("ExpressMonitor");
		names.add("Follow");
		names.add("Goods");
		names.add("GoodsCategory");
		names.add("GoodsService");
		names.add("GoodsSpecification");
		names.add("GoodsStandard");
		names.add("GoodsStock");
		names.add("GoodsStockItem");
		names.add("Member");
		names.add("MessageConfig");
		names.add("MessageSetting");
		names.add("Notice");
		names.add("Order");
		names.add("Org");
		names.add("Photo");
		names.add("PlayBill");
		names.add("PopPic");
		names.add("PPT");
		names.add("PPTFrame");
		names.add("Prize");
		names.add("QuickMark");
		names.add("Ready");
		names.add("Regional");
		names.add("Seller");
		names.add("SignIn");
		names.add("Source");
		names.add("Subject");
		names.add("Theme");
		names.add("ThirdPartyAccount");
		names.add("TMessage");
		names.add("Translate");
		names.add("TService");
		names.add("User");
		names.add("Vote");
		names.add("VoteItem");
		names.add("Waiter");
		names.add("Wish");
		names.add("WishItem");
		names.add("WishSponsor");
		return names;
	}
}

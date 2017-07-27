package util;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 无敌工具类
 * @author ej
 *
 */
public class OUtils {
	
	/**
	 * 对象转Json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	
	public static String toJson(Object object) throws Exception{
		if(object == null)
			return "null";
		if(object instanceof Character)
			return getJson((Character)object);
		if(object instanceof Boolean)
			return getJson((Boolean)object);
		if(object instanceof Number)
			return getJson((Number)object);
		if(object instanceof CharSequence)
			return getJson((CharSequence)object);
		if(object.getClass().isArray())
			return getJson((Object[])object);
		if(object instanceof Collection)
			return getJson((Collection<?>)object);
		if(object instanceof Map)
			return getJson((Map<?, ?>)object);
		return getJson(object);
	}
	
	/**
	 * 字符转Json对象
	 * @param object
	 * @return
	 */
	private static String getJson(Character object){
		return "\""+object+"\"";
	}

	/**
	 * 布尔转Json对象
	 * @param object
	 * @return
	 */
	private static String getJson(Boolean object){
		return object.toString();
	}

	/**
	 * 数值(整型&浮点)转Json对象
	 * @param object
	 * @return
	 */
	private static String getJson(Number object){
		return object.toString();
	}

	/**
	 * 字符序列转Json字符串
	 * @param object
	 * @return
	 */
	private static String getJson(CharSequence object){
		return "\""+object+"\"";
	}

	/**
	 * 数组转Json对象
	 * @param object
	 * @return
	 * @throws Exception
	 */
	private static String getJson(Object[] object) throws Exception{
		return getJson(Arrays.asList(object));
	}

	/**
	 * 集合转Json对象
	 * @param object
	 * @return
	 * @throws Exception
	 */
	private static String getJson(Collection<?> object) throws Exception{
		StringBuffer buf = new StringBuffer();
		boolean needComma = false;
		buf.append('[');
		Iterator<?> it = object.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			if(obj == null)continue;
			if(needComma)buf.append(',');
			if(!needComma)needComma = true;
			buf.append(toJson(obj));
		}
		buf.append(']');
		return buf.toString();
	}
	
	/**
	 * 散列转Json对象
	 * @param object
	 * @return
	 * @throws Exception
	 */
	private static String getJson(Map<?, ?> object) throws Exception{
		StringBuffer buf = new StringBuffer();
		buf.append('{');
		Iterator<?> it = object.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			Object val = object.get(key);
			buf.append(key).append(':').append(toJson(val));
			if(it.hasNext())buf.append(',');
		}
		buf.append('}');
		return buf.toString();
	}

	/**
	 * 对象转Json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	private static String getJson(Object object) throws Exception{
		if(object == null)return null;
		try {
			StringBuffer buf = new StringBuffer();
			buf.append('{');
			Class<?> c = object.getClass();
			Iterator<Field> it = Arrays.asList(c.getDeclaredFields()).iterator();
			while(it.hasNext()){
				Field f = it.next();
				f.setAccessible(true);
				String key = f.getName();
				Object val = f.get(object);
				buf.append(key).append(':').append(toJson(val));
				if(it.hasNext())buf.append(',');
			}
			buf.append('}');
			return buf.toString();
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * MD5特征码
	 * @param string
	 * @return
	 */
	public static String md5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			string = buf.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return string;
	}

}

package org.ez.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
	
	/**
	 * convert the entity to map if the attribute has a get method
	 * <br>
	 * do not ignore null value
	 * @date 2018-04-01 14:45:01
	 * @author Ruiqing.Piao
	 * @param obj
	 * @return
	 */
	public static <T> Map<String, Object> toMap(T obj){
		return toMap(obj,false);
	}
	
	/**
	 * converts the entity to map if the attribute has a get method
	 * @date 2018-04-01 14:51:45
	 * @author Ruiqing.Piao
	 * @param obj
	 * @param ignoreNull	if ignore null value
	 * @return
	 */
	public static <T> Map<String, Object> toMap(T obj,boolean ignoreNull){
		Class<?> clazz = obj.getClass();
		Method[] methods = clazz.getMethods();
		Map<String,Object> map = new HashMap<>();
		for(Method method : methods) {
			String name = method.getName();
			if(!Modifier.isStatic(method.getModifiers()) && Modifier.isPublic(method.getModifiers()) && method.getGenericParameterTypes().length <=0 && !name.equals("getClass") && name.startsWith("get")) {
				try {
					Object retu = method.invoke(obj);
					if(ignoreNull && null == retu) {
						continue;
					}
					map.put(StringUtils.toLowerCaseFirstOne(name.substring(3)),retu);
				} catch (Exception e) {}
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		ResponseData resp = ResponseData.success();
		System.out.println(BeanUtils.toMap(resp));
	}

}

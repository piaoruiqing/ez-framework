package org.ez.common.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ez.common.format.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ObjectMapperUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);
	
	private static final ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss","yyyy-MM-dd"));
		mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
	}
	
	public static void main(String[] args) {
		Map<String, Date> map = new HashMap<>();
		map.put("date", new Date());
		map.put("date2", null);
		System.out.println(ObjectMapperUtil.writeValueAsString(map));
		Map<String, Date> map2 = ObjectMapperUtil.readValue("{\"date\":\"2018-05-08 11:53:14\"}", new TypeReference<Map<String, Date>>() {});
		System.out.println(map2);
	}
	
	public static String writeValueAsString(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			logger.error("write value as string error",e);
		}
		return null;
	}
	
	public static <T> T readValue(byte[] src ,Class<T> valueType) {
		try {
			return mapper.readValue(src, valueType);
		} catch (Exception e) {
			logger.error("read value error",e);
		}
		return null;
	}
	
	public static <T> T readValue(String src ,Class<T> valueType) {
		try {
			return mapper.readValue(src, valueType);
		} catch (Exception e) {
			logger.error("read value error",e);
		}
		return null;
	}
	
	public static <T> T readValue(String src ,TypeReference<T> valueTypeRef) {
		try {
			return mapper.readValue(src, valueTypeRef);
		} catch (Exception e) {
			logger.error("read value error",e);
		}
		return null;
	}
	
}

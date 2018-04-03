package org.ez.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
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
	
}

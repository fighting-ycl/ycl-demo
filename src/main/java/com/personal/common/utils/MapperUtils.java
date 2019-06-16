package com.personal.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MapperUtils {
	private static ObjectMapper mapper = new ObjectMapper();
	private static Logger log = LoggerFactory.getLogger(MapperUtils.class);

	public static <T> T readValue(String body, Class<T> c) {
		T readValue = null;
		try {
			readValue = mapper.readValue(body, c);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readValue;
	}

	public static String writeValueAsString(Object o) {
		String objStr = "";
		try {
			objStr = mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			log.error("对象json序列化失败");
		}
		return objStr;
	}
}

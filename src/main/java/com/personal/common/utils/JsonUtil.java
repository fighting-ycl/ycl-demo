package com.personal.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * json操作工具类.
 * @author LiXiaoZhen
 */
@Component
public class JsonUtil {


    private static ObjectMapper mapper;

    static void permutation(String[] str, int start, int end) {

        if (start == end - 1) {
            for (int i = 0; i < end; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {

            for (int i = start; i < end; i++) {
                if (i == 0 && str[0].equals("0"))
                    continue;
                swap(str, start, i);
                permutation(str, start + 1, end);

                swap(str, start, i);
            }
        }
    }
    static void swap(String[] str, int start, int end) {
        String tmep = str[start];
        str[start] = str[end];
        str[end] = tmep;
    }

    public static void main(String[] args) {
        String str[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        permutation(str, 0, str.length);
    }
    /**
     * 初始化
     */
    private static void init(){
        if(mapper==null){
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        }
    }

    /**
     * json转实体
     * @param jsonString json字符串
     * @param clazz 实体类
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            init();
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
        	e.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJsonArrBean(String jsonString,Class<?> collectionClass, Class<?>... elementClasses) {
        try {
            init();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
            return   mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 实体转json
     * @param object 实体类
     * @return json字符串
     */
    public static String toJson(Object object) {
        try {
            init();
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     16 * 获取泛型的Collection Type
     17 * @param collectionClass 泛型的Collection
     18 * @param elementClasses 元素类
     19 * @return JavaType Java类型
     20 * @since 1.0
     21 */
  public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
           return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
         }

}

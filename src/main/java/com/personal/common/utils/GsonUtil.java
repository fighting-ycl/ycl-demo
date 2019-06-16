package com.personal.common.utils;/*
 * ------------------------------------------------------------
 *
 * Copyright (c) 2018, haokan
 * All rights reserved.
 * @Author： Steven
 * Date：2018/7/25
 * Description： TODO
 * Created by Steven.Wang
 * -----------------------------------------------------------
 *
 */

import com.google.common.reflect.TypeToken;
import com.google.gson.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Steven.wang
 * @create 2018-07-25 11:13
 **/

public class GsonUtil {
    //不用创建对象,直接使用Gson.就可以调用方法
    private static Gson gson = null;

    //判断gson对象是否存在了,不存在则创建对象
    static {
        if (gson == null) {
            //gson = new Gson();
            //当使用GsonBuilder方式时属性为空的时候输出来的json字符串是有键值key的,显示形式是"key":null，而直接new出来的就没有"key":null的
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//            gson = new GsonBuilder().registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
//                @Override
//                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
//                    if (src == src.longValue()) {
//                        return new JsonPrimitive(src.longValue());
//                    }
//                    return new JsonPrimitive(src);
//                }
//            }).setDateFormat("yyyy-MM-dd HH:mm:ss").create();


//            gson = new GsonBuilder().registerTypeAdapter(new TypeToken<TreeMap<String, Object>>() {
//            }.getType(), new JsonDeserializer<TreeMap<String, Object>>() {
//                @Override
//                public TreeMap<String, Object> deserialize(
//                        JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                    TreeMap<String, Object> treeMap = new TreeMap<>();
//                    JsonObject jsonObject = json.getAsJsonObject();
//                    Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
//                    for (Map.Entry<String, JsonElement> entry : entrySet) {
//                        treeMap.put(entry.getKey(), entry.getValue());
//                    }
//                    return treeMap;
//                }
//            }).create();


        }
    }

    //无参的私有构造方法
    private GsonUtil() {
    }

    /**
     * 将对象转成json格式
     *
     * @param object
     * @return String
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 将json转成特定的cls的对象
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            //传入json对象和对象类型,将json转成对象
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * json字符串转成list
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            //根据泛型返回解析指定的类型,TypeToken<List<T>>{}.getType()获取返回类型
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json字符串转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * json字符串转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    public static <T> TreeMap<String, T> GsonToTreeMaps(String gsonString) {
//        Map<String, T> map = null;
//        if (gson != null) {
//            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
//            }.getType());
//        }
        TreeMap<String, T> map =
                gson.fromJson(gsonString, new TypeToken<TreeMap<String, Object>>(){}.getType());
        return map;
    }


}

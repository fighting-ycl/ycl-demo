package com.personal.service;

import com.personal.entity.Reflect;

import java.lang.reflect.Field;

/**
 * @author : YangChunLong
 * @date : Created in 2019/6/19 00:34
 * @description: 测试服务
 * @modified By:
 * @version: :
 */
public class testService {
    public static void main(String[] args) {
        try {
            Reflect reflect = new Reflect();
            Class c = reflect.getClass();
            Class c1 = Class.forName("com.personal.entity.Reflect");
            Field[] field = c.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                System.out.println(field[i]);
            }
            Object obj = c.getConstructor().newInstance();
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

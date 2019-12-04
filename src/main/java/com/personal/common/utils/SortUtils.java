package com.personal.common.utils;

import org.springframework.stereotype.Service;

/**
 * @author : YangChunLong
 * @date : Created in 2019/6/13 10:19
 * @description: 排序算法
 * @modified By:
 * @version: :
 */
@Service
public class SortUtils {


    /**
     * @author     : YangChunLong
     * @date       : Created in 2019/6/13 11:38
     * @description: 插入排序
     * @modified By:
      * @Param: arrays
     * @return     : int[]
     */
    public int[] insertSort (int[] arrays){
        int len = arrays.length;
        for (int i = 1; i < len; i++) {
            int insertNum = arrays[i];
            int j = i-1;
            while (j>=0 && insertNum<arrays[j]){
                arrays[j+1] = arrays[j];
                j--;
            }
            arrays[j+1] = insertNum;
        }
        return arrays;
    }

    /**
     * @author     : YangChunLong
     * @date       : Created in 2019/12/4 09:52
     * @description: 冒泡排序 ,复杂度O(n^2)
     * @modified By:
      * @Param: array
     * @return     : int[]
     */
    public static int[] maopaoSort (int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (array[j]>array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        array = maopaoSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

package utils;

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
}

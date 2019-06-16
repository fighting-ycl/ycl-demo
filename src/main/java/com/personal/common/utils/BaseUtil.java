package com.personal.common.utils;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseUtil {
    public static <T> List<T> getPage(List<T> list, int size, int page) {
        Integer begin = list.size() > (page - 1) * size ? (page - 1) * size : -1;
        Integer end = list.size() > page * size ? page * size : list.size();
        list = begin > -1 ? list.subList(begin, end) : (List<T>) Lists.newArrayList();
        return list;
    }

    /**
     * @Description: Set 截取数据
     * @Param: [objSet, size]
     * @return: java.util.Set<?>
     * @Author: Steven.Wang
     * @Date: 2019/1/3 17:17
     */
    public static Set<?> subSet(Set<?> objSet, int size) {
        if (CollectionUtils.isEmpty(objSet)) {
            return Collections.emptySet();
        }
        return ImmutableSet.copyOf(Iterables.limit(objSet, size));
    }

    /**
     * list截取
     *
     * @param list
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static <T> List<T> subList(List<T> list, int startIndex, int endIndex) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        int size = list.size();
        if (startIndex > size) {
            return null;
        }
        if (endIndex >= size) {
            return list.subList(startIndex, size);
        }
        return list.subList(startIndex, endIndex);
    }


    public static List<List<?>> splitList(List<?> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }
        List<List<?>> result = new ArrayList<List<?>>();
        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<?> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }


    /**
     * 计算订阅量
     *
     * @param magazineId
     * @param intval
     * @return
     */
    public static String getSubscribeCount(int magazineId, boolean intval) {
        double weight = Double.parseDouble("0.6" + magazineId % 10);
        Long nowTime = System.currentTimeMillis() / 1000L;
        double sum = Math.ceil(nowTime / 1000 - 1750000 + (nowTime - 1440724975) * 0.25 * weight);
        if (intval) {
            return String.valueOf((int) sum);
        }
        return (double) Math.round(sum / 100) / 100 + "万";
    }

    /**
     * 计算收藏数
     * 收藏数：（50~100）间随机数+（当前时间-2017年11月30日)*(36~56)间随机数
     *
     * @return
     */
    public static long getCollectCount() {
        int ran = RandomUtils.nextInt(50) + 50;
        int ran1 = RandomUtils.nextInt(20) + 36;
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.format_yyyyMMdd);
        try {
            long l = sdf.parse("20171130").getTime();
            long l2 = sdf.parse(sdf.format(new Date())).getTime();
            long diff = (l2 - l) / (1000 * 60 * 60 * 24);
            long result = ran + diff * ran1;
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0l;
    }

    /**
     * 计算分享数
     * 分享数：收藏数 / (7~9)间随机数
     *
     * @return
     */
    public static long getShareCount(long collectNum) {
        int ran = RandomUtils.nextInt(2) + 7;
        return collectNum / ran;

    }


    /**
     * 计算带"w"的显示
     *
     * @param num
     * @return
     */
    public static String getHumanNum(double num) {
        double value = num / 10000;
        float result = (float) (Math.round(value * 100)) / 100;
        return result + "w";
    }

    public static void main(String[] args) {

//          encrypation("18912345678",5);
        String aa = "18912345678";
        for (int i = 0; i < aa.length(); i++) {
            System.out.println(encrypation(aa, 5)[i]);
        }
        System.out.println("!!!!!" + encrypation("18912345678", 5));
//        System.out.print(deciphering(string,5)[i]);
//        double base = 29734654;
//        System.out.print(getHumanNum(base));
//        System.out.println("******************************");
//
//        System.out.println(isContainNum("样养123ycl"));
//        System.out.println(getNumbers("样12养123ycl12"));
//        System.out.println(getNumbers("yuangyang"));
//        Scanner imput1 = new Scanner(System.in);
//        Scanner imput2 = new Scanner(System.in);
//        System.out.println("*****************************");
//        System.out.println("*****加密字符串输入---1---");
//        System.out.println("*****解密字符串输入---2---");
//        System.out.println("*****************************");
//        System.out.print("请输入：");
//        int flag = imput1.nextInt();
//        System.out.print("请输入一个英文字符串：");
//        String string = imput2.nextLine();
//        if (flag == 1) {
//            System.out.print("经过加密后为：");
//            for (int i = 0; i < string.length(); i++) {
//                System.out.print(encrypation(string,5)[i]);
//            }
//        }
//        if (flag == 2) {
//            System.out.print("经过解密后为：");
//            for (int i = 0; i < string.length(); i++) {
//                System.out.print(deciphering(string,5)[i]);
//            }
//        }
//
//        imput1.close();
//        imput2.close();
    }

    /**
     * 二进制转base64字符串
     *
     * @param data
     * @return
     */
    public static String Base64encode(byte[] data) {
        try {
            return new String(Base64.encodeBase64(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * base64字符串转二进制
     *
     * @param string
     * @return
     */
    public static byte[] Base64decode(String string) {
        byte[] data = null;
        try {
            data = Base64.decodeBase64(string);
            for (int i = 0; i < data.length; i++) {
                if (data[i] < 0) {
                    data[i] += 256;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getRandomNum(int num) {
        int a[] = new int[num];
        StringBuffer b = new StringBuffer();
        b.append("9");
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (10 * (Math.random()));
            b.append(a[i]);
        }
        return b.toString();
    }

    /**
     * 判断字符串中是否包含数字
     *
     * @param str
     * @return
     * @Author YangChunLong
     */
    public static boolean isContainNum(String str) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }


    /**
     * 如果字符串中有数字，则获取第一个连续的数字字符串，如果没有数字，则返回空
     *
     * @param content
     * @return
     * @Author YangChunLong
     */
    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }


    /**
     * 是否含有特殊字符，若有 则返回 true ,若没有 则返回 false
     *
     * @param str
     * @return
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static char[] encrypation(String str, int num) {//加密方法
        char chararry[] = str.toCharArray();//把字符串转化为字符数组
        for (int i = 0; i < str.length(); i++) {
            //当读到字母表后3位时，加密后是字母表前三位
            if (str.charAt(i) >= 88 && str.charAt(i) <= 90) {//大写时
                chararry[i] = (char) (str.charAt(i) - 23);
            } else if (str.charAt(i) >= 120 && str.charAt(i) <= 122) {//小写时
                chararry[i] = (char) (str.charAt(i) - 23);
            }
            //一般加密方法
            else {
                chararry[i] = (char) (str.charAt(i) + num);
            }

        }
        return chararry;
    }

    public static char[] deciphering(String str, int num) {//j解密方法
        char chararry[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            //当读到字母表前3位时，加密后是字母表后三位
            if (str.charAt(i) >= 65 && str.charAt(i) <= 67) {//大写时
                chararry[i] = (char) (str.charAt(i) + 23);
            } else if (str.charAt(i) >= 97 && str.charAt(i) <= 99) {//小写时
                chararry[i] = (char) (str.charAt(i) + 23);
            }
            //一般解密密方法
            else {
                chararry[i] = (char) (str.charAt(i) - num);
            }

        }
        return chararry;
    }
}

package com.personal.common.utils;/*
 * ------------------------------------------------------------
 *
 * Copyright (c) 2018, haokan
 * All rights reserved.
 * @Author： Steven
 * Date：2018/6/6
 * Description： TODO
 * Created by Steven.Wang
 * -----------------------------------------------------------
 *
 */


import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

/**
 * @author Steven.wang & maoyian
 * @create 2018-06-06 18:45
 **/

public class EmojiUtil {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(EmojiUtil.class);

        public static boolean isNotEmojiCharacter(char codePoint) {
            return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
                    || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                    || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
        }

        public static String replaceEmoji(String source) {
            if (StringUtils.isBlank(source)) {
                return source;
            }
            int len = source.length();
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < len; i++) {
                char codePoint = source.charAt(i);
                if (!isNotEmojiCharacter(codePoint)) {
                    buf.append("[emoji]" + Integer.toHexString((int) codePoint) + "[/emoji]");
                } else {
                    buf.append(codePoint);
                }
            }
            return buf.toString();
        }

        public static   String returnEmoji(String source) {
            if (StringUtils.isBlank(source)) {
                return "";
            }
            String s = source;
            while (source.indexOf("[emoji]") >= 0 && source.indexOf("[/emoji]") > 0) {
                int begin = source.indexOf("[emoji]");
                int end = source.indexOf("[/emoji]");
                String code = source.substring(begin + 7, end);
                char a = '.';
                try {
                    a = (char) Integer.parseInt(code, 16);
                } catch (Exception e) {
                    logger.warn("emoji转码失败：参数：source = {},code = {}，异常：", s, code, e);
                }
                source = source.substring(0, begin) + a + source.substring(end + 8);
            }
            return source;
        }

        public static void main(String[] args) throws Exception {
            String s = "\"毛怿安\ud83d\ude04\"方\ud83d\ude04}adsadasdewrew"
                    + "中文中文"
                    + "asd"
                    + "阿";
//            s = s + s;
//            s = s + s;

           //s= s  +"\ud83d\ude04"+"[emoji]d83d[/emoji][emoji]de0d[/emoji]";//+"\u6bdb";
//             s = new String(s.getBytes("ISO-8859-1"),"UTF-8");
            long t1 = System.currentTimeMillis();
            System.out.println("s:["+s+"]");
            String s2 = replaceEmoji(s);
//            System.out.println("changed:["+s2+"]");
//            System.out.println("changed:["+returnEmoji(s2)+"]");
            String sss= returnEmoji("[emoji]d83d[/emoji][emoji]de0d[/emoji]s哇没干坏事就熬 iopsa 哇没whousdua 干dsad 坏事 就熬[emoji]d83d[/emoji][emoji]de0d[/emoji]s哇没干坏事就熬");
            System.out.println(returnEmoji("[emoji]d83d[/emoji][emoji]de0d[/emoji]s哇没whousdua 干dsad 坏事 就熬[emoji]d83d[/emoji][emoji]de0d[/emoji]s哇没干坏事就熬"));
//            long t2 = System.currentTimeMillis();
//            System.out.println(String.format("emoji转换,转换耗时%d", (t2 - t1)));
//            s = returnEmoji(s);
//            long t3 = System.currentTimeMillis();
//            System.out.println(String.format("emoji反转换,转换耗时%d", (t3 - t2)));

//            sss  ="hhgj含含糊糊哈哈哈哈哈啊啊啊啊哈哈哈";
            System.out.println(getSubString(sss,30));
        }

    public static String getSubString(String str, int length) {
        int count = 0;
        int offset = 0;
        char[] c = str.toCharArray();
        int size = c.length;
        if(size >= length){
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 256) {
                    offset = 2;
                    count += 2;
                } else {
                    offset = 1;
                    count++;
                }
                if (count == length) {
                    return str.substring(0, i + 1);
                }
                if ((count == length + 1 && offset == 2)) {
                    return str.substring(0, i);
                }
            }
        }else{
            return str;
        }
        return "";
    }


}

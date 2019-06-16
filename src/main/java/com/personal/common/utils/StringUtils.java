package com.personal.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: Steven.Wang
 * @Date: 2018/8/29 08:58
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 检查字符串str是否匹配正则表达式regex
     *
     * @param regex 正则表达式
     * @param str   要检查的字符串
     * @return boolean
     */
    public static boolean matcherRegex(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 检查电子邮件是否正确
     *
     * @param email 电子邮件
     * @return boolean 邮箱正确返回true，否则返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return matcherRegex(regex, email);
    }

    /**
     * 转换编码到GBK
     *
     * @param ContentStr
     * @return
     */
    public static String convertToGBK(String ContentStr, String charsetName) throws UnsupportedEncodingException {
        return new String(ContentStr.getBytes(charsetName), "GBK");
    }

    /**
     * 判断字符串是否是数字（不为null，""或" "）
     *
     * @param str
     * @return
     */
    public static boolean isNotBlankNumeric(String str) {
        if (isNotBlank(str) && isNumeric(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符类型
     *
     * @param ch 传入的字符
     * @return int 隔断字符（空格、制表）返回0，数字返回1，字母返回2，其他返回3
     */
    public static int tokenCharType(char ch) {
        if ((ch == ' ') || (ch == '\t')) {
            return 0;
        }
        if ((ch >= '0') && (ch <= '9')) {
            return 1;
        }
        if ((ch >= 'A') && (ch <= 'Z')) {
            return 2;
        }
        return 3;
    }

    public static String removeEnter(String str) {
        if (isNotEmpty(str)) {
            str = remove(str, "\r");
            str = remove(str, "\n");
        }
        return str;
    }

    /**
     * 去掉终端号码的86前缀
     *
     * @param termid String
     * @return String
     */
    public static String trim86(String termid) {
        return termid.startsWith("86") ? termid.substring(2) : termid;
    }

    /**
     * 将InputStream转成字符串
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    /**
     * 将InputStream转成字符串
     *
     * @param is
     * @return
     */
    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }


    /**
     * int 型数字转换成字符串
     *
     * @param i
     * @return
     */
    public static String intToString(int i) {
        return new Integer(i).toString();
    }

    public static int Str2Int(String s) {

        int ii = 0;

        if (s == null || s.equals(""))
            return 0;
        else {

            try {
                ii = Integer.parseInt(s);
            } catch (Exception e) {

            }
        }
        return ii;

    }

    /**
     * 获取随机串
     *
     * @param length 随机串长度
     * @param type   类型 ：1. 数字 ；2.字母 ；3.数字+字母；
     * @return
     * @author 张广彬
     * @date 2013-7-10
     */
    public static String getRandomString(int length, int type) { // length表示生成字符串的长度
        String string = "";
        switch (type) {
            case 1:// 数字
                string = getRandomString(length, "0123456789");
                break;
            case 2:// 字母
                string = getRandomString(length, "abcdefghijklmnopqrstuvwxyz");
                break;
            case 3:// 数字+字母
                string = getRandomString(length, "abcdefghijklmnopqrstuvwxyz0123456789");
                break;
            default:
                break;
        }
        return string;
    }

    /**
     * 获取随机字符串
     *
     * @param length
     * @return
     * @author 张广彬
     * @date 2013-7-10
     */
    public static String getRandomString(int length, String baseString) { // length表示生成字符串的长度
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(baseString.length());
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 字符串首字母小写
     *
     * @param str
     * @return
     */
    public static String toLowerCaseFirstOne(String str) {
        if (str == null || "".equals(str))
            return str;
        if (Character.isLowerCase(str.charAt(0)))
            return str;
        else
            return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * 字符串首字母大写
     *
     * @param str
     * @return
     */
    public static String toUpperCaseFirstOne(String str) {
        if (str == null || "".equals(str))
            return str;
        if (Character.isUpperCase(str.charAt(0)))
            return str;
        else
            return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * @Description:
     * @Param: [str, charLength]
     * @return: java.lang.String
     * @Author: Steven.Wang
     * @Date: 2018/8/29 08:59
     */
    public static String getSubString(String str, int charLength) {
        int count = 0;
        int offset = 0;
        char[] c = str.toCharArray();
        int size = getChineseLength(str);
        if (size >= charLength) {
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 256) {
                    offset = 2;
                    count += 2;
                } else {
                    offset = 1;
                    count++;
                }
                if (count == charLength) {
                    return str.substring(0, i + 1);
                }
                if ((count == charLength + 1 && offset == 2)) {
                    return str.substring(0, i);
                }
            }
        } else {
            return str;
        }
        return "";
    }

    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     *
     * @param validateStr 指定的字符串
     * @return 字符串的长度
     */
    public static int getChineseLength(String validateStr) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < validateStr.length(); i++) {
            /* 获取一个字符 */
            String temp = validateStr.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    public static int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }


    private static String getKeywordByContent(String content) {
        StringBuffer sbAllKwyword = new StringBuffer();
        content = content.replaceAll(" ", "");//去掉所有空格
        if (content.length() > 10) {
            String regex = "(#[\\u4E00-\\u9FA5A-Za-z0-9]{2,20})$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(content);
            int i = 0;
            while (m.find() && i < 10) {
                sbAllKwyword.append(m.group());
                sbAllKwyword.append("^");
                i++;
            }
            System.out.printf("sbAllKwyword={}", sbAllKwyword.toString());
            if (sbAllKwyword.length() > 1) {
                sbAllKwyword.deleteCharAt(sbAllKwyword.length() - 1);
            }
        } else {
            sbAllKwyword.append(content);
        }
        return sbAllKwyword.toString();
    }

    /**
     * @Description 裁切图说中的 "#" 话题 或者 "@" 内容
     *
     * @author Yangchunlong
     * @date 2018/11/14 9:37
     * @param line 图说内容
     * @return java.util.List<java.lang.String>
     */
    public static List<Map<String,Object>> subStringTopic(String line){
        line = line + " ";
        List<Map<String,Object>> result = Lists.newArrayList();
//        String pattern = "#[\\w|\u4e00-\u9fa5]+[\\s|`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]{0}";
//        String pattern1 = "@[\\w|\u4e00-\u9fa5]+[\\s|`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]{0}";
        String pattern = "#[^@# ]{1,100}";
        String pattern1 = "@[^@# ]{1,100}";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        Pattern r1 = Pattern.compile(pattern1);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        Matcher m1 = r1.matcher(line);
        while (m.find()) {
            String replaceStr = EmojiUtil.replaceEmoji(m.group());
            if (replaceStr.length()>200){
                continue;
            }
            Map<String,Object> map = Maps.newHashMap();
            map.put("userName",replaceStr);
            map.put("start",m.start());
            map.put("end",m.end());
            map.put("type",1);
            result.add(map);
        }
        while (m1.find()) {
            String replaceStr = EmojiUtil.replaceEmoji(m1.group());
            if (replaceStr.length()>200){
                continue;
            }
            Map<String,Object> map = Maps.newHashMap();
            map.put("userName",replaceStr);
            map.put("start",m1.start());
            map.put("end",m1.end());
            map.put("type",0);
            result.add(map);
        }
        return result;
    }

    /**
     * @author     : YangChunLong
     * @date       : Created in 2019/4/9 16:40
     * @description: 字符串中去除 "回车" "空格" "水平制表符" "换行"
     * @modified By:
      * @Param: str
     * @return     : java.lang.String
     */
    public static String strFilter(String str){
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String buildRandomStr(int n){
        String val = "";
        Random random = new Random();
        for ( int i = 0; i < n; i++ )
        {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) ( nextInt + random.nextInt( 26 ) );
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
                val += String.valueOf( random.nextInt( 10 ) );
            }
        }
        return val;
    }

    /**
     * 将一个int数字转换为二进制的字符串形式。
     * @param num 需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    public static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
        return  bs.substring(1);
    }

    public static void main(String[] args) {
        String strContent="请到以下地址查询：查询地址：充值地址：https://pay.sdo.com/Index.aspx?type=card尊敬的用户： 您好，该卡帐号和密码是正确的，请到以下https://pay.sdo.com/Index.aspx?type=card 地址查询：查询地址：充值地址：https://pay.sdo.com/Index.aspx?type=card "
//                +" 192.168.1.888"
//                +" 192.168.10.9"
//                +" www.zs.com "
//                +" ftp://192.168.10.8"
//                +" www.aa.bb"
//                +" rtsp://192.168.10.8"
//                +" http://192.168.1.99"
//                +" http://pay.sdo.com/Index.aspx?type=card"
//                +" www.ff.com"
//                +" aa.bb.com"
                +" hkugc://user?uid=1446696"
                +" aa.bb.cc"
                +" www.aa.bb"
                +" aa.bb.com"
                +" aa.bb.cn";
//        System.out.println(strContent);
//        String result = matchUrl(strContent);
//        System.out.println(result);
    }

}

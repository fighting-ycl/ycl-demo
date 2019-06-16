package com.personal.common.requestProtocol.sapi;

import com.google.common.collect.Maps;
import com.personal.common.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Ma Zongwang
 * @ClassName:
 * @Description: TODO (这里用一句话描述这个类的作用)
 * @date 2017/11/7 下午5:01
 */
public class SapiBaseController {


	 public static String getIpAddress(HttpServletRequest request) {
	        String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    }
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static Map<String, String> NUM_COMPANY = Maps.newHashMap();

    private static Map<String,String> keyAndSecret = Maps.newHashMap();
    
    

    static {
    		NUM_COMPANY.put("202", "10002");
    		NUM_COMPANY.put("204", "10004");
    		NUM_COMPANY.put("22", "10009");
    		NUM_COMPANY.put("207", "10010");
    		NUM_COMPANY.put("203", "10011");
    		NUM_COMPANY.put("208", "10012");
    		NUM_COMPANY.put("205", "10013");
    		NUM_COMPANY.put("206", "10014");
    		NUM_COMPANY.put("209", "10015");
    		NUM_COMPANY.put("210", "10016");
    		NUM_COMPANY.put("211", "10017");
    		NUM_COMPANY.put("212", "10018");
    		NUM_COMPANY.put("213", "10019");
    		NUM_COMPANY.put("214", "10020");
    		NUM_COMPANY.put("215", "10021");
    		NUM_COMPANY.put("216", "10022");
    		NUM_COMPANY.put("217", "10023");
    		NUM_COMPANY.put("218", "10024");
    		NUM_COMPANY.put("219", "10025");
    		NUM_COMPANY.put("220", "10026");
    		NUM_COMPANY.put("221", "10027");
    		NUM_COMPANY.put("222", "10107");
    		NUM_COMPANY.put("223", "10029");
    		NUM_COMPANY.put("224", "10030");
    		NUM_COMPANY.put("225", "10031");
    		NUM_COMPANY.put("226", "10032");
    		NUM_COMPANY.put("227", "10033");
    		NUM_COMPANY.put("228", "10034");
    		NUM_COMPANY.put("229", "10035");
    		NUM_COMPANY.put("230", "10036");
    		NUM_COMPANY.put("231", "10037");
    		NUM_COMPANY.put("232", "10038");
    		NUM_COMPANY.put("233", "10039");
    		NUM_COMPANY.put("234", "10040");
    		NUM_COMPANY.put("235", "10041");
    		NUM_COMPANY.put("236", "10042");
    		NUM_COMPANY.put("237", "10043");
    		NUM_COMPANY.put("238", "10044");
    		NUM_COMPANY.put("239", "10045");
    		NUM_COMPANY.put("240", "10046");
    		NUM_COMPANY.put("241", "10047");
    		NUM_COMPANY.put("242", "10049");
    		NUM_COMPANY.put("243", "10050");
    		NUM_COMPANY.put("10000", "10051");
    		NUM_COMPANY.put("244", "10052");
    		NUM_COMPANY.put("245", "10053");
    		NUM_COMPANY.put("246", "10054");
    		NUM_COMPANY.put("247", "10055");
    		NUM_COMPANY.put("248", "10056");
    		NUM_COMPANY.put("249", "10057");
    		NUM_COMPANY.put("250", "10058");
    		NUM_COMPANY.put("251", "10059");
    		NUM_COMPANY.put("252", "10060");
    		NUM_COMPANY.put("253", "10061");
    		NUM_COMPANY.put("254", "10062");
    		NUM_COMPANY.put("201", "10063");
    		NUM_COMPANY.put("255", "10064");
    		NUM_COMPANY.put("256", "10065");
    	}

    static {
        keyAndSecret.put("202","b58fpJs6FGGyrAzSk7");
        keyAndSecret.put("204","HKcXZ3idxfm7cXGsrh");
        keyAndSecret.put("22","6RZ2QZijja5jC8Gijx");
        keyAndSecret.put("207","n343nic8jrFrPeezpt");
        keyAndSecret.put("203","JfriapDtTS73ZixeeE");
        keyAndSecret.put("208","cHQY8rYSkyNEzFdRAw");
        keyAndSecret.put("205","wiedcNCSXw7SiZHGDy");
        keyAndSecret.put("206","KEZaxF3taDW44WHaB4");
        keyAndSecret.put("209","SXPjMmBet3bTPYGEkH");
        keyAndSecret.put("210","r7a2p64CxaGzZt2psi");
        keyAndSecret.put("211","bbHi5XSWjD2MkH7xbr");
        keyAndSecret.put("212","Eh3i336WXEQwaH3hXZ");
        keyAndSecret.put("213","xjhFQsm57CAhfNwpiK");
        keyAndSecret.put("214","eNHzWtYEY4TdnDWXZm");
        keyAndSecret.put("215","f8wymDdGGJjPAskwTF");
        keyAndSecret.put("216","yGwFYQsQsRAjGhtyan");
        keyAndSecret.put("217","J8h2edhG88YXdaJkEY");
        keyAndSecret.put("218","YhZRePFphBRJiixNJr");
        keyAndSecret.put("219","yAkzc78bFKBJhSTCQ6");
        keyAndSecret.put("220","yQhG7zcpWRNPECkCC4");
        keyAndSecret.put("221","SfZWjYWydm5Fye8MaG");
        keyAndSecret.put("222","wmGZcTAiGJXjJQBPsN");
        keyAndSecret.put("223","PfFHDMBdPi7TFdRRYX");
        keyAndSecret.put("224","fZSFSFwdH3ycacxxWN");
        keyAndSecret.put("225","4HefajfKccGitQ6Kr8");
        keyAndSecret.put("226","anRZWd3pnnk8DTriMC");
        keyAndSecret.put("227","AASyieXbQrNTr5tGtm");
        keyAndSecret.put("228","kGe263jFT3HDxbwhnh");
        keyAndSecret.put("229","MWw5syYymT4C7D7mCN");
        keyAndSecret.put("230","248PWWtMcJa6FKN4eZ");
        keyAndSecret.put("231","26zCZKzzjK3BpfZDr5");
        keyAndSecret.put("232","wKd8pZY5J4i5yjZMna");
        keyAndSecret.put("233","amHSjRYf4b6cJKQ4k8");
        keyAndSecret.put("234","S57J5Tih8TGarkynRe");
        keyAndSecret.put("235","8GKMY3ThTFSCYBPr3a");
        keyAndSecret.put("236","MRctrS6xpFmrRzjPri");
        keyAndSecret.put("237","5NwSQzNybhB6zkSjEz");
        keyAndSecret.put("238","2QSDKhzZmzEYyBKdP4");
        keyAndSecret.put("239","eTfdktWR4ncFwACQSz");
        keyAndSecret.put("240","j3mSCCeSmePWp2WJT2");
        keyAndSecret.put("241","ZeBd7JhBQYbdKA8GF5");
        keyAndSecret.put("242","zNMYxeYNKX678Hx6tG");
        keyAndSecret.put("243","MGzdSFwsi63NzWr3ET");
        keyAndSecret.put("10000","GVed-Y~of0pLBjlDzN66V5Q)iipr!x5@");
        keyAndSecret.put("244","pmFk4SdiyFsiFs5PNG");
        keyAndSecret.put("245","CQKDtXR8JhEnGxnPwC");
        keyAndSecret.put("246","5MtFsaYT2AjpHB4ZCs");
        keyAndSecret.put("247","SebH6R2iMn62axf4wk");
        keyAndSecret.put("248","ynX6Ct2exWBFdTptf8");
        keyAndSecret.put("249","k6iezQfyXf3DcEzjyQ");
        keyAndSecret.put("250","Zfe5jyDh2pbK8r6JsQ");
        keyAndSecret.put("251","yc6CG2tHK8BztFnYh4");
        keyAndSecret.put("252","e3XEbZpQtAxhA8cQyT");
        keyAndSecret.put("253","NfYQKxtmkpEmx4GFeK");
        keyAndSecret.put("254","sybSafstCfiWZpN4kd");
        keyAndSecret.put("201","CTMcjMFAxJwkf8MXb6");
        keyAndSecret.put("255","EGcefETbrnhfzfmccE");
        keyAndSecret.put("256","BCKPHKTBcBR5GyYkpD");
    }
    /**
     * uri上获取参数
     * @param pRequest
     * @param httpServletRequest
     * @return
     */
    ProtocolRequestSapi setUriParams(ProtocolRequestSapi pRequest, HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        if (!StringUtils.isBlank(uri)) {
            String[] us = uri.split("/");

            if (null!=us && us.length>0) {
                for (String u : us) {
                    if ("hk-protocol".equals(u)){
                        continue;
                    }
                    if (StringUtils.isNotEmpty(u)) {
                        if (StringUtils.isEmpty(pRequest.getA())){
                            pRequest.setA(u);
                        }else{
                            if (StringUtils.isEmpty(pRequest.getC())){
                                pRequest.setC(u);
                            }
                        }
                    }
                }
            }
        }
        return pRequest;
    }
    /**
     * 检验请求参数
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public ProtocolResponseSapi checkRequest(ProtocolRequestSapi pRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        logger.debug("The request content :" + httpServletRequest.toString());
        ProtocolResponseSapi pResponse = new ProtocolResponseSapi();
        pResponse.setData(null);
        if (null == pResponse){
            return null;
        }
        this.setUriParams(pRequest,httpServletRequest);
        // 判断业务方法是否合法
        String c = pRequest.getC();
        String a = pRequest.getA();
        String k = pRequest.getK();

        if (c == null || a == null || k == null) {
            logger.debug(" 请求协议号为非法......");
            pResponse.setErr_code(ResultCode.ERROR.getIndex());
            pResponse.setErr_msg(ResultCode.ERROR.getName());
            pResponse.setData("请求协议号为非法......");
            return pResponse;
        }

        // 获取秘钥
        String manufacturerSecret = keyAndSecret.get(k);

        if(null == manufacturerSecret){
            logger.debug(" 厂商秘钥不存在......");
            pResponse.setErr_code(ResultCode.ERROR.getIndex());
            pResponse.setErr_msg(ResultCode.ERROR.getName());
            pResponse.setData("厂商秘钥不存在......");
            return pResponse;
        }

        String fromSign = pRequest.getSign();
        logger.debug("from : " + fromSign);

        String toSign = generator(pRequest,manufacturerSecret);
        logger.debug("to : " + toSign);
        if (fromSign == null || !fromSign.equalsIgnoreCase(toSign)) {
            logger.debug(" 请求验证签名失败......");
            pResponse.setErr_code(ResultCode.ERROR.getIndex());
            pResponse.setErr_msg(ResultCode.ERROR.getName());
            pResponse.setData("");
            return pResponse;
        }

        pResponse.setErr_code(ResultCode.PASS.getIndex());
        pResponse.setErr_msg(ResultCode.PASS.getName());
        return pResponse;
    }

    public static String generator(ProtocolRequestSapi request,String key){
        StringBuffer buffer = new StringBuffer();
        buffer.append(key);
        buffer.append("a");
        buffer.append(request.getA());
        buffer.append("c");
        buffer.append(request.getC());
        if (StringUtils.isNotEmpty(request.getData())){
            buffer.append("data");
            buffer.append(request.getData());
        }
        buffer.append("k");
        buffer.append(request.getK());
        buffer.append("t");
        buffer.append(request.getT().replaceAll("=",""));
        buffer.append("v");
        buffer.append(request.getV());
        buffer.append(key);

        String sign = MD5Util.MD5Encode(buffer.toString());
        return sign;
    }
}

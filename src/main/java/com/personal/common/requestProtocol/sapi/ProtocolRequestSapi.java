package com.personal.common.requestProtocol.sapi;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ProtocolRequestSapi implements Serializable{
	
	private static final long serialVersionUID = -2414741439555764701L;
	/** 合作伙伴appkey */
	private String k;
	/** 当前Unix时间戳(10位精确到秒)*/
	private String t;
	/** 接口版本号 */
	private String v;
	/** 请求类名  */
	private String c;
	/** 请求方法名  */
	private String a;
	/** 方法所需参数,JSON String (注:JSON String可能换行等字符,请URLEncode处理) */
	private String data;
	/** 签名 */
	private String sign;
	/** aws */
	private String aws;

	private String did;
	
	@Override
	public String toString() {
		return "ProtocolRequestSapi [k=" + k + ", t=" + t + ", v=" + v + ", c="
				+ c + ", a=" + a + ", data=" + data + ", sign=" + sign + "]";
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getData() {
		String result = "";

		try {
			if (StringUtils.isNotEmpty(data)){
				result = URLDecoder.decode(data,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAws() {
		return aws;
	}

	public void setAws(String aws) {
		this.aws = aws;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}
}
	

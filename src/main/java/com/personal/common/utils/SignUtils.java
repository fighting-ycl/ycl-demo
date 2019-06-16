package com.personal.common.utils;


import com.personal.common.requestProtocol.encapsulationData.ProtocolTreeRequest;
import com.personal.common.requestProtocol.encapsulationData.TransferProtocolRequestHeader;
import com.personal.common.requestProtocol.encapsulationData.TransferProtocolTreeRequest;
import com.personal.common.requestProtocol.encapsulationData.ProtocolRequestHeader;

import java.util.HashMap;
import java.util.Map;

/**
* @ClassName: SignUtils
* @Description: 通讯签名
* @author YuHongzhen
* @date 2016年2月27日 下午2:49:42
*
*/
public class SignUtils {

	/**
	 * @Title: sign
	 * @Description: 生成签名
	 * @author YuHongzhen
	 * @param request
	 * @return
	 * @throws
	 */
	public static String generator(ProtocolTreeRequest request, String key) {
		ProtocolRequestHeader header = request.getHeader();
		Map<String, Object> bodyMap = request.getBody();
		//body Json串
		if(null==bodyMap) {
			bodyMap =new HashMap<String, Object>();
		}
		String body = MapperUtils.writeValueAsString(bodyMap);

		//messageID
		String messageID = header.getMessageID();
		//时间戳
		String timeStamp = header.getTimeStamp();
		StringBuffer buffer = new StringBuffer();
		buffer.append(messageID).append(timeStamp).append(key).append(body);
		String sign = MD5Util.MD5Encode(buffer.toString());
		return sign;
	}

	public static String transfergenerator(TransferProtocolTreeRequest request, String key) {
		TransferProtocolRequestHeader header = request.getHeader();
		Map<String, Object> bodyMap = request.getBody();
		//body Json串
		if(null==bodyMap) {
			bodyMap =new HashMap<String, Object>();
		}
		String body = MapperUtils.writeValueAsString(bodyMap);
		
		//messageID
		String messageID = header.getMessageID();
		//时间戳
		String timeStamp = header.getTimeStamp();
		StringBuffer buffer = new StringBuffer();
		buffer.append(messageID).append(timeStamp).append(header.getTransactionType()).append(key).append(body);
		String sign = MD5Util.MD5Encode(buffer.toString());
		return sign;
	}
	public static void main(String args[]){
//		try {
//			String b = "20160325142927000000000002201603251429273002miyao{\"pSize\":\"8\",\"pNum\":\"1\",\"words\":\"慕\"}";
//			String content = new String(b.getBytes(), "UTF-8");
//			String sign = MD5Util.MD5Encode(content);
//			System.out.println(sign);
//			String _sign = MD5Util.MD5Encode("20160318174930KgfDzDuuoe201603181749306006miyao{\"sceneName\":\"test11\",\"userId\":\"4B5891F7E9DD11E59F9274D435FB505E\"}");
//			System.out.println(_sign);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}

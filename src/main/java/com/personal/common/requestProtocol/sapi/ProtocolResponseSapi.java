package com.personal.common.requestProtocol.sapi;

import java.io.Serializable;

public class ProtocolResponseSapi implements Serializable {
	private static final long serialVersionUID = -154573429840767252L;
	
	/** 返回结果编号。0-成功 */
	private int err_code;
	/** 返回结果描述 */
	private String err_msg;

	/** 返回结果描述 */
	private String message;
	/** ip地址 */
	private String ip;
	/** 返回响应时间 */
	private long time;

	private int code;

	private Object data;

	public int getErr_code() {
		return err_code;
	}

	public void setErr_code(int err_code) {
		this.err_code = err_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		if (data==null){
			return "";
		}
		return data;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ProtocolResponseSapi{" +
				"err_code=" + err_code +
				", err_msg='" + err_msg + '\'' +
				", ip='" + ip + '\'' +
				", time=" + time +
				", data=" + data +
				'}';
	}

}

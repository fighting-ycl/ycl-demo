package com.personal.common.requestProtocol.encapsulationData;

public class ProtocolResponseHeader {
	private String messageID; // 消息编号

	/** 返回结果编号。0-成功 */
	private int resCode = ResultCode.PASS.getIndex();

	/** 返回结果描述 */
	private String resMsg = ResultCode.PASS.getName();	
	private String timeStamp; // 时间戳
	private String transactionType = ""; // 交易类型

	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}

package com.personal.common.requestProtocol.encapsulationData;


public class TransferProtocolRequestHeader extends ProtocolRequestHeader {
	/**
	 * @Fields serialVersionUID :  
	 */
	private static final long serialVersionUID = 6531232234736959716L;
	private Integer transactionType; // 交易类型
	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "TransferProtocolRequestHeader [transactionType=" + transactionType + "]";
	}

	 
	
}

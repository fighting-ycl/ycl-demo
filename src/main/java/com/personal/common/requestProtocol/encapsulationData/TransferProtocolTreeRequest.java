package com.personal.common.requestProtocol.encapsulationData;

import java.util.TreeMap;

public class TransferProtocolTreeRequest {

	private TransferProtocolRequestHeader header;

    private TreeMap<String, Object> body;

    public TransferProtocolRequestHeader getHeader() {
		return header;
	}

	public void setHeader(TransferProtocolRequestHeader header) {
		this.header = header;
	}

    public TreeMap<String, Object> getBody() {
        return body;
    }

    public void setBody(TreeMap<String, Object> body) {
        this.body = body;
    }

    

	@Override
	public String toString() {
		return "ProtocolTreeRequest [header=" + header + ", body=" + body + "]";
	}
}

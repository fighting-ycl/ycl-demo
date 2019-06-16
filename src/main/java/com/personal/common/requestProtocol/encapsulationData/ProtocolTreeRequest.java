package com.personal.common.requestProtocol.encapsulationData;

import java.util.TreeMap;

public class ProtocolTreeRequest {

    private ProtocolRequestHeader header;

    private TreeMap<String, Object> body;

    public TreeMap<String, Object> getBody() {
        return body;
    }

    public void setBody(TreeMap<String, Object> body) {
        this.body = body;
    }

    public ProtocolRequestHeader getHeader() {
        return header;
    }

    public void setHeader(ProtocolRequestHeader header) {
        this.header = header;
    }

	@Override
	public String toString() {
		return "ProtocolTreeRequest [header=" + header + ", body=" + body + "]";
	}


}

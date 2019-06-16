package com.personal.common.requestProtocol.encapsulationData;

import java.io.Serializable;
import java.util.Map;

public class ProtocolResponse  implements Serializable {
	private static final long serialVersionUID = 1L;
	private ProtocolResponseHeader header = new ProtocolResponseHeader();
	private Map<String,Object> body;

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

	public ProtocolResponseHeader getHeader() {
		return header;
	}
	
	public void setHeader(ProtocolResponseHeader header) {
		this.header = header;
	}
}

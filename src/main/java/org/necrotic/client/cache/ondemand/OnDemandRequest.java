package org.necrotic.client.cache.ondemand;

import org.necrotic.client.cache.node.NodeSub;

public final class OnDemandRequest extends NodeSub {

	private int dataType;
	private byte buffer[];
	private int id;
	boolean incomplete;
	int loopCycle;

	public OnDemandRequest() {
		incomplete = true;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte buffer[]) {
		this.buffer = buffer;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
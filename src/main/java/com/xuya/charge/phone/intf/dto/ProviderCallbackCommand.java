package com.xuya.charge.phone.intf.dto;

public class ProviderCallbackCommand {

	private String channelId;
	private String headString;
	private String bodyString;

	public ProviderCallbackCommand(String channelId, String headString, String bodyString) {
		this.channelId = channelId;
		this.headString = headString;
		this.bodyString = bodyString;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getHeadString() {
		return headString;
	}

	public void setHeadString(String headString) {
		this.headString = headString;
	}

	public String getBodyString() {
		return bodyString;
	}

	public void setBodyString(String bodyString) {
		this.bodyString = bodyString;
	}

}

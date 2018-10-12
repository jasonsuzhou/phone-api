package com.xuya.charge.phone.intf.dto;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private Integer status;
	private String code;
	private String desc;
	private Map<String, Object> payload = new HashMap<>();

	public static class Builder {
		private Result result = new Result();
		
		public Builder status(int status) {
			result.status = status;
			return this;
		}
		
		public Builder code(String code) {
			result.code = code;
			return this;
		}
		
		public Builder desc(String desc) {
			result.desc = desc;
			return this;
		}
		
		public Builder addPayloadData(String key, Object value) {
			result.getPayload().put(key, value);
			return this;
		}
		
		public Result build() {
			return result;
		}
		
		public Result buildError(String code, String desc) {
			Result result = new Result();
			result.setStatus(1);
			result.setCode(code);
			result.setDesc(desc);
			return result;
		}
		
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
	
}

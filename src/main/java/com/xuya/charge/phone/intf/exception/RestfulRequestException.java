package com.xuya.charge.phone.intf.exception;

public class RestfulRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2344304249249930229L;
	
	private String code;

	public RestfulRequestException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	
}

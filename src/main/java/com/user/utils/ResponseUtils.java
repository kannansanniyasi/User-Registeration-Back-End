package com.user.utils;

import java.io.Serializable;

public class ResponseUtils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean flg=false;
	private String message;
	public boolean isFlg() {
		return flg;
	}
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

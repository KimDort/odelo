package com.ican.com.bean;

import java.util.Map;

public class BaseBean {
	private String message;
	private Map<String, Object> map;
	private char isProcess;
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public char getIsProcess() {
		return isProcess;
	}
	public void setIsProcess(char isProcess) {
		this.isProcess = isProcess;
	}
	
}

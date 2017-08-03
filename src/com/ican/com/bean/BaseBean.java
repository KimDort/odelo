package com.ican.com.bean;

import java.util.List;

public class BaseBean{
	
	private List<Object> direction;
	private List<OthelloBean> othelloList;
	private char turn;
	
	public BaseBean(){}
	
	public char getTurn() {
		return turn;
	}
	public void setTurn(char turn) {
		this.turn = turn;
	}

	public List<Object> getDirection() {
		return direction;
	}
	public void setDirection(List<Object> direction) {
		this.direction = direction;
	}
	public List<OthelloBean> getOthelloList() {
		return othelloList;
	}
	public void setOthelloList(List<OthelloBean> othelloList) {
		this.othelloList = othelloList;
	}
	
}

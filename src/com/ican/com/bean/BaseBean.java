package com.ican.com.bean;

import java.util.List;
import java.util.Map;

public class BaseBean {
	private int width=10;
	private int height=10;
	private char trun='B';
	private Map<String, DirectionBean> directionMap;
	private List<Map<String, DirectionBean>> directionList;
	private List<StoneBean> stoneList;
	private char[][] field;
	
	public List<StoneBean> getStoneList() {
		return stoneList;
	}
	public void setStoneList(List<StoneBean> stoneList) {
		this.stoneList = stoneList;
	}
	public Map<String, DirectionBean> getDirectionMap() {
		return directionMap;
	}
	public void setDirectionMap(Map<String, DirectionBean> directionMap) {
		this.directionMap = directionMap;
	}
	public List<Map<String, DirectionBean>> getDirectionList() {
		return directionList;
	}
	public void setDirectionList(List<Map<String, DirectionBean>> directionList) {
		this.directionList = directionList;
	}
	public char[][] getField() {
		return field;
	}
	public void setField(char[][] field) {
		this.field = field;
	}
	public char getTrun() {
		return trun;
	}
	public void setTrun(char trun) {
		this.trun = trun;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

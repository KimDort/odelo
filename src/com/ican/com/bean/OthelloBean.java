package com.ican.com.bean;

import java.util.List;

public class OthelloBean extends BaseBean{
	private int positionX;
	private int positionY;
	private char stoneColor;
	private List<Object> directionList;
	public OthelloBean(int positionX, int positionY){
		this.positionX=positionX;
		this.positionY=positionY;
	}
	public OthelloBean(int positionX, int positionY, char stoneColor){
		this.positionX=positionX;
		this.positionY=positionY;
		this.stoneColor=stoneColor;
	}
	public OthelloBean(){
		
	}
	
	public List<Object> getDirectionList() {
		return directionList;
	}
	public void setDirectionList(List<Object> directionList) {
		this.directionList = directionList;
	}
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public char getStoneColor() {
		return stoneColor;
	}

	public void setStoneColor(char stoneColor) {
		this.stoneColor = stoneColor;
	}
	
}

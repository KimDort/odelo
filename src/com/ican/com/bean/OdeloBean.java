package com.ican.com.bean;

import java.util.Map;

public class OdeloBean extends BaseBean{
	private int position;
	private int positionX;
	private int positionY;
	private char stoneColor;
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
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

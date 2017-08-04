package com.ican.com.bean;

public class StoneBean extends BaseBean{
	private int positionX;
	private int positionY;
	private char stoneColor;
	private boolean isLastStone;
	
	public StoneBean(){}
	public StoneBean(int positionX, int positionY){
		this.positionX=positionX;
		this.positionY=positionY;
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
	public boolean isLastStone() {
		return isLastStone;
	}
	public void setLastStone(boolean isLastStone) {
		this.isLastStone = isLastStone;
	}
	
}

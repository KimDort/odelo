package com.ican.com.bean;

public class DirectionSouthWest extends OthelloBean{
	public DirectionSouthWest(int positionX, int positionY){
		super(positionX, positionY);
	}
	public DirectionSouthWest(){
		
	}
	private int lastStonePositionX;
	private int lastStonePositionY;
	private char lastStoneColor;
	private int countX=0;
	private int countY=0;
	
	public int getLastStonePositionX() {
		return lastStonePositionX;
	}
	public void setLastStonePositionX(int lastStonePositionX) {
		this.lastStonePositionX = lastStonePositionX;
	}
	public int getLastStonePositionY() {
		return lastStonePositionY;
	}
	public void setLastStonePositionY(int lastStonePositionY) {
		this.lastStonePositionY = lastStonePositionY;
	}
	public char getLastStoneColor() {
		return lastStoneColor;
	}
	public void setLastStoneColor(char lastStoneColor) {
		this.lastStoneColor = lastStoneColor;
	}
	public int getProcessX() {
		return super.getPositionX()-countX;
	}
	public int getProcessY() {
		return super.getPositionY()-countY;
	}
	public void setCountX(int countX) {
		this.countX = countX;
	}
	public void setCountY(int countY) {
		this.countY = countY;
	}
	
}

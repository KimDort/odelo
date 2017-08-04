package com.ican.com.bean;

public class DirectionBean extends StoneBean{
	private char mathX;
	private char mathY;
	private int countX;
	private int countY;
	private int processX;
	private int processY;
	
	public DirectionBean(char mathX, char mathY, int positionX, int positionY){
		this.processX=positionX;
		this.processY=positionY;
		this.mathX=mathX;
		this.mathY=mathY;
	}
	public void setMathX(char mathX) {
		this.mathX = mathX;
	}
	public void setMathY(char mathY) {
		this.mathY = mathY;
	}
	public int getCountX() {
		return countX;
	}
	public void setCountX(int countX) {
		this.countX = countX;
	}
	public int getCountY() {
		return countY;
	}
	public void setCountY(int countY) {
		this.countY = countY;
	}
	
	public int getProcessX() {
		return processX();
	}
	public int getProcessY() {
		return processY();
	}
	private int processX(){
		int processX=0;
		switch (this.mathX) {
		case '-':
			processX=(this.processX-this.countX)<=0?0:this.processX-this.countX;
			break;
		case '+':
			processX=(this.processX+this.countX)>=super.getWidth()?super.getWidth()-1:this.processX+this.countX;
			break;
		default:
			processX=this.processX;
			break;
		}
		return processX;
	}
	private int processY(){
		int processY=0;
		switch (this.mathY) {
		case '-':
			processY=(this.processY-this.countY)<=0?0:this.processY-this.countY;
			break;
		case '+':
			processY=(this.processY+this.countY)>=super.getHeight()?super.getHeight()-1:this.processY+this.countY;
			break;
		default:
			processY=this.processY;
			break;
		}
		return processY;
	}
}
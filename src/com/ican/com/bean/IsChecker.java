package com.ican.com.bean;

public class IsChecker {
	private int position;
	private int nextStoneX;
	private int nextStoneY;
	private int lastStoneX;
	private int lastStoneY;
	private boolean totalCheck;
	private boolean isNextStone;
	private boolean isNextStoneColor;
	private boolean isLastStone;
	private boolean isLastStoneColor;
	
	public boolean isTotalCheck() {
		return totalCheck;
	}
	public void setTotalCheck(boolean totalCheck) {
		this.totalCheck = totalCheck;
	}
	public int getLastStoneX() {
		return lastStoneX;
	}
	public void setLastStoneX(int lastStoneX) {
		this.lastStoneX = lastStoneX;
	}
	public int getLastStoneY() {
		return lastStoneY;
	}
	public void setLastStoneY(int lastStoneY) {
		this.lastStoneY = lastStoneY;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public boolean isNextStone() {
		return isNextStone;
	}
	public void setNextStone(boolean isNextStone) {
		this.isNextStone = isNextStone;
	}
	public int getNextStoneX() {
		return nextStoneX;
	}
	public void setNextStoneX(int nextStoneX) {
		this.nextStoneX = nextStoneX;
	}
	public int getNextStoneY() {
		return nextStoneY;
	}
	public void setNextStoneY(int nextStoneY) {
		this.nextStoneY = nextStoneY;
	}
	public boolean isNextStoneColor() {
		return isNextStoneColor;
	}
	public void setNextStoneColor(boolean isNextStoneColor) {
		this.isNextStoneColor = isNextStoneColor;
	}
	public boolean isLastStone() {
		return isLastStone;
	}
	public void setLastStone(boolean isLastStone) {
		this.isLastStone = isLastStone;
	}
	public boolean isLastStoneColor() {
		return isLastStoneColor;
	}
	public void setLastStoneColor(boolean isLastStoneColor) {
		this.isLastStoneColor = isLastStoneColor;
	}
}

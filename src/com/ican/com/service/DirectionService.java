package com.ican.com.service;

import java.util.HashMap;
import java.util.Map;

import com.ican.com.bean.BaseBean;
import com.ican.com.bean.DirectionBean;
import com.ican.com.bean.StoneBean;

public class DirectionService {
	public void getLastStone(StoneBean stone, BaseBean base){
		Map<String, DirectionBean> map = new HashMap<>();
		//DirectionBean nw = getNornthWestLastStone(stone, base);
		//DirectionBean n = getNornthLastStone(stone, base);
		//DirectionBean ne = getNornthEastLastStone(stone, base);
		//DirectionBean e = getEastLastStone(stone, base);
		//DirectionBean se = getSouthEastLastStone(stone, base);
		//DirectionBean s = getSouthLastStone(stone, base);
		//DirectionBean sw = getSouthWestLastStone(stone, base);
		//DirectionBean w = getWestLastStone(stone, base);
		map.put("northWest", getNornthWestLastStone(stone, base));
		map.put("north", getNornthLastStone(stone, base));
		map.put("northEast", getNornthEastLastStone(stone, base));
		map.put("east", getEastLastStone(stone, base));
		map.put("southEast", getSouthEastLastStone(stone, base));
		map.put("south", getSouthLastStone(stone, base));
		map.put("sourthWest", getSouthWestLastStone(stone, base));
		map.put("west", getWestLastStone(stone, base));
	}
	public DirectionBean getNornthWestLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('-', '-',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountX(idx+1);
			direction.setCountY(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()-1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()-1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getNornthLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('-', '-',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountY(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()-1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getNornthEastLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('+', '-',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountX(idx+1);
			direction.setCountY(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getEastLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('+', '-',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountX(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getSouthEastLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('+', '+',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountX(idx+1);
			direction.setCountY(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getSouthLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('+', '+',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountY(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getSouthWestLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('-', '+',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountY(idx+1);
			direction.setCountX(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
	public DirectionBean getWestLastStone(StoneBean stone, BaseBean base){
		DirectionBean direction = new DirectionBean('-', '+',stone.getPositionX(), stone.getPositionY());
		for(int idx=0;idx<base.getField().length;idx++){
			direction.setCountX(idx+1);
			System.out.println("들어온 x : "+stone.getPositionX()+", y : "+stone.getPositionY());
			System.out.println("계산된 x : "+direction.getProcessX()+", y : "+direction.getProcessY());
			System.out.println("다음 돌 색깔 : "+base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]);
			if(base.getField()[stone.getPositionY()-1][stone.getPositionX()+1]!=stone.getStoneColor() &&
					base.getField()[direction.getProcessY()][direction.getProcessX()]==stone.getStoneColor()){
				direction.setPositionX(direction.getProcessX());
				direction.setPositionY(direction.getProcessY());
				direction.setLastStone(true);
				return direction;
			}
		}
		return direction;
	}
}

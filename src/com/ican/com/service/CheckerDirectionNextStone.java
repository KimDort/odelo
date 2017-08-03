package com.ican.com.service;

import java.util.ArrayList;
import java.util.List;

import com.ican.com.bean.DirectionNorthWest;
import com.ican.com.bean.OthelloBean;

public class CheckerDirectionNextStone {
	public List<DirectionNorthWest> northWestNextStone(OthelloBean inputBean, List<OthelloBean> beanList){
		List<DirectionNorthWest> northWestList= new ArrayList<DirectionNorthWest>();
		DirectionNorthWest northWest = new DirectionNorthWest(inputBean.getPositionX(), inputBean.getPositionY());
		
		System.out.println("계산된 x 좌표 : "+northWest.getProcessX()+", 계산 된 y 좌표 : "+northWest.getProcessY());
		return northWestList;
	}
	
	public int processCounter(List<OthelloBean> beanList){
		int processY=0;
		for(int idx=0;idx<beanList.size();idx++){
			processY=idx;
		}
		return processY;
	}
}
package com.ican.com.service;

import java.util.List;

import com.ican.com.bean.DirectionNorthWest;
import com.ican.com.bean.OthelloBean;

public class CheckerDirectionNextStone {
	public DirectionNorthWest northWestNextStone(OthelloBean inputBean, List<OthelloBean> beanList){
		DirectionNorthWest northWest = new DirectionNorthWest(inputBean.getPositionX(), inputBean.getPositionY());
		northWest.setCountX(processCounter(beanList));
		northWest.setCountY(processCounter(beanList));
		System.out.println("계산된 x 좌표 : "+northWest.getProcessX()+", 계산 된 y 좌표 : "+northWest.getProcessY());
		return northWest;
	}
	
	public int processCounter(List<OthelloBean> beanList){
		int processY=0;
		for(int idx=0;idx<beanList.size();idx++){
			processY=idx;
		}
		return processY;
	}
}
package com.ican.com.service;

import java.util.ArrayList;
import java.util.List;

import com.ican.com.bean.BaseBean;
import com.ican.com.bean.DirectionEast;
import com.ican.com.bean.DirectionNorth;
import com.ican.com.bean.DirectionNorthEast;
import com.ican.com.bean.DirectionNorthWest;
import com.ican.com.bean.DirectionSouth;
import com.ican.com.bean.DirectionSouthEast;
import com.ican.com.bean.DirectionSouthWest;
import com.ican.com.bean.DirectionWest;

public class CheckerService {
	public BaseBean totalChecker(){
		BaseBean base = new BaseBean();
		List<Object> direct = new ArrayList<>();
		
		DirectionNorthWest northWest = new DirectionNorthWest();
		DirectionNorth north = new DirectionNorth();
		DirectionNorthEast northEast = new DirectionNorthEast();
		DirectionEast east = new DirectionEast();
		DirectionSouthEast southEast = new DirectionSouthEast();
		DirectionSouth south = new DirectionSouth();
		DirectionSouthWest soutWest = new DirectionSouthWest();
		DirectionWest west = new DirectionWest();
		
		
		return base;
	}
}

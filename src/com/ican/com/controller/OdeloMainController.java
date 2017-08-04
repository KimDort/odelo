package com.ican.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ican.com.bean.BaseBean;
import com.ican.com.bean.StoneBean;
import com.ican.com.service.DirectionService;


public class OdeloMainController extends HttpServlet{
	/**
	 * 1. 좌표 입력 받기
	 * 2. 턴에 따라 돌 색깔 결정
	 * 3. 8방향 옆에 돌 체크
	 * 4. 마지막 돌까지 체크 중 검정색 돌이 있다면 체크
	 * 5. 8방향 중 3가지 조건에 맞는 맞는 방향 1개라도 있다면 돌 놓기
	 * 6. 컴퓨터 돌 놓을 AI 만들기
	 * 7. 변수들 
	 * turn, inputX, inputY, stoneColor, isnextStoneX, isnextStoneY, nextStoneColor, 
	 * isLastStoneX, isLastStoneY, lastStoneColor, 8방향 변수? 클래스?
	 */
	private static final long serialVersionUID = -427753035517767195L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp){
		BaseBean base = new BaseBean();
		char[][] field = setField(base);
		StoneBean inputStone= new StoneBean();
		String getX="";
		String getY="";
		int positionX=0;
		int positionY=0;
		try{
			System.out.println("서블릿 진입");
			if(req.getParameter("x")!=null || req.getParameter("y")!=null){
				getX=req.getParameter("x");
				getY=req.getParameter("y");
				positionX=Integer.parseInt(getX);
				positionY=Integer.parseInt(getY);
				inputStone.setPositionX(positionX);
				inputStone.setPositionY(positionY);
				inputStone.setStoneColor('B');
				field[positionY][positionX]=inputStone.getStoneColor();
				base.setField(field);
				DirectionService service = new DirectionService();
				service.getLastStone(inputStone, base);
			}
			//최종 저장된 정보 값을 리스트에 담고 세션에 담아 포워드 시킴
			req.getSession().setAttribute("field", field);
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public char[][] setField(BaseBean base){
		char[][] field = new char[base.getWidth()][base.getHeight()];
		field[4][4]='B';
		field[4][5]='W';
		field[5][4]='W';
		field[5][5]='W';
		return field;
	}
}

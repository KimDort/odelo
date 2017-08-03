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
import com.ican.com.bean.OthelloBean;
import com.ican.com.service.CheckerDirectionNextStone;


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
	private List<OthelloBean> beanList;
	
	public OdeloMainController(){
		//현재 돌 정보를 저장할 리스트
		beanList=new ArrayList<>();
		//생성자를 통한 기본 1번 돌 생성 좌표 x, y, 돌색깔
		beanList.add(init(5, 5, 'B'));
		//생성자를 통한 기본 2번 돌 생성 좌표 x, y, 돌색깔
		beanList.add(init(5, 6, 'W'));
		//생성자를 통한 기본 3번 돌 생성 좌표 x, y, 돌색깔
		beanList.add(init(6, 5, 'W'));
		//생성자를 통한 기본 3번 돌 생성 좌표 x, y, 돌색깔
		beanList.add(init(6, 6, 'B'));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp){
		try{
			System.out.println("서블릿 진입");
			if(req.getParameter("x")!=null || req.getParameter("y")!=null){
				OthelloBean bean = new OthelloBean();
				CheckerDirectionNextStone  nextStone = new CheckerDirectionNextStone();
				
				String getX=req.getParameter("x");
				String getY=req.getParameter("y");
				int positionX=Integer.parseInt(getX);
				int positionY=Integer.parseInt(getY);
				
				
				bean.setPositionX(positionX);
				bean.setPositionY(positionY);
				bean.setStoneColor('B');
				System.out.println("입력 된 x 좌표 : "+positionX+", 입력된 y 좌표 : "+positionY);
				nextStone.northWestNextStone(bean, beanList);
				beanList.add(bean);
			}
			//최종 저장된 정보 값을 리스트에 담고 세션에 담아 포워드 시킴
			req.getSession().setAttribute("bean", beanList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OthelloBean init(int positionX, int positionY, char stoneColor){
		OthelloBean bean = new OthelloBean(positionX, positionY, stoneColor);
		
		return bean;
	}
}

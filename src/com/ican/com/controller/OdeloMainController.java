package com.ican.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ican.com.bean.BaseBean;
import com.ican.com.bean.OdeloBean;
import com.ican.com.service.OdelMakeDisplay;
import com.ican.com.service.OdeloCheckService;

public class OdeloMainController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -427753035517767195L;
	private List<OdeloBean> baseList;
	private char isMyTurn;
	private OdelMakeDisplay display=new OdelMakeDisplay();
	private OdeloCheckService checker;
	public OdeloMainController(){
		//현재 턴 정보를 저장  처음에 시작은 검정색 돌
		isMyTurn='Y';
		//현재 돌 정보를 저장할 리스트
		baseList=new ArrayList<>();
		//생성자를 통한 기본 1번 돌 생성 좌표 x, y, 돌색깔
		baseList.add(display.init(5, 5, 'B'));
		//생성자를 통한 기본 2번 돌 생성 좌표 x, y, 돌색깔
		baseList.add(display.init(5, 6, 'W'));
		//생성자를 통한 기본 3번 돌 생성 좌표 x, y, 돌색깔
		baseList.add(display.init(6, 5, 'W'));
		//생성자를 통한 기본 3번 돌 생성 좌표 x, y, 돌색깔
		baseList.add(display.init(6, 6, 'B'));
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
		OdeloBean bean = new OdeloBean();
		try {
			//내 차례이면서 들어온 값이 널이 아닐 때
			if(req.getParameter("y")!=null){
				String getX= req.getParameter("x");
				String getY= req.getParameter("y");
				int positionX=Integer.parseInt(getX);
				int positionY=Integer.parseInt(getY);
				
				if(isMyTurn=='Y'){
					System.out.println("내 차례");
					bean.setPositionX(positionX);
					bean.setPositionY(positionY);
					bean.setStoneColor('B');
					System.out.println("입력 받은 값 x : "+bean.getPositionX()+", y : "+bean.getPositionY()+", color : "+bean.getStoneColor());
					
					checker=new OdeloCheckService(bean, baseList);
					checker.checkDropEightDirection();
					if(checker.getCount() > 0){
						baseList=checker.checkDropEightDirection();
						isMyTurn='N';
					}
				}
				//내 차례까 아니라면
				if(isMyTurn=='N'){
					System.out.println("컴퓨터 차례");
					bean.setPositionX(positionX);
					bean.setPositionY(positionY);
					bean.setStoneColor('W');
					System.out.println("입력 받은 값 x : "+bean.getPositionX()+", y : "+bean.getPositionY()+", color : "+bean.getStoneColor());
					
					checker=new OdeloCheckService(bean, baseList);
					checker.checkDropEightDirection();
					if(checker.getCount() > 0){
						baseList=checker.checkDropEightDirection();
						isMyTurn='Y';
					}
				}
			}
			
			//최종 저장된 정보 값을 리스트에 담고 세션에 담아 포워드 시킴
			req.getSession().setAttribute("bean", baseList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OdeloBean createComputerStoe(){
		OdeloBean bean=new OdeloBean();
		
		
		return bean;
	}
	
}

package com.ican.com.service;

import java.util.List;

import com.ican.com.bean.FinalBean;
import com.ican.com.bean.IsChecker;
import com.ican.com.bean.OdeloBean;

public class OdeloCheckService {
	private OdeloBean odeloBean;
	private List<OdeloBean> getBean;
	private int count=0;
	//8방위 표시 : 북서쪽(NW)->북쪽(N)->북동쪽(NE)->동쪽(E)->남동쪽(SE)->남쪽(S)->남서쪽(SW)->서쪽(W) 순서
	private FinalBean finalStatic = new FinalBean();
	
	//생성자를 통하여 입력받은 x, y 와 세션 정보를 객체에 저장
	public OdeloCheckService(OdeloBean bean, List<OdeloBean> getBean){
		this.getBean=getBean;
		this.odeloBean=bean;
	}
	
	//8방향 바로 옆에 돌이 있는지 검사하는 메소드
	public List<OdeloBean> checkDropEightDirection(){
		IsChecker NW = new IsChecker();
		IsChecker N = new IsChecker();
		IsChecker NE = new IsChecker();
		IsChecker E = new IsChecker();
		IsChecker SE = new IsChecker();
		IsChecker S = new IsChecker();
		IsChecker SW = new IsChecker();
		IsChecker W = new IsChecker();
		//기본 생성자를 통한 체커기 생성
		OdeloEightDirection direction = new OdeloEightDirection(odeloBean, getBean);
		OdelMakeDisplay display = new OdelMakeDisplay(odeloBean, getBean);
		
		NW=direction.totalCheckerInfo(finalStatic.getNW());
		N=direction.totalCheckerInfo(finalStatic.getN());
		NE=direction.totalCheckerInfo(finalStatic.getNE());
		E=direction.totalCheckerInfo(finalStatic.getE());
		SE=direction.totalCheckerInfo(finalStatic.getSE());
		S=direction.totalCheckerInfo(finalStatic.getS());
		SW=direction.totalCheckerInfo(finalStatic.getSW());
		W=direction.totalCheckerInfo(finalStatic.getW());
		
		if(NW.isTotalCheck()){
			getBean=display.changeStoneColor(NW, odeloBean, getBean);
			count++;
		}
		if(N.isTotalCheck()){
			getBean=display.changeStoneColor(N, odeloBean, getBean);
			count++;
		}
		if(NE.isTotalCheck()){
			getBean=display.changeStoneColor(NE, odeloBean, getBean);
			count++;
		}
		if(E.isTotalCheck()){
			getBean=display.changeStoneColor(E, odeloBean, getBean);
			count++;
		}
		if(SE.isTotalCheck()){
			getBean=display.changeStoneColor(SE, odeloBean, getBean);
			count++;
		}
		if(S.isTotalCheck()){
			getBean=display.changeStoneColor(S, odeloBean, getBean);
			count++;
		}
		if(SW.isTotalCheck()){
			getBean=display.changeStoneColor(SW, odeloBean, getBean);
			count++;
		}
		if(W.isTotalCheck()){
			getBean=display.changeStoneColor(W, odeloBean, getBean);
			count++;
		}
		return getBean;
	}

	public int getCount() {
		return count;
	}
}

package com.ican.com.service;

import java.util.List;

import com.ican.com.bean.IsChecker;
import com.ican.com.bean.OdeloBean;
/**
 * 
 * @author IcanmanJun
 * @param odelBean : input location info
 * @param List<OdelBean> getBean : session location info 
 *
 */
public class OdeloEightDirection {
	private OdeloBean odeloBean;
	private List<OdeloBean> getBean;
	private IsChecker checker;
	
	//생성자를 통해 기본 셋팅을 함
	public OdeloEightDirection(OdeloBean odeloBean, List<OdeloBean> getBean){
		this.getBean=getBean;
		this.odeloBean=odeloBean;
	}
	
	public OdeloEightDirection(){
		
	}
	public int getProcessX(int countX, int position){
		int setProcessX[]={this.odeloBean.getPositionX()-countX,
							this.odeloBean.getPositionX(),
							this.odeloBean.getPositionX()+countX,
							this.odeloBean.getPositionX()+countX,
							this.odeloBean.getPositionX()+countX,
							this.odeloBean.getPositionX(),
							this.odeloBean.getPositionX()-countX,
							this.odeloBean.getPositionX()-countX};
		
		return setProcessX[position-1];
	}
	public int getProcessY(int countY, int position){
		int setProcessY[]={this.odeloBean.getPositionY()-countY,
							this.odeloBean.getPositionY()-countY,
							this.odeloBean.getPositionY()-countY,
							this.odeloBean.getPositionY(),
							this.odeloBean.getPositionY()+countY,
							this.odeloBean.getPositionY()+countY,
							this.odeloBean.getPositionY()+countY,
							this.odeloBean.getPositionY()};
		
		return setProcessY[position-1];
	}
	public IsChecker totalCheckerInfo(int position){
		this.checker=new IsChecker();
		//기본 체커기 셋팅
		checker= checkNextSton(position);
		checker= checkLastStone(checker, position);
		
		//바로옆 돌이 마지막 돌이고 돌 색깔이 흰색이 아닐 경우
		if(odeloBean.getStoneColor()=='B'){
			if(checker.getNextStoneX()==checker.getLastStoneX() && checker.getNextStoneY() == checker.getLastStoneY()){
				if(!checker.isLastStoneColor()){
					checker.setTotalCheck(false);
				}
			}
			if(checker.isNextStone() && checker.isLastStone() && checker.isNextStoneColor() && checker.isLastStoneColor()){
				checker.setTotalCheck(true);
			}
		}
		if(odeloBean.getStoneColor()=='W'){
			if(checker.getNextStoneX()==checker.getLastStoneX() && checker.getNextStoneY() == checker.getLastStoneY()){
				if(checker.isLastStoneColor()){
					checker.setTotalCheck(false);
				}
			}
			if(checker.isNextStone() && checker.isLastStone() && !checker.isNextStoneColor() && !checker.isLastStoneColor()){
				checker.setTotalCheck(true);
			}
		}
		return checker;
	}
	
	//입력된 방향에 돌이 있는지 체크하는 함수
	private IsChecker checkNextSton(int position){
		IsChecker checker=new IsChecker();
		//리턴 시킬 기본 정보를 셋팅 (기본은 돌이 없다고 판단하고 셋팅)
		checker.setPosition(position);
		checker=checkLastStone(checker, position);
		//입력된 위치방향의 계산 좌표를 변수에 대입
		int processX=getProcessX(1, position);
		int processY=getProcessY(1, position);
		//계산된 변수 좌표를 가지고 현재 세션에 담겨 있는 위치 정보와 비교하는 루프(입력된 방향에 돌이 존재한다면 true를 셋팅함)
		for(int idx=0;idx<getBean.size();idx++){
			if(processX==getBean.get(idx).getPositionX() && processY==getBean.get(idx).getPositionY()){
				checker.setNextStoneX(getBean.get(idx).getPositionX());
				checker.setNextStoneY(getBean.get(idx).getPositionY());
				checker.setPosition(position);
				
				checker.setNextStone(true);
				checker.setNextStoneColor(getNextStoneColor(idx));
				return checker;
			}
		}
		return checker;
	}
	
	//마지막돌과 마지막 돌이 검정인 것을 구함
	private IsChecker checkLastStone(IsChecker checker, int position){
		//기본은 마지막 돌이 없다고 판단하여 저장
		checker.setLastStone(false);
		
		for(int idx=0; idx<getBean.size();idx++){
			//입력된 위치방향의 계산 좌표를 변수에 대입
			int processX=getProcessX(idx+1, position);
			int processY=getProcessY(idx+1, position);

			//입력된 방향에서 입력된 좌표의 돌이 아닌 돌의 위치를 찾음
			for(int jdx=0;jdx<getBean.size();jdx++){
				if((processX==getBean.get(jdx).getPositionX() && 
						processY==getBean.get(jdx).getPositionY())){
					checker.setLastStoneX(getBean.get(jdx).getPositionX());
					checker.setLastStoneY(getBean.get(jdx).getPositionY());
					checker.setLastStoneColor(getLastStoneColor(jdx));
					checker.setLastStone(true);
				}
			}
		}
		return checker;
	}
	
	//입력된 방향의 돌이 흰색인지 확인
	private boolean getNextStoneColor(int idx){
		if(getBean.get(idx).getStoneColor()=='W'){
			return true;
		}
		return false;
	}
	//입력된 방향의 돌이 흰색인지 확인
	private boolean getLastStoneColor(int idx){
		if(getBean.get(idx).getStoneColor()=='B'){
			return true;
		}
		return false;
	}
}

package com.ican.com.service;

import java.util.List;

import com.ican.com.bean.FinalBean;
import com.ican.com.bean.IsChecker;
import com.ican.com.bean.OdeloBean;

public class OdelMakeDisplay extends OdeloEightDirection{
	//8방위 표시 : 북서쪽(NW)->북쪽(N)->북동쪽(NE)->동쪽(E)->남동쪽(SE)->남쪽(S)->남서쪽(SW)->서쪽(W) 순서
	private FinalBean finalStatic = new FinalBean();
	
	public OdeloBean init(int x, int y, char stoneColor){
		OdeloBean bean = new OdeloBean();
		bean.setPositionX(x);
		bean.setPositionY(y);
		bean.setStoneColor(stoneColor);
		return bean;
	}
	public OdelMakeDisplay(OdeloBean odeloBean, List<OdeloBean> getBean){
		super(odeloBean, getBean);
	}
	public OdelMakeDisplay(){
		
	}
	public List<OdeloBean> changeStoneColor(IsChecker direction, OdeloBean odeloBean, List<OdeloBean> getBean){
		getBean.add(init(odeloBean.getPositionX(), odeloBean.getPositionY(), odeloBean.getStoneColor()));
		
		for(int idx=0;idx<getBean.size();idx++){
			int positionX=super.getProcessX(idx+1, direction.getPosition());
			int positionY=super.getProcessY(idx+1, direction.getPosition());
			
			for(int jdx=0;jdx<getBean.size();jdx++){
				//북서쪽
				if(direction.getPosition()==finalStatic.getNW()){
					if((odeloBean.getPositionX()>positionX && direction.getLastStoneX() < positionX)
							&& (odeloBean.getPositionY()>positionY && direction.getLastStoneY() <positionY)){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//북쪽
				if(direction.getPosition()==finalStatic.getN()){
					if((odeloBean.getPositionX()==positionX)
							&& (odeloBean.getPositionY() > positionY && direction.getLastStoneY() < positionY)){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//북동쪽
				if(direction.getPosition()==finalStatic.getNE()){
					if((odeloBean.getPositionX() < positionX && direction.getLastStoneX() > positionX)
							&& (odeloBean.getPositionY() > positionY && direction.getLastStoneY() < positionY)){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//동쪽
				if(direction.getPosition()==finalStatic.getE()){
					if((odeloBean.getPositionX() < positionX && direction.getLastStoneX() > positionX)
							&& (odeloBean.getPositionY()==direction.getLastStoneY())){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//남동쪽
				if(direction.getPosition()==finalStatic.getSE()){
					if((odeloBean.getPositionX() < positionX && direction.getLastStoneX() > positionX)
							&& (odeloBean.getPositionY()< positionY && direction.getLastStoneY() > positionY)){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//남쪽
				if(direction.getPosition()==finalStatic.getS()){
					if((odeloBean.getPositionX() == direction.getLastStoneX())
							&& (odeloBean.getPositionY()< positionY && direction.getLastStoneY() > positionY)){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//남서쪽
				if(direction.getPosition()==finalStatic.getSW()){
					if((odeloBean.getPositionX() > positionX && direction.getLastStoneX() < positionX)
							&& (odeloBean.getPositionY()< positionY && direction.getLastStoneY() > positionY)){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
				//서쪽
				if(direction.getPosition()==finalStatic.getW()){
					if(((odeloBean.getPositionX() > positionX) && (direction.getLastStoneX() < positionX))
							&& odeloBean.getPositionY()==direction.getLastStoneY()){
						if(positionX==getBean.get(jdx).getPositionX() && positionY==getBean.get(jdx).getPositionY()){
							getBean.get(jdx).setStoneColor(odeloBean.getStoneColor());
						}
					}
				}
			}
		}
		
		return getBean;
	}
}

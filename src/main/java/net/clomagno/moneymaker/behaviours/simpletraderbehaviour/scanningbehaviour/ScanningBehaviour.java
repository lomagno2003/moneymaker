package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

public class ScanningBehaviour extends FSMBehaviour{
	private static final long serialVersionUID = -1222652103094472218L;
		
	private static final String STATE_SCANNING_LOWER_PRICE = "scanningLowerPrice";
	private static final String STATE_SCANNING_HIGHER_PRICE = "scanningHigherPrice";
	
	@Override
	public void onStart(){
		//Initialization of states
		Behaviour scanningLowerPriceBehaviour = new ScanningBalancesBehaviour();
		Behaviour scanningHigherPriceBehaviour = new ScanningBoundPricesBehaviour();
		
		//Configuration of the states
		scanningLowerPriceBehaviour.setDataStore(getDataStore());
		scanningHigherPriceBehaviour.setDataStore(getDataStore());
		
		//Register of states
		registerFirstState(scanningLowerPriceBehaviour, STATE_SCANNING_LOWER_PRICE);
		registerLastState(scanningHigherPriceBehaviour, STATE_SCANNING_HIGHER_PRICE);
		
		//Register of transitions
		registerDefaultTransition(STATE_SCANNING_LOWER_PRICE, STATE_SCANNING_HIGHER_PRICE);
	}
	
	@Override
	public int onEnd(){
		restart();
		return super.onEnd();
	}
}

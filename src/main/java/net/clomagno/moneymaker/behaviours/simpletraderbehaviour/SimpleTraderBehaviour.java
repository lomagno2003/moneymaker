package net.clomagno.moneymaker.behaviours.simpletraderbehaviour;

import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.buyingbehaviour.BuyingBehaviour;
import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour.ScanningBehaviour;
import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour.SellingBehaviour;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

public class SimpleTraderBehaviour extends FSMBehaviour{
	private static final long serialVersionUID = 4934131284427906093L;
	private static final String STATE_SELLING = "selling";
	private static final String STATE_BUYING = "buying";
	private static final String STATE_SCANNING = "scanning";

	public void setup(){
		//Initialization of states
		Behaviour buyingBehaviour = new BuyingBehaviour();
		Behaviour sellingBehaviour = new SellingBehaviour();
		Behaviour scanningBehaviour = new ScanningBehaviour();
		
		//Configuration of the states
		buyingBehaviour.setDataStore(getDataStore());
		sellingBehaviour.setDataStore(getDataStore());
		scanningBehaviour.setDataStore(getDataStore());
		
		//Register of states
		registerState(buyingBehaviour, STATE_BUYING);
		registerState(sellingBehaviour, STATE_SELLING);
		registerState(scanningBehaviour, STATE_SCANNING);
		
		//Register of transitions
		registerDefaultTransition(STATE_SCANNING, STATE_BUYING);
		registerDefaultTransition(STATE_BUYING, STATE_SELLING);
		registerDefaultTransition(STATE_SELLING, STATE_SCANNING);
	}
}
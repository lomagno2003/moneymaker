package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.buyingbehaviour;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

public class BuyingBehaviour extends FSMBehaviour{
	private static final long serialVersionUID = -1222652103094472218L;
	private static final String STATE_SENDING_BUY_REQUEST = "sendingBuyRequest";
	private static final String STATE_WAITING_BUY_CONFIRM = "waitingBuyConfirm";
	
	public void setup(){
		//Initialization of states
		Behaviour sendingBuyRequestBehaviour = new SendingBuyRequestBehaviour();
		Behaviour waitingBuyConfirmBehaviour = new WaitingBuyConfirmBehaviour();
		
		//Configuration of the states
		sendingBuyRequestBehaviour.setDataStore(getDataStore());
		sendingBuyRequestBehaviour.setDataStore(getDataStore());
		
		//Register of states
		registerState(sendingBuyRequestBehaviour, STATE_SENDING_BUY_REQUEST);
		registerState(waitingBuyConfirmBehaviour, STATE_WAITING_BUY_CONFIRM);
		
		//Register of transitions
		registerTransition(STATE_WAITING_BUY_CONFIRM, STATE_SENDING_BUY_REQUEST, WaitingBuyConfirmBehaviour.EVENT_CONFIRM_FAILED);
	}
}

package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

public class SellingBehaviour extends FSMBehaviour{
	private static final long serialVersionUID = -1222652103094472218L;
	private static final String STATE_SENDING_SELL_REQUEST = "sendingSellRequest";
	private static final String STATE_WAITING_SELL_CONFIRM = "waitingSellConfirm";
	
	@Override
	public void onStart(){
		//Initialization of states
		Behaviour sendingSellRequestBehaviour = new SendingSellRequestBehaviour();
		Behaviour waitingSellConfirmBehaviour = new WaitingSellConfirmBehaviour();
		
		//Configuration of the states
		sendingSellRequestBehaviour.setDataStore(getDataStore());
		waitingSellConfirmBehaviour.setDataStore(getDataStore());
		
		//Register of states
		registerState(sendingSellRequestBehaviour, STATE_SENDING_SELL_REQUEST);
		registerState(waitingSellConfirmBehaviour, STATE_WAITING_SELL_CONFIRM);
		
		//Register of transitions
		registerTransition(STATE_WAITING_SELL_CONFIRM, STATE_SENDING_SELL_REQUEST, WaitingSellConfirmBehaviour.EVENT_CONFIRM_FAILED);
	}
}

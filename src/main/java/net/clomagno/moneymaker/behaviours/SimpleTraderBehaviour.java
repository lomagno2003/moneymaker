package net.clomagno.moneymaker.behaviours;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

public class SimpleTraderBehaviour extends FSMBehaviour{
	private static final long serialVersionUID = 4934131284427906093L;
	private static final String STATE_SELLING = "selling";

	public void setup(){
		registerFirstState(null, STATE_SELLING);
	}

}

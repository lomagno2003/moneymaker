package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class WaitingSellConfirmBehaviour extends Behaviour{

	public static final int EVENT_CONFIRM_FAILED = 0;

	private Boolean baseBalanceChanged = false;
	
	@Override
	public void action() {
		try {
			TradingConnection connection = (TradingConnection) getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
			Double lastBaseBalance = (Double) getDataStore().get(SimpleTraderAgent.MM_BASE_BALANCE); 
			Double actualBaseBalance = connection.getBaseBalance();
			
			if(lastBaseBalance < actualBaseBalance){
				baseBalanceChanged = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return baseBalanceChanged;
	}

}

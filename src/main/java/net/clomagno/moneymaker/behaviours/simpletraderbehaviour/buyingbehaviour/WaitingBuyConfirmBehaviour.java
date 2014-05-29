package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.buyingbehaviour;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class WaitingBuyConfirmBehaviour extends Behaviour{
	private static final long serialVersionUID = 4668012181481430216L;
	
	public static final int EVENT_CONFIRM_FAILED = 0;
	
	public Boolean secondaryBalanceChanged = false;

	@Override
	public void action() {
		try {
			TradingConnection connection = (TradingConnection) getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
			Double lastSecondaryBalance = (Double) getDataStore().get(SimpleTraderAgent.MM_SECONDARY_BALANCE); 
			Double actualSecondaryBalance = connection.getSecondaryBalance();
			
			if(lastSecondaryBalance < actualSecondaryBalance){
				secondaryBalanceChanged = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return secondaryBalanceChanged;
	}

}

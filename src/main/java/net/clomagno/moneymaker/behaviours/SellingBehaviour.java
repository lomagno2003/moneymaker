package net.clomagno.moneymaker.behaviours;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class SellingBehaviour extends Behaviour{
	private static final long serialVersionUID = 6466149626528782658L;

	@Override
	public void action() {
		TradingConnection connection = (TradingConnection)getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
		
	}

	@Override
	public boolean done() {
		return true;
	}

}

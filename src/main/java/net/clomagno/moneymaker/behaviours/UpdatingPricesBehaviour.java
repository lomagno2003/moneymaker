package net.clomagno.moneymaker.behaviours;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import net.clomagno.moneymaker.connections.TradingConnection.CryptocoinType;
import jade.core.behaviours.Behaviour;

public class UpdatingPricesBehaviour extends Behaviour{
	private static final long serialVersionUID = -1222652103094472218L;

	@Override
	public void action() {
		TradingConnection connection = (TradingConnection)getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
		CryptocoinType criptocoinType = (CryptocoinType) getDataStore().get(SimpleTraderAgent.MM_CRYPTOCOIN_TYPE);
		
		getDataStore().put(SimpleTraderAgent.MM_HIGER_PRICE, connection.getHigherPrice(criptocoinType));
		getDataStore().put(SimpleTraderAgent.MM_LOWER_PRICE, connection.getLowerPrice(criptocoinType));
	}

	@Override
	public boolean done() {
		return true;
	}

}

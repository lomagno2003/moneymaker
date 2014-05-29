package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class ScanningLowerPriceBehaviour extends Behaviour{
	private static final long serialVersionUID = 7065019488585930732L;
	
	private Boolean lowerPriceScanned = false;

	@Override
	public void action() {
		try {
			TradingConnection connection = (TradingConnection)getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
		
			getDataStore().put(SimpleTraderAgent.MM_LOWER_PRICE, connection.getLowerPrice());
			
			lowerPriceScanned = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return lowerPriceScanned;
	}

}

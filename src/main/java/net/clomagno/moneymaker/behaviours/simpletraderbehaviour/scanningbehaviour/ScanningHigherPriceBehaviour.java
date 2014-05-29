package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class ScanningHigherPriceBehaviour extends Behaviour {
	private static final long serialVersionUID = -546917214001740165L;
	
	private Boolean higherPriceScanned = false;
	
	@Override
	public void action() {
		try {
			TradingConnection connection = (TradingConnection)getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
		
			getDataStore().put(SimpleTraderAgent.MM_HIGER_PRICE, connection.getHigherPrice());
			
			higherPriceScanned = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return higherPriceScanned;
	}

}

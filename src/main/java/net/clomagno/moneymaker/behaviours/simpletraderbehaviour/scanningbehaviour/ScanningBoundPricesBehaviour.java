package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour;

import org.apache.log4j.Logger;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class ScanningBoundPricesBehaviour extends Behaviour {
	private static final long serialVersionUID = -546917214001740165L;
	
	private static final Logger log = Logger.getLogger(ScanningBoundPricesBehaviour.class.getName());	
	
	private Boolean boundPricesScanned = false;
	
	@Override
	public void action() {
		log.info("Scanning bound prices");
		try {
			TradingConnection connection = (TradingConnection)getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
		
			getDataStore().put(SimpleTraderAgent.MM_HIGER_PRICE, connection.getHigherPrice());
			getDataStore().put(SimpleTraderAgent.MM_LOWER_PRICE, connection.getLowerPrice());
			
			boundPricesScanned = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return boundPricesScanned;
	}

}

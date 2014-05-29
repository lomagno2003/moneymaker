package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour;

import org.apache.log4j.Logger;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class ScanningBalancesBehaviour extends Behaviour{
	private static final long serialVersionUID = 7065019488585930732L;
	
	private static final Logger log = Logger.getLogger(ScanningBalancesBehaviour.class.getName());	
	
	private Boolean balancesScanned = false;

	@Override
	public void action() {
		log.info("Scanning balances");
		try {
			TradingConnection connection = (TradingConnection)getDataStore().get(SimpleTraderAgent.MM_TRADING_CONNECTION);
		
			getDataStore().put(SimpleTraderAgent.MM_BASE_BALANCE, connection.getBaseBalance());
			getDataStore().put(SimpleTraderAgent.MM_SECONDARY_BALANCE, connection.getSecondaryBalance());
			
			balancesScanned = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return balancesScanned;
	}

}

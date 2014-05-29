package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour;

import org.apache.log4j.Logger;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class WaitingSellConfirmBehaviour extends Behaviour{
	private static final long serialVersionUID = 7788010433443159449L;

	private static final Logger log = Logger.getLogger(SendingSellRequestBehaviour.class.getName());	

	public static final int EVENT_CONFIRM_FAILED = 0;

	private Boolean baseBalanceChanged = false;
	
	@Override
	public void action() {
		log.info("Waiting for sell confirm");
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

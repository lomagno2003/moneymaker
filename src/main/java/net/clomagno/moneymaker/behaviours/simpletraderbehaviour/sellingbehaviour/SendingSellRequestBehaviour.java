package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour;

import org.apache.log4j.Logger;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class SendingSellRequestBehaviour extends Behaviour {
	private static final long serialVersionUID = 3989527748834254874L;

	private static final Logger log = Logger.getLogger(SendingSellRequestBehaviour.class.getName());	

	private Boolean requestSended = false;
	
	@Override
	public void action() {
		log.info("Sending sell request");
		try {
			TradingConnection connection = (TradingConnection) getDataStore()
					.get(SimpleTraderAgent.MM_TRADING_CONNECTION);
			Double higherPrice = (Double) getDataStore().get(
					SimpleTraderAgent.MM_HIGER_PRICE);
			Double amount = connection.getSecondaryBalance();
			Double price = amount * higherPrice;

			connection.makeBid(amount, price);
			
			requestSended = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return requestSended;
	}

}

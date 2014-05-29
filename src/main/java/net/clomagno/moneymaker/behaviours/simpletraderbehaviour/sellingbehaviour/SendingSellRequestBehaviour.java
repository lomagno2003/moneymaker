package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class SendingSellRequestBehaviour extends Behaviour {
	private static final long serialVersionUID = 3989527748834254874L;

	private Boolean requestSended = false;
	
	@Override
	public void action() {
		try {
			TradingConnection connection = (TradingConnection) getDataStore()
					.get(SimpleTraderAgent.MM_TRADING_CONNECTION);
			Double higherPrice = (Double) getDataStore().get(
					SimpleTraderAgent.MM_HIGER_PRICE);
			Double amount = connection.getSecondaryBalance();
			Double price = amount * higherPrice;

			connection.askForBid(amount, price);
			
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

package net.clomagno.moneymaker.behaviours.simpletraderbehaviour.buyingbehaviour;

import net.clomagno.moneymaker.agents.SimpleTraderAgent;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.behaviours.Behaviour;

public class SendingBuyRequestBehaviour extends Behaviour {
	private static final long serialVersionUID = 3989527748834254874L;

	private Boolean requestSended = false;

	@Override
	public void action() {
		try {
			TradingConnection connection = (TradingConnection) getDataStore()
					.get(SimpleTraderAgent.MM_TRADING_CONNECTION);
			Double lowerPrice = (Double) getDataStore().get(
					SimpleTraderAgent.MM_LOWER_PRICE);
			Double baseBalance = (Double) getDataStore().get(
					SimpleTraderAgent.MM_BASE_BALANCE);
			Double amount = baseBalance / lowerPrice;

			connection.askForBid(amount, baseBalance);
			
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

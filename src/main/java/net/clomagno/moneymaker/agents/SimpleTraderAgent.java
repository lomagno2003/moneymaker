package net.clomagno.moneymaker.agents;

import org.apache.log4j.Logger;

import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.SimpleTraderBehaviour;
import net.clomagno.moneymaker.connections.DummyTradingConnection;
import net.clomagno.moneymaker.connections.TradingConnection;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;

public class SimpleTraderAgent extends Agent {
	private static final long serialVersionUID = 1572224271695922502L;
	
	private static final Logger log = Logger.getLogger(SimpleTraderAgent.class.getName());
	
	public static final String MM_TRADING_CONNECTION = "tradingConnection";
	public static final String MM_BASE_BALANCE = "bb";
	public static final String MM_SECONDARY_BALANCE = "sb";
	public static final String MM_LOWER_PRICE = "lower";
	public static final String MM_HIGER_PRICE = "higer";
	
	
	
	private DataStore dataStore;

	@Override
	protected void setup() {
		log.info("Agent initialization started");
		super.setup();
		
		dataStore = new DataStore();
		dataStore.put(MM_TRADING_CONNECTION, new DummyTradingConnection());
		
		Behaviour behaviour=new SimpleTraderBehaviour();
		behaviour.setDataStore(dataStore);
		
		addBehaviour(behaviour);
		log.info("Agent initialization finished");
	}
}

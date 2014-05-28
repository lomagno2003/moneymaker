package net.clomagno.moneymaker.connections.tests;

import static org.junit.Assert.*;
import net.clomagno.moneymaker.connections.GenericXChangeTradingConnection;

import org.junit.Before;
import org.junit.Test;

import com.xeiam.xchange.currency.Currencies;

public abstract class GenericXChangeTradingConnectionTest {
	private GenericXChangeTradingConnection connection;
	
	protected abstract GenericXChangeTradingConnection initConnection();
	
	@Before
	public void setUp(){
		connection = initConnection();
	}
	
	@Test
	public void testGetLowerPriceImpl() throws Exception {
		Double lowerPrice = connection.getLowerPrice();
		assertTrue("The lower price is: " + lowerPrice, true);
	}

	@Test
	public void testGetHigherPriceImpl() throws Exception {
		Double higherPrice = connection.getHigherPrice();
		assertTrue("The lower price is: " + higherPrice, true);
	}

	@Test
	public void testGetBalanceImpl() throws Exception {
		Double balance = connection.getBaseBalance();
		
		System.out.println("The balance is: " + balance);
	}
	
	@Test
	public void testAskForBid() throws Exception {
		connection.askForBid(0.0d, 0.0d);
		connection.cancelOrders();
	}
}

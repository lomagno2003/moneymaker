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
		Double lowerPrice = connection.getLowerPrice(Currencies.BTC, Currencies.USD);
	}

	@Test
	public void testGetHigherPriceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBalanceImpl() throws Exception {
		Double balance = connection.getLowerPrice(Currencies.BTC, Currencies.USD);
	}

	@Test
	public void testSendBuyImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendSellImpl() {
		fail("Not yet implemented");
	}

}

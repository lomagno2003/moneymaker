package net.clomagno.moneymaker.connections.tests;

import net.clomagno.moneymaker.connections.BitfinexTradingConnection;
import net.clomagno.moneymaker.connections.GenericXChangeTradingConnection;

public class BitfinexTradingConnectionTest extends GenericXChangeTradingConnectionTest {
	@Override
	protected GenericXChangeTradingConnection initConnection() {
		return new BitfinexTradingConnection();
	}
	
}

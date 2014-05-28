package net.clomagno.moneymaker.connections.tests;

import net.clomagno.moneymaker.connections.BTCETradingConnection;
import net.clomagno.moneymaker.connections.GenericXChangeTradingConnection;


public class BTCETradingConnectionTest extends GenericXChangeTradingConnectionTest {
	@Override
	protected GenericXChangeTradingConnection initConnection() {
		return new BTCETradingConnection();
	}
}

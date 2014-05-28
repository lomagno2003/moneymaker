package net.clomagno.moneymaker.connections;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.btce.v3.BTCEExchange;

public class BTCETradingConnection extends GenericXChangeTradingConnection{
	@Override
	protected Exchange initExchange() {
		ExchangeSpecification exSpec = new ExchangeSpecification(BTCEExchange.class);
	    exSpec.setSecretKey("baf70138840264fca9a676af8a6a6030745218e065c66d3ca35ac66d4a157a42");
	    exSpec.setApiKey("L2HTM88A-K78P7XYO-IOCOY7ID-APLGQZL4-RMOT3836");
	    exSpec.setSslUri("https://www.btc-e.com");
	    
	    return ExchangeFactory.INSTANCE.createExchange(exSpec);
	}
}

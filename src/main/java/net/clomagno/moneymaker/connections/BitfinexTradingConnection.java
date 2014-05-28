package net.clomagno.moneymaker.connections;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitfinex.v1.BitfinexExchange;
import com.xeiam.xchange.currency.Currencies;

public class BitfinexTradingConnection extends GenericXChangeTradingConnection{
	@Override
	protected Exchange initExchange() {
		setBaseCurrency(Currencies.USD);
		setSecondaryCurrency(Currencies.BTC);
		
		ExchangeSpecification exSpec = new ExchangeSpecification(BitfinexExchange.class);
	    exSpec.setSecretKey("GsBFCoyoL99PobWuGPw1I1jSIOpe6ghKESKaM292g3E");
	    exSpec.setApiKey("8nNZ7CQJkR3u539pOZ2UDzHBKYBzgHNrEC9cKHWOnJR");
	    exSpec.setSslUri("https://api.bitfinex.com");
	    return ExchangeFactory.INSTANCE.createExchange(exSpec);
	    
	    /*Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
	    return bitfinex;*/
	}
}

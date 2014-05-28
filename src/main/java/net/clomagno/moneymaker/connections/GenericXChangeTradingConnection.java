package net.clomagno.moneymaker.connections;

import java.math.BigDecimal;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.Order.OrderType;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.trade.LimitOrder;
import com.xeiam.xchange.service.polling.PollingAccountService;
import com.xeiam.xchange.service.polling.PollingMarketDataService;
import com.xeiam.xchange.service.polling.PollingTradeService;

public abstract class GenericXChangeTradingConnection extends TradingConnection{
	private Exchange exchange;
	
	protected abstract Exchange initExchange();
	
	public GenericXChangeTradingConnection(){
		exchange = initExchange();
	}

	@Override
	protected Double getLowerPriceImpl(String currencyFrom, String currencyTo) throws Exception{
		// Interested in the public polling market data feed (no authentication)
	    PollingMarketDataService marketDataService = exchange.getPollingMarketDataService();

	    // Get the latest ticker data showing BTC to CAD
	    Ticker ticker = marketDataService.getTicker(new CurrencyPair(currencyFrom, currencyTo));
	    
	    return ticker.getLow().doubleValue();
	}

	@Override
	protected Double getHigherPriceImpl(String currencyFrom, String currencyTo) throws Exception{
		// Interested in the public polling market data feed (no authentication)
	    PollingMarketDataService marketDataService = exchange.getPollingMarketDataService();

	    // Get the latest ticker data showing BTC to CAD
	    Ticker ticker = marketDataService.getTicker(new CurrencyPair(currencyFrom, currencyTo));
	    
	    return ticker.getHigh().doubleValue();
	}

	@Override
	protected Double getBalanceImpl(String criptocoinType) throws Exception{
		// Interested in the private account functionality (authentication)
	    PollingAccountService accountService = exchange.getPollingAccountService();

	    // Get the account information
	    AccountInfo accountInfo = accountService.getAccountInfo();
	    
	    BigDecimal balance = accountInfo.getBalance(criptocoinType);
	    
	    return balance.doubleValue();
	}

	@Override
	protected void placeOrderImpl(Double amount, String cryptocoinType,
			Double price, String currencyType)  throws Exception{
		PollingTradeService tradeService = exchange.getPollingTradeService();
		
		LimitOrder limitOrder = new LimitOrder((OrderType.BID), BigDecimal.ONE, CurrencyPair.BTC_CNY, "", null, new BigDecimal("0.01"));
	    String limitOrderReturnValue = tradeService.placeLimitOrder(limitOrder);
	}
}


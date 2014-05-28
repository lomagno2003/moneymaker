package net.clomagno.moneymaker.connections;

import java.math.BigDecimal;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.Order;
import com.xeiam.xchange.dto.Order.OrderType;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.trade.LimitOrder;
import com.xeiam.xchange.dto.trade.OpenOrders;
import com.xeiam.xchange.service.polling.PollingAccountService;
import com.xeiam.xchange.service.polling.PollingMarketDataService;
import com.xeiam.xchange.service.polling.PollingTradeService;

public abstract class GenericXChangeTradingConnection extends TradingConnection {
	private Exchange exchange;

	protected abstract Exchange initExchange();

	public GenericXChangeTradingConnection() {
		exchange = initExchange();
	}

	@Override
	protected Double getLowerPriceImpl() throws Exception {
		PollingMarketDataService marketDataService = exchange
				.getPollingMarketDataService();

		Ticker ticker = marketDataService.getTicker(new CurrencyPair(
				getSecondaryCurrency(), getBaseCurrency()));

		return ticker.getLow().doubleValue();
	}

	@Override
	protected Double getHigherPriceImpl() throws Exception {
		// Interested in the public polling market data feed (no authentication)
		PollingMarketDataService marketDataService = exchange
				.getPollingMarketDataService();

		// Get the latest ticker data showing BTC to CAD
		Ticker ticker = marketDataService.getTicker(new CurrencyPair(
				getSecondaryCurrency(), getBaseCurrency()));

		return ticker.getHigh().doubleValue();
	}

	@Override
	protected Double getBaseBalanceImpl() throws Exception {
		// Interested in the private account functionality (authentication)
		PollingAccountService accountService = exchange
				.getPollingAccountService();

		// Get the account information
		AccountInfo accountInfo = accountService.getAccountInfo();

		BigDecimal balance = accountInfo.getBalance(getBaseCurrency());

		return balance.doubleValue();
	}

	@Override
	protected Double getSecondaryBalanceImpl() throws Exception {
		// Interested in the private account functionality (authentication)
		PollingAccountService accountService = exchange
				.getPollingAccountService();

		// Get the account information
		AccountInfo accountInfo = accountService.getAccountInfo();

		BigDecimal balance = accountInfo.getBalance(getSecondaryCurrency());

		return balance.doubleValue();
	}

	@Override
	protected void makeBidImpl(Double amount, Double price) throws Exception {
		PollingTradeService tradeService = exchange.getPollingTradeService();

		LimitOrder limitOrder = new LimitOrder((OrderType.BID), BigDecimal.ONE,
				new CurrencyPair(getSecondaryCurrency(), getBaseCurrency()),
				"", null, new BigDecimal("0.01"));
		String limitOrderReturnValue = tradeService.placeLimitOrder(limitOrder);
	}

	@Override
	protected void askForBidImpl(Double amount, Double price) throws Exception {
		PollingTradeService tradeService = exchange.getPollingTradeService();

		LimitOrder limitOrder = new LimitOrder((OrderType.ASK), BigDecimal.ONE,
				new CurrencyPair(getSecondaryCurrency(), getBaseCurrency()),
				"", null, new BigDecimal("0.01"));
		String limitOrderReturnValue = tradeService.placeLimitOrder(limitOrder);
	}

	@Override
	protected void cancelOrdersImpl() throws Exception {
		PollingTradeService tradeService = exchange.getPollingTradeService();

		OpenOrders openOrders = tradeService.getOpenOrders();

		for (Order order : openOrders.getOpenOrders()) {
			tradeService.cancelOrder(order.getId());
		}
	}
}

package net.clomagno.moneymaker.connections;

import org.apache.log4j.Logger;

public abstract class TradingConnection {
	private static final Logger log = Logger.getLogger(TradingConnection.class.getName());
	
	private String baseCurrency;
	
	private String secondaryCurrency;
	
	public String getBaseCurrency() {
		log.info("Consulting for base currency, wich is: " + baseCurrency);
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		log.info("Setting base currency from " + this.baseCurrency + " to " + baseCurrency);
		this.baseCurrency = baseCurrency;
	}

	public String getSecondaryCurrency() {
		log.info("Consulting for secondary currency, wich is: " + secondaryCurrency);
		return secondaryCurrency;
	}

	public void setSecondaryCurrency(String secondaryCurrency) {
		log.info("Setting secondary currency from " + this.secondaryCurrency + " to " + secondaryCurrency);
		this.secondaryCurrency = secondaryCurrency;
	}

	public final Double getLowerPrice() throws Exception{
		Double result = getLowerPriceImpl();
		log.info("call to getLowerPrice = " + result);
		return result;
	};

	public final Double getHigherPrice() throws Exception{
		Double result = getHigherPriceImpl();
		log.info("call to getHigherPrice = " + result);
		return result;
	};
	
	public final Double getBaseBalance() throws Exception{
		Double result = getBaseBalanceImpl();
		log.info("call to getBaseBalance() = " + result);
		return result;
	}

	public final Double getSecondaryBalance() throws Exception{
		Double result = getSecondaryBalanceImpl();
		log.info("call to getSecondaryBalance() = " + result);
		return result;
	}

	public final void makeBid(Double amount, Double price) throws Exception{
		log.info("call to makeBid(" + amount + "," + price + ")");
		makeBidImpl(amount, price);
	};

	public final void askForBid(Double amount, Double price) throws Exception{
		log.info("call to askForBid(" + amount + "," + price + ")");
		askForBidImpl(amount, price);
	};
	
	public final void cancelOrders() throws Exception{
		log.info("cancelOrders()");
		cancelOrdersImpl();
	}

	protected abstract Double getLowerPriceImpl() throws Exception;

	protected abstract Double getHigherPriceImpl() throws Exception;
	
	protected abstract Double getBaseBalanceImpl() throws Exception;
	
	protected abstract Double getSecondaryBalanceImpl() throws Exception;
	
	protected abstract void makeBidImpl(Double amount, Double price) throws Exception;

	protected abstract void askForBidImpl(Double amount, Double price) throws Exception;
	
	protected abstract void cancelOrdersImpl() throws Exception;
}

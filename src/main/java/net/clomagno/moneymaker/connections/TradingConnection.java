package net.clomagno.moneymaker.connections;

public abstract class TradingConnection {
	private String baseCurrency;
	
	private String secondaryCurrency;
	
	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getSecondaryCurrency() {
		return secondaryCurrency;
	}

	public void setSecondaryCurrency(String secondaryCurrency) {
		this.secondaryCurrency = secondaryCurrency;
	}

	public final Double getLowerPrice() throws Exception{
		return getLowerPriceImpl();
	};

	public final Double getHigherPrice() throws Exception{
		return getHigherPriceImpl();
	};
	
	public final Double getBaseBalance() throws Exception{
		return getBaseBalanceImpl();
	}

	public final Double getSecondaryBalance() throws Exception{
		return getSecondaryBalanceImpl();
	}

	public final void makeBid(Double amount, Double price) throws Exception{
		makeBidImpl(amount, price);
	};

	public final void askForBid(Double amount, Double price) throws Exception{
		askForBidImpl(amount, price);
	};
	
	public final void cancelOrders() throws Exception{
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

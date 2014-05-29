package net.clomagno.moneymaker.connections;

public class DummyTradingConnection extends TradingConnection{
	private Double lower = 1d;
	
	private Double higher = 2d;
	
	private Double baseBalance = 100d;
	
	private Double secondaryBalance = 50d;

	@Override
	protected Double getLowerPriceImpl() throws Exception {
		return lower;
	}

	@Override
	protected Double getHigherPriceImpl() throws Exception {
		return higher;
	}

	@Override
	protected Double getBaseBalanceImpl() throws Exception {
		return baseBalance;
	}

	@Override
	protected Double getSecondaryBalanceImpl() throws Exception {
		return secondaryBalance;
	}

	@Override
	protected void makeBidImpl(Double amount, Double price) throws Exception {
		secondaryBalance-=amount;
		baseBalance+=price;
	}

	@Override
	protected void askForBidImpl(Double amount, Double price) throws Exception {
		secondaryBalance+=amount;
		baseBalance-=price;
	}

	@Override
	protected void cancelOrdersImpl() throws Exception {
		// TODO Auto-generated method stub
	}

}

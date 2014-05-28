package net.clomagno.moneymaker.connections;

public abstract class TradingConnection {
	public final Double getLowerPrice(String currencyFrom, String currencyTo) throws Exception{
		return getLowerPriceImpl(currencyFrom, currencyTo);
	};

	public final Double getHigherPrice(String currencyFrom, String currencyTo) throws Exception{
		return getHigherPriceImpl(currencyFrom, currencyTo);
	};
	
	public final Double getBalance(String currency) throws Exception{
		return getBalanceImpl(currency);
	}
	
	public final void makeBid(Double amount, String currencyFrom, Double price, String currencyTo) throws Exception{
		makeBidImpl(amount, currencyFrom, price, currencyTo);
	};

	protected abstract Double getLowerPriceImpl(String currencyFrom, String currencyTo) throws Exception;

	protected abstract Double getHigherPriceImpl(String currencyFrom, String currencyTo) throws Exception;
	
	protected abstract Double getBalanceImpl(String criptocoinType) throws Exception;
	
	protected abstract void makeBidImpl(Double amount, String currencyFrom, Double price, String currencyTo) throws Exception;
}

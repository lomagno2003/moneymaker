package net.clomagno.moneymaker.connections;

public abstract class TradingConnection {
	/**
	 *	Enum declarations
	 */
	public enum CryptocoinType{
		BTC,
		LiteCoin
	}
	
	public enum CurrencyType{
		Dollars,
		Euros
	}
	
	/** 
	 * 	Implementation of methods using template method pattern
	 * 
	 */
	
	public final Double getLowerPrice(CryptocoinType criptocoinType){
		return getLowerPriceImpl(criptocoinType);
	};
		
	public Double getHigherPrice(CryptocoinType criptocoinType){
		return getHigherPriceImpl(criptocoinType);
	};
	
	public void buy(Double amount, CryptocoinType cryptocoinType, Double price, CurrencyType currencyType){
		buyImpl(amount, cryptocoinType, price, currencyType);
	};
	
	public void sell(Double amount, CryptocoinType cryptocoinType, Double price, CurrencyType currencyType){
		sellImpl(amount, cryptocoinType, price, currencyType);
	};
	
	protected abstract Double getLowerPriceImpl(CryptocoinType criptocoinType);

	protected abstract Double getHigherPriceImpl(CryptocoinType criptocoinType);
	
	protected abstract void buyImpl(Double amount, CryptocoinType cryptocoinType, Double price, CurrencyType currencyType);
	
	protected abstract void sellImpl(Double amount, CryptocoinType cryptocoinType, Double price, CurrencyType currencyType);
}

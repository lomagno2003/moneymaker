package net.clomagno.moneymaker;

public interface TradingConnection {
	public enum CryptocoinType{
		BTC,
		LiteCoin
	}
	
	public enum CurrencyType{
		Dollars,
		Euros
	}

	public Double getLowerPrice(CryptocoinType criptocoinType);
	
	public Double getHigherPrice(CryptocoinType criptocoinType);
	
	public void buy(Double amount, CryptocoinType cryptocoinType, Double price, CurrencyType currencyType);
	
	public void sell(Double amount, CryptocoinType cryptocoinType, Double price, CurrencyType currencyType);
}

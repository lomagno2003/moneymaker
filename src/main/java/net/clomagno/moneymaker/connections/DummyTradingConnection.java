package net.clomagno.moneymaker.connections;

public class DummyTradingConnection extends TradingConnection{

	@Override
	public Double getLowerPriceImpl(CryptocoinType criptocoinType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getHigherPriceImpl(CryptocoinType criptocoinType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buyImpl(Double amount, CryptocoinType cryptocoinType,
			Double price, CurrencyType currencyType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellImpl(Double amount, CryptocoinType cryptocoinType,
			Double price, CurrencyType currencyType) {
		// TODO Auto-generated method stub
		
	}

}

package com.derun.command;

public class BuyStock implements Order{

	private Stock  stock;
	
	@Override
	public int execute() {
		stock.buy();
		return 0;
	}

	public BuyStock(Stock stock){
		this.stock=stock;
	}
}

package com.derun.command;

public class SellStock implements Order {

	private Stock  stock;
	
	public SellStock(Stock stock){
		this.stock=stock;
	}
	@Override
	public int execute() {
		stock.sell();
		return 0;
	}

}

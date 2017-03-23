package com.derun.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {

	private List<Order> lstObjs=new ArrayList<Order>();
	
	public void takeOrder(Order order){
		lstObjs.add(order);
	}
	
	public void placeOrders(){
		for(Order obj:lstObjs){
			obj.execute();
		}
		lstObjs.clear();
	}
	
	public static void main(String[] args){
		
		Stock myStock=new Stock();
		
		BuyStock buy=new BuyStock(myStock);
		SellStock sell=new SellStock(myStock);
		
		Broker broker=new Broker();
		broker.takeOrder(buy);
		broker.takeOrder(sell);
		broker.takeOrder(sell);
		broker.takeOrder(sell);
		broker.takeOrder(sell);
		broker.placeOrders();
	}
}

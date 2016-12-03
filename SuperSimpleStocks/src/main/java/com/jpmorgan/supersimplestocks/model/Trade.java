package com.jpmorgan.supersimplestocks.model;
import java.util.Date;

import com.jpmorgan.supersimplestocks.model.constants.Indicator;
import com.jpmorgan.supersimplestocks.utils.Utils;

public class Trade {

	private Date timeStamp = null;
	private Stock stock = null;
	private Indicator indicator = Indicator.BUY;
	private int quantity = 0;
	private double price = 0.0;

	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Indicator getIndicator() {
		return indicator;
	}
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String pattern = "|%-20s|%-5s|%-5s|%-5s|%-5s|\n";
		return String.format(pattern,Utils.timeStampFormatted(timeStamp),stock.getStockSymbol().toString(),getIndicator().toString() ,quantity, price);
	}

}

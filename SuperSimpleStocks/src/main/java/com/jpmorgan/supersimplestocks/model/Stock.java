package com.jpmorgan.supersimplestocks.model;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;
import com.jpmorgan.supersimplestocks.model.constants.Type;

/**
 * 
 * @author Fabrizio Zandonella
 *
 */
public class Stock {

	private Symbol symbol = null;
	private Type type = Type.COMMON;
	private double lastDividend = 0.0;
	private double fixedDividend = 0.0;
	private double parValue = 0.0;


	public Symbol getStockSymbol() {
		return symbol;
	}
	public void setStockSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}


	@Override
	public String toString() {
		String pattern = "|%-10s|%-9s|%-9s|%-10s|%-8s|\n";
		return String.format(pattern,symbol,type ,lastDividend, fixedDividend, parValue);
	}
}


package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.model.Trade;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;

/**
 * 
 * @author Fabrizio Zandonella
 *
 */

public interface SuperSimpleStocksService {

	public double dividendYield(Symbol symbol, double price) throws Exception;
	
	public double priceEarningsRatio(Symbol symbol, double price)throws Exception;
	
	public boolean insTrade(Trade trade)throws Exception;
	
	public double volumeWeightedStockPrice(Symbol symbol, int minutes)throws Exception;
	
	public double gbceAllShareIndex()throws Exception;
	
}

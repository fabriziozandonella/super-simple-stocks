package com.jpmorgan.supersimplestocks.data;

import java.util.ArrayList;
import java.util.HashMap;

import com.jpmorgan.supersimplestocks.model.Stock;
import com.jpmorgan.supersimplestocks.model.Trade;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;


/**
 * 
 * @author Fabrizio Zandonella
 *
 */
public interface DataManager {

	public boolean insTrade(Trade trade) throws Exception;

	public ArrayList<Trade> getTradeList();

	public ArrayList<Trade> getTradeList(Symbol symbol, int minutes) throws Exception;;

	public HashMap<Symbol, Stock> getStockMap();

	public Stock getStockBySymbol(Symbol symbol);

}

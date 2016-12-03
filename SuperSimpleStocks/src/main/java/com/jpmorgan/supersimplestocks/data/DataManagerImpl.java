package com.jpmorgan.supersimplestocks.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.jpmorgan.supersimplestocks.model.Stock;
import com.jpmorgan.supersimplestocks.model.Trade;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;
import com.jpmorgan.supersimplestocks.utils.Utils;

/**
 * 
 * @author Fabrizio Zandonella
 *
 */

public class DataManagerImpl implements DataManager{
	private ArrayList<Trade> tradeList = null;
	private HashMap<Symbol, Stock> stockMap = null;

 
	public DataManagerImpl(HashMap<Symbol, Stock> stocks){
		this.stockMap = stocks;
		tradeList = new ArrayList<Trade>();
	}

	/**
	 * 
	 */
	public boolean insTrade(Trade trade) throws Exception {
		boolean res = false;

		try{
			res = tradeList.add(trade);
		}catch(Exception exception){
			throw new Exception("DataManagerImpl.insTrade Exception", exception);
		}
		return res;

	}

	public ArrayList<Trade> getTradeList() {

		return tradeList;
	}

	/**
	 * Returns the List of trades, given a stock, in past n minutes
	 * minutes: is the range of the the minutes passed until now, if minutes = 0 returns all trades
	 * 
	 * @param symbol 
	 * @param minutes 
	 * @return 
	 * @throws Exception       
	 */
	public ArrayList<Trade> getTradeList(Symbol symbol, int minutes) throws Exception {
		ArrayList<Trade> tl = new ArrayList<Trade>();
		if(tradeList.size()==0){
			throw new Exception("tradeList is void");
		}

		if(minutes==0){
			for(Trade trade : tradeList){
				if(trade.getStock().getStockSymbol()== symbol){
					tl.add(trade);
				}
			}
		}else{
			Date rangeDate = Utils.timeStamp(minutes);
			for(Trade trade : tradeList){
				if(trade.getStock().getStockSymbol()== symbol && trade.getTimeStamp().compareTo(rangeDate)>=0 ){
					tl.add(trade);
				} 
			}
		}

		return tl;
	}

	/**
	 * 
	 */
	public HashMap<Symbol, Stock> getStockMap() {
		return stockMap;
	}

	/**
	 * Returns the stock by symbol
	 * 
	 * @return 
	 * @param symbol
	 */
	public Stock getStockBySymbol(Symbol symbol) {
		return getStockMap().get(symbol);
	}

}

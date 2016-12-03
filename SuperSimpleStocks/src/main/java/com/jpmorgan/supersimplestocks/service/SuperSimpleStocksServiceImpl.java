package com.jpmorgan.supersimplestocks.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import com.jpmorgan.supersimplestocks.ApplicationConfig;
import com.jpmorgan.supersimplestocks.data.DataManager;
import com.jpmorgan.supersimplestocks.data.DataManagerImpl;
import com.jpmorgan.supersimplestocks.model.Stock;
import com.jpmorgan.supersimplestocks.model.Trade;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;
import com.jpmorgan.supersimplestocks.model.constants.Type;
import com.jpmorgan.supersimplestocks.utils.Utils;
/**
 * 
 * @author Fabrizio Zandonella
 *
 */
 
public class SuperSimpleStocksServiceImpl implements SuperSimpleStocksService{
	private Logger logger = LogManager.getLogger(SuperSimpleStocksServiceImpl.class);

	@Autowired
	DataManager dataManager;

	/**
	 * Calculates the Dividend Yield:
	 * for a given stock identified with Symbol, 
	 * given any price as input, 
	 * 
	 * @param symbol 
	 * @param price 
	 * @return Dividend Yield
	 * @throws Exception
	 */
	public double dividendYield(Symbol symbol, double price) throws Exception {
		double dy = 0.0;
		try{
			if(null==symbol ){
				throw new Exception("symbol is null.");
			}
			if(price <= 0.0 ){
				throw new Exception("price is 0");
			}			
			Stock stock = dataManager.getStockBySymbol(symbol);

			if(Type.COMMON == stock.getType()){
				//COMMON
				dy = stock.getLastDividend()/price;
			}else{
				//PREFERRED
				dy = (stock.getFixedDividend()*stock.getParValue())/price;
			}

		}catch(Exception ex){
			logger.error("SuperSimpleStocksServiceImpl.dividendYield Error:" + ex.getStackTrace());
			throw new Exception("SuperSimpleStocksServiceImpl.dividendYield Error:" + ex.getStackTrace());
		}
		return dy;
	}
	/**
	 * Calculates the Price Earnings Ratio:
	 * for a given stock identified with Symbol, 
	 * given any price as input, 
	 * 
	 * @param symbol 
	 * @param price 
	 * @return Price Earnings Ratio
	 * @throws Exception
	 */
	public double priceEarningsRatio(Symbol symbol, double price) throws Exception {
		double peRatio = 0.0;
		try{

			if(null==symbol ){
				throw new Exception("symbol is null.");
			}
			if(price <= 0.0 ){
				throw new Exception("price is 0.0.");
			}		
			
			peRatio = price/dividendYield(symbol, price);

		}catch(Exception ex){
			logger.error("SuperSimpleStocksServiceImpl.priceEarningsRatio Error:" + ex.getStackTrace());
			throw new Exception("SuperSimpleStocksServiceImpl.priceEarningsRatio Error:" + ex.getStackTrace());
		}	

		return peRatio;
	}

	/**
	 * Records a trade
	 *
	 * @param trade 
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean insTrade(Trade trade) throws Exception {
		boolean res = false;

		try{
			Utils.checkTrade(trade);

			res = dataManager.insTrade(trade);


		}catch(Exception ex){
			logger.error("SuperSimpleStocksServiceImpl.insTrade error",ex);
			throw new Exception("SuperSimpleStocksServiceImpl.insTrade error",ex);
		}

		return res;
	}
	/**
	 * Calculates the Volume Weighted Stock Price based on trades in past n minutes:
	 * for a given stock identified with Symbol, 
	 * 
	 * @param symbol 
	 * @param minutes 
	 * @return Volume Weighted Stock Price
	 * @throws Exception
	 */
	public double volumeWeightedStockPrice(Symbol symbol, int minutes) throws Exception {
		double iPQ = 0.0;
		int iQ = 0;
		
		if(null==symbol ){
			throw new Exception("symbol is null.");
		}
		if(minutes<0 ){
			throw new Exception("minutes < 0.");
		}
		
		ArrayList<Trade> tradeList = dataManager.getTradeList(symbol, minutes);

		for(Trade trade : tradeList){
			iPQ += (trade.getPrice() *  trade.getQuantity());
			iQ += trade.getQuantity();
		}

		return iPQ/iQ;
	}
	/**
	 * Calculates the GBCE All Share Index:
	 * using the geometric mean of the Volume Weighted Stock Price for all stocks
	 *
	 * @param symbol 
	 * @param minutes 
	 * @return Volume Weighted Stock Price
	 * @throws Exception 
	 */
	public double gbceAllShareIndex() throws Exception {

		double gbce = 1.0;
		int rt =0;
		for(Symbol symbol : Symbol.values()){
			gbce *= volumeWeightedStockPrice(symbol, 0);
			rt++;
		}
	
		return Math.pow(gbce, 1/(double) rt );
	}

}

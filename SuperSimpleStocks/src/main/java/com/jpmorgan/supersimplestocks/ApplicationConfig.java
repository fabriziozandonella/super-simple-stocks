package com.jpmorgan.supersimplestocks;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jpmorgan.supersimplestocks.data.DataManager;
import com.jpmorgan.supersimplestocks.data.DataManagerImpl;
import com.jpmorgan.supersimplestocks.model.Stock;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;
import com.jpmorgan.supersimplestocks.model.constants.Type;
import com.jpmorgan.supersimplestocks.service.SuperSimpleStocksService;
import com.jpmorgan.supersimplestocks.service.SuperSimpleStocksServiceImpl;

/**
 * 
 * @author Fabrizio Zandonella
 *
 */
@Configuration
public class ApplicationConfig {

	@Bean(name="dataManager")
	public DataManager dataManager() {
		HashMap<Symbol, Stock> stocks = new HashMap<Symbol, Stock>();
		stocks.put(Symbol.TEA, sTEA());
		stocks.put(Symbol.POP, sPOP());
		stocks.put(Symbol.ALE, sALE());
		stocks.put(Symbol.GIN, sGIN());
		stocks.put(Symbol.JOE, sJOE());
		return new DataManagerImpl(stocks);
	}	

	@Bean(name="stockService")
	@Scope("singleton")
	public SuperSimpleStocksService stockService() {
		return new SuperSimpleStocksServiceImpl();
	}


	/*
	        Stock
			Symbol Type 	Last Dividend    Fixed Dividend   Par Value
			TEA   Common   	 	0                              	100
			POP   Common   	 	8 								100
			ALE   Common   	 	23 								60
			GIN   Preferred	 	8 					2% 			100
			JOE   Common   		13 								250
	 */

	private final Stock sTEA(){
		Stock stock = new Stock();
		stock.setStockSymbol(Symbol.TEA);
		stock.setType(Type.COMMON);
		stock.setLastDividend(0);
		stock.setFixedDividend(0);
		stock.setParValue(100);
		return stock;
	}
	private final Stock sPOP(){
		Stock stock = new Stock();
		stock.setStockSymbol(Symbol.POP);
		stock.setType(Type.COMMON);
		stock.setLastDividend(8);
		stock.setFixedDividend(0);
		stock.setParValue(100);
		return stock;
	}
	private final Stock sALE(){
		Stock stock = new Stock();
		stock.setStockSymbol(Symbol.ALE);
		stock.setType(Type.COMMON);
		stock.setLastDividend(23);
		stock.setFixedDividend(0);
		stock.setParValue(60);
		return stock;
	}
	private final Stock sGIN(){
		Stock stock = new Stock();
		stock.setStockSymbol(Symbol.GIN);
		stock.setType(Type.PREFERRED);
		stock.setLastDividend(8);
		stock.setFixedDividend(0.02);
		stock.setParValue(100);
		return stock;
	}
	public final Stock sJOE(){
		Stock stock = new Stock();
		stock.setStockSymbol(Symbol.JOE);
		stock.setType(Type.COMMON);
		stock.setLastDividend(13);
		stock.setFixedDividend(0);
		stock.setParValue(250);
		return stock;
	}


}

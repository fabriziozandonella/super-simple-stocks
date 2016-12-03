package com.jpmorgan.supersimplestocks.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.jpmorgan.supersimplestocks.ApplicationConfig;
import com.jpmorgan.supersimplestocks.model.Trade;
import com.jpmorgan.supersimplestocks.model.constants.Indicator;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;
import com.jpmorgan.supersimplestocks.service.SuperSimpleStocksService;
import com.jpmorgan.supersimplestocks.service.SuperSimpleStocksServiceTest;
import com.jpmorgan.supersimplestocks.utils.Utils;

public class DataManagerImplTest {
	Logger logger = LogManager.getLogger(SuperSimpleStocksServiceTest.class);

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	SuperSimpleStocksService s = (SuperSimpleStocksService) context.getBean("stockService");
	DataManager dm = (DataManager) context.getBean("dataManager");


	 //@Test
	public void testInsTrade() throws Exception {
		logger.info("START testInsTrade");
		Trade trade = new Trade();
		trade.setTimeStamp(Utils.timeStamp()); 
		trade.setQuantity(10);
		trade.setStock(dm.getStockBySymbol(Symbol.ALE) );
		trade.setIndicator(Indicator.BUY);
		trade.setPrice(12.50);
		assertTrue(dm.insTrade(trade));
		logger.info("END testInsTrade");
	}

	//@Test
	public void testGetTradeListSymbolInt() throws Exception {
		loadTradesExample();
		assertTrue(dm.getTradeList(Symbol.ALE, 0).size()>0);
	}

	//@Test
	public void testGetStockMap() {
		assertTrue(dm.getStockMap().size()>0);
	}

	//@Test
	public void testGetStockBySymbol() {
		for(Symbol symbol : Symbol.values()){
			assertNotNull(dm.getStockBySymbol(symbol));
			assertEquals(symbol, dm.getStockBySymbol(symbol).getStockSymbol());
		}
	}

	/*
	 * Sample Trades
	 */
	private void loadTradesExample() throws Exception{
		Trade tALE1 = new Trade();
		tALE1.setTimeStamp(Utils.timeStamp(4)); 
		tALE1.setQuantity(25);
		tALE1.setStock(dm.getStockBySymbol(Symbol.ALE) );
		tALE1.setIndicator(Indicator.BUY);
		tALE1.setPrice(25.50);
		Trade tALE2 = new Trade();
		tALE2.setTimeStamp(Utils.timeStamp(3)); 
		tALE2.setQuantity(32);
		tALE2.setStock(dm.getStockBySymbol(Symbol.ALE) );
		tALE2.setIndicator(Indicator.SELL);
		tALE2.setPrice(42.50);
		Trade tALE3 = new Trade();
		tALE3.setTimeStamp(Utils.timeStamp(5)); 
		tALE3.setQuantity(8);
		tALE3.setStock(dm.getStockBySymbol(Symbol.ALE) );
		tALE3.setIndicator(Indicator.BUY);
		tALE3.setPrice(8.01);

		Trade tPOP1 = new Trade();
		tPOP1.setTimeStamp(Utils.timeStamp(4)); 
		tPOP1.setQuantity(11);
		tPOP1.setStock(dm.getStockBySymbol(Symbol.POP) );
		tPOP1.setIndicator(Indicator.BUY);
		tPOP1.setPrice(15.50);
		Trade tPOP2 = new Trade();
		tPOP2.setTimeStamp(Utils.timeStamp(3)); 
		tPOP2.setQuantity(21);
		tPOP2.setStock(dm.getStockBySymbol(Symbol.POP) );
		tPOP2.setIndicator(Indicator.SELL);
		tPOP2.setPrice(65.50);
		Trade tPOP3 = new Trade();
		tPOP3.setTimeStamp(Utils.timeStamp(5)); 
		tPOP3.setQuantity(80);
		tPOP3.setStock(dm.getStockBySymbol(Symbol.POP) );
		tPOP3.setIndicator(Indicator.BUY);
		tPOP3.setPrice(200.20);

		Trade tGIN1 = new Trade();
		tGIN1.setTimeStamp(Utils.timeStamp(4)); 
		tGIN1.setQuantity(32);
		tGIN1.setStock(dm.getStockBySymbol(Symbol.GIN) );
		tGIN1.setIndicator(Indicator.BUY);
		tGIN1.setPrice(22.50);
		Trade tGIN2 = new Trade();
		tGIN2.setTimeStamp(Utils.timeStamp(3)); 
		tGIN2.setQuantity(15);
		tGIN2.setStock(dm.getStockBySymbol(Symbol.GIN) );
		tGIN2.setIndicator(Indicator.SELL);
		tGIN2.setPrice(43.50);
		Trade tGIN3 = new Trade();
		tGIN3.setTimeStamp(Utils.timeStamp(6)); 
		tGIN3.setQuantity(7);
		tGIN3.setStock(dm.getStockBySymbol(Symbol.GIN) );
		tGIN3.setIndicator(Indicator.BUY);
		tGIN3.setPrice(16.20);		

		Trade tTEA1 = new Trade();
		tTEA1.setTimeStamp(Utils.timeStamp(4)); 
		tTEA1.setQuantity(56);
		tTEA1.setStock(dm.getStockBySymbol(Symbol.TEA) );
		tTEA1.setIndicator(Indicator.BUY);
		tTEA1.setPrice(228.50);
		Trade tTEA2 = new Trade();
		tTEA2.setTimeStamp(Utils.timeStamp(3)); 
		tTEA2.setQuantity(36);
		tTEA2.setStock(dm.getStockBySymbol(Symbol.TEA) );
		tTEA2.setIndicator(Indicator.SELL);
		tTEA2.setPrice(78.50);
		Trade tTEA3 = new Trade();
		tTEA3.setTimeStamp(Utils.timeStamp(6)); 
		tTEA3.setQuantity(10);
		tTEA3.setStock(dm.getStockBySymbol(Symbol.TEA) );
		tTEA3.setIndicator(Indicator.BUY);
		tTEA3.setPrice(134.20);				

		Trade tJOE1 = new Trade();
		tJOE1.setTimeStamp(Utils.timeStamp(4)); 
		tJOE1.setQuantity(12);
		tJOE1.setStock(dm.getStockBySymbol(Symbol.JOE) );
		tJOE1.setIndicator(Indicator.BUY);
		tJOE1.setPrice(35.50);
		Trade tJOE2 = new Trade();
		tJOE2.setTimeStamp(Utils.timeStamp(3)); 
		tJOE2.setQuantity(7);
		tJOE2.setStock(dm.getStockBySymbol(Symbol.JOE) );
		tJOE2.setIndicator(Indicator.SELL);
		tJOE2.setPrice(11.50);
		Trade tJOE3 = new Trade();
		tJOE3.setTimeStamp(Utils.timeStamp(6)); 
		tJOE3.setQuantity(45);
		tJOE3.setStock(dm.getStockBySymbol(Symbol.JOE) );
		tJOE3.setIndicator(Indicator.BUY);
		tJOE3.setPrice(234.20);

		s.insTrade(tALE1);
		s.insTrade(tALE2);
		s.insTrade(tALE3);

		s.insTrade(tPOP1);
		s.insTrade(tPOP2);
		s.insTrade(tPOP3);

		s.insTrade(tGIN1);
		s.insTrade(tGIN2);
		s.insTrade(tGIN3);

		s.insTrade(tTEA1);
		s.insTrade(tTEA2);
		s.insTrade(tTEA3);

		s.insTrade(tJOE1);
		s.insTrade(tJOE2);
		s.insTrade(tJOE3);			
	}


}

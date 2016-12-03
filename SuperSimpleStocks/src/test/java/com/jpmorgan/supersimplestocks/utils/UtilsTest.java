package com.jpmorgan.supersimplestocks.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpmorgan.supersimplestocks.model.Stock;
import com.jpmorgan.supersimplestocks.model.Trade;
import com.jpmorgan.supersimplestocks.model.constants.Indicator;
import com.jpmorgan.supersimplestocks.model.constants.Symbol;
import com.jpmorgan.supersimplestocks.model.constants.Type;

public class UtilsTest {
 
	//@Test
	public void testTimeStampInt() {
		assertTrue(Utils.timeStamp(5).compareTo(Utils.timeStamp())<0 );
	}
 
	//@Test(expected = Exception.class) 
	public void testCheckTradeTrade1() throws Exception {
		Utils.checkTrade(null);
	}
	//@Test(expected = Exception.class) 
	public void testCheckTradeTrade2() throws Exception {
		Trade t1 = new Trade();
		t1.setQuantity(-10);
		t1.setStock(sTEA()) ;
		t1.setIndicator(Indicator.BUY);
		t1.setPrice(12.50);
		Utils.checkTrade(t1);
	}
	//@Test(expected = Exception.class) 
	public void testCheckTradeTrade3() throws Exception {
		Trade t1 = new Trade();
		t1.setQuantity(10);
		t1.setStock(null) ;
		t1.setIndicator(Indicator.BUY);
		t1.setPrice(12.50);
		Utils.checkTrade(t1);
	}
	//@Test(expected = Exception.class) 
	public void testCheckTradeTrade4() throws Exception {
		Trade t1 = new Trade();
		t1.setQuantity(10);
		t1.setStock(sTEA()) ;
		t1.setIndicator(Indicator.BUY);
		t1.setPrice(-12.50);
		Utils.checkTrade(t1);
	}
	
	
	/*
	 * Sample Stock
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
}

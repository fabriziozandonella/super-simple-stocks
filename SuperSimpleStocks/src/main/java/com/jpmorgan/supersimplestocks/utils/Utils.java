package com.jpmorgan.supersimplestocks.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jpmorgan.supersimplestocks.model.Trade;
/**
 * 
 * @author Fabrizio Zandonella
 *
 */
public final class Utils {

	/**
	 * 
	 * @return  Date
	 */
	public static Date timeStamp(){
		Calendar calendar = Calendar.getInstance();
		return  calendar.getTime() ;
	}
	/**
	 * Returns timestamp of past number of minutes
	 * 
	 * @param addMinutes
	 * @return Date
	 */
	public static Date timeStamp(int addMinutes){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, - addMinutes);
		return  calendar.getTime() ;
	}

	/**
	 * 
	 * @param date
	 * @return timestamp formatted using the pattern: yyyy-MM-dd hh:mm:ss
	 */
	public static String timeStampFormatted(Date date){
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		return ft.format(date);	 
	}

	/**
	 *  
	 * @param trade
	 * @throws Exception
	 */
	public static void checkTrade(Trade trade) throws Exception{

		if(null==trade){
			throw new Exception("trade is null.");
		}

		if(null==trade.getStock() ){
			throw new Exception("stock is null.");
		}

		if(trade.getQuantity()<=0){
			throw new Exception("quantity <= 0");
		}

		if(trade.getPrice()<=0.0){
			throw new Exception("price <= 0.0");
		}


	} 

}

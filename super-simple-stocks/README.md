Super Simple Stock Market
===================
Requirements
-------------
1. The Global Beverage Corporation Exchange is a new stock market trading in drinks companies.
a. Your company is building the object-oriented system to run that trading.
b. You have been assigned to build part of the core object model for a limited phase 1

2. Provide the source code for an application that will: 
	a. For a given stock:
		i. Given any price as input, calculate the dividend yield
		ii. Given any price as input, calculate the P/E Ratio
		iii. Record a trade, with timestamp, quantity, buy or sell indicator and price
		iv. Calculate Volume Weighted Stock Price based on trades in past 5 minutes
		f	
	b. Calculate the GBCE All Share Index using the geometric mean of the Volume Weighted Stock       Price for all stocks


Constraints & Notes
-------------
1. Written in one of these languages - Java, C#, C++, Python
2. The source code should be complete and able to be run and tested.
3. No database, GUI or I/O is required, all data need only be held in memory
4. No prior knowledge of stock markets or trading is required – all formulas are provided below.
5. The code should provide only the functionality requested, however must be production quality.

----------

**Table1. Sample data from the Global Beverage Corporation Exchange**

| Stock Symbol | Type     | Last Dividend |Fixed Dividend | Par Value |
| :----------- | --------:| :-----------: |:-------------:|:---------:|
|TEA           | Common   | 0		      | 			  |100		  |
|POP           | Common   | 8			  | 			  |100		  |
|ALE           | Common   | 23			  | 			  |60		  |
|GIN           | Preferred| 8			  | 2%			  |100		  |
|JOE           | Common   | 13			  | 			  |250		  |


----------
SuperSimpleStocks application
-------------

####  Architecture
The implementation of this solution is based on a service interface that provides the functionalities requested to the user. The back-end is based on a data-manager interface accessible from the service implementation. The objects modelled are pojos (plain old java objects) of "Stock" and "Trade".

The framework used is Spring, configured using ApplicationConfig and annotations.

 **Service **
The Service interface "SuperSimpleStocksService" provides the functionalities requested:
 - dividendYield(Symbol symbol, double price)  
 - priceEarningsRatio(SymbolinsTrade(Trade trade)
 - volumeWeightedStockPrice(Symbol symbol, int minutes)
 - gbceAllShareIndex()

 **Data**
 The interface "DataManager" provides the data access and data management:
- insTrade(Trade trade) throws Exception;
- getTradeList();
- getTradeList(Symbol symbol, int minutes) throws Exception;;
- getStockMap();
- getStockBySymbol(Symbol symbol);

> **Note:** Symbol is the Stock Symbol used as Stock id


 **Project Structure**
 
![SuperSimpleStocks project structure](super-simple-stocks/SuperSimpleStocks/doc/project-structure.jpg)

 **Class diagram**
![SuperSimpleStocks class diagram](super-simple-stocks/SuperSimpleStocks/doc/class-diagram.jpg)


####  Assunptions

####  Test

####  Execution
SuperSimpleStocks  is a maven project, you can import into Eclipse as a maven project. 

Using the command
> maven clean install

maven will compile and will execute the test provided just for the SuperSimpleStocksService. Other tests used for the development will be ignored. 

####  Documentation
[JavaDoc](https://github.com/fabriziozandonella/super-simple-stocks/tree/master/SuperSimpleStocks/doc) 

####  Future developments
Convertion of the project as a Microservice, providing: 
a RESTful API,
a Messagge service for possible integration with other Microservices. 
a Back end using a noSql database such as MongoDB



Table of contents
-------------
[TOC]


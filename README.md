Stock Platform

Stock platform is created that allows a user to Sign Up, buy and sell stocks and view portfolios.

Admin can add the stocks with the initial price for the day. Admin defines the distinct stocks available in the market.
Users can register themselves and can start trading with the amount present in the wallet.
Note: Stocks can only be traded with the amount present in the wallet. No further amount can be added.
Buying stocks will be possible only if the user has sufficient wallet balance.
Selling stocks will occur if the user has the mentioned stock and the quantity mentioned in the portfolio.
View user portfolio: This will list all available stocks users hold at present. And the return rate.
Return rate will be calculated as follows:
Return rate  = (Final value of Investment - Initial value of Investment) x 100
Initial value of Investment

Admin Move time: As we know, the price of a stock changes with time. And at a particular time, all the users will be able to see the same price of the stock. So, here to simplify things, consider 10 timestamps.
Whenever time is moved to next discrete timestamp,
All stocks’ current prices will be updated by a random variable
(in the range: (-0.5 * price at previous timestamp) to (+0.5 * price at previous timestamp))

For example: If initial value of the stock is 100
t0 = 100
At t1 , value of stock = random(100-0.5*100, 100+0.5*100)
= random(50,150)
= 110
At t2, value of the stock = random (110-0.5*110, 110+0.5*110)
= random(55, 165)
= 90
Likewise this will be generated till t10.

Stock A: (with initial value 100)
Time
t0
t1
t2
t3
…...
…..
……
t9
Price
100
110
90
115
……
…..
…..
…..


Stock B: (with initial value 20)

Time
t0
t1
t2
t3
…...
…..
……
t9
Price
20
16
22
30
……
…..
…..
…..


Note: After 10 timestamps, the Market will be closed. Users can still view the portfolio.
Buy and sell operations won’t be possible.

Commands:
ADD_STOCKS(stockName, initial price)
CREATE_USER (username, initial wallet amount)
MOVE_TIME
LIST_ALL_MARKET_STOCK_PRICES
GET_STOCK_PRICE (stock name)
BUY_STOCK (username, stock name, quantity)
SELL_STOCK (username, stock name, quantity)
VIEW_PORTFOLIO (username)

Command:
ADD_STOCKS(stockA, 100)
ADD_STOCKS(stockB, 20)
ADD_STOCKS(stockC, 200)
ADD_STOCKS(stockD, 30)

CREATE_USER(Ross, 4000)
CREATE_USER(Monica, 2000)
CREATE_USER(Joey, 200)

LIST_ALL_MARKET_STOCK_PRICES() -> All stocks and their price at current timestamp to be listed.
Output:.
A 100
B 20
C 200
D 30

MOVE_TIME() : time will move by 1 unit, so, t1 is the current timestamp.

GET_STOCK_PRICE(StockA)
Output: 110 <Calculation as shown above>

BUY_STOCK(Ross, stockA, 5):< username, stock, quantity>
Ross has initial wallet balance as 4000
stockA current price = 110
Quantity: 5
Updated wallet balance = 4000 - 5*110 = 3450

BUY_STOCK(Joey, stockA, 5)
Output: Not possible

MOVE_TIME(): current timestamp: t2

VIEW_PORTFOLIO(Ross):
Output:
Wallet amount: 3450
Stocks: Stock A, quantity 5
Return rate = (90*5 - 110*5) x 100  = -18.18%
(110*5)

BUY_STOCK(Ross, stockB, 10) -> Updated wallet balance: 3450-10*22 = 3230

VIEW_PORTFOLIO(Joey):
Output:
Wallet amount: 200
Stocks: -
Return rate = 0%

MOVE_TIME: current timestamp: t3

SELL_STOCK(Ross, stockA, 10): Wallet amount: 3230 + (105*2) = 3440
Output: Not possible

SELL_STOCK(Ross, stockA, 2)

VIEW_PORTFOLIO(Ross):
Wallet amount: 3440
Stocks: Stock A, quantity 3
Stock B, quantity 10
Return rate =[ (115*3 - 110*3) + (30*10 - 22*10) ]  x 100 = 17.27%
(110*3 + 22*10)

Bonus Functionality:
Implement a functionality where the user can see complete transaction history.

Expectations:
Code should be demo-able (very important).
Code should be functionally correct and complete.
Code should be readable, modular, testable.
Create the sample data yourself. You can put it in a file, test case or main driver program itself.
Code should handle edge cases properly and fail gracefully. Add suitable exceptions.
Avoid writing monolithic code.
Don’t use any database, store all data in memory.

package com.flipkart;


import com.flipkart.service.StockService;
import com.flipkart.service.UserService;
import com.flipkart.utils.AppConstants;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StockService stockService = new StockService();
        UserService userService = new UserService();
        int maxTimeStamp = 10;
        int currentTimeStamp= 0;

        while (true){
            System.out.println("**Enter operation**");
            try{
                //String[] input = scanner.nextLine().split("\\(");
                AppConstants.Operation operation = AppConstants.Operation.valueOf(scanner.next());
                switch (operation){
                    case ADD_STOCKS:
                        //String[] argument = input[1].split(",");
                        System.out.println("Stock: ");
                        String stockName = scanner.next();
                        //String stockName = argument[0].trim();
                        System.out.println("Initial price: ");
                        Double initialPrice = Double.valueOf(scanner.next());
                        //Double initialPrice = Double.valueOf(argument[1].replaceAll("\\)", "").trim());
                        stockService.addStocks(stockName, initialPrice);
                        break;
                    case CREATE_USER:
                        //commandFactoryInstance.getCommandMap("CREATE_USER").execute();
                        System.out.println("Username: ");
                        String userName = scanner.next();
                        System.out.println("Initial wallet amount: ");
                        Double initialWalletAmount = Double.valueOf(scanner.next());
                        userService.createUser(userName, initialWalletAmount);
                        break;
                    case MOVE_TIME:
                        if(currentTimeStamp<maxTimeStamp){
                            currentTimeStamp+=1;
                            stockService.moveTime();
                            System.out.println("Current timestamp "+"t"+currentTimeStamp);
                        }
                        break;
                    case LIST_ALL_MARKET_STOCK_PRICES:
                        stockService.ListAllStockPrices();
                        break;
                    case GET_STOCK_PRICE:
                        System.out.println("StockName: ");
                        stockName = scanner.next();
                        stockService.getStockPrice(stockName);
                        break;
                    case BUY_STOCK:
                        if(currentTimeStamp<maxTimeStamp){
                            System.out.println("Username: ");
                            userName = scanner.next();
                            System.out.println("StockName: ");
                            stockName = scanner.next();
                            System.out.println("Quantity: ");
                            int quantity = Integer.parseInt(scanner.next());
                            stockService.BuyStock(userName, stockName, quantity);
                        }
                        else {
                            System.out.println("Not possible since market is closed");
                        }
                        break;
                    case SELL_STOCK:
                        if(currentTimeStamp<maxTimeStamp){
                            System.out.println("Username: ");
                            userName = scanner.next();
                            System.out.println("StockName: ");
                            stockName = scanner.next();
                            System.out.println("Quantity: ");
                            int quantity = Integer.parseInt(scanner.next());
                            stockService.SellStock(userName, stockName, quantity);
                        }
                        else {
                            System.out.println("Not possible since market is closed");
                        }
                        break;
                    case VIEW_PORTFOLIO:
                        System.out.println("Username: ");
                        userName = scanner.next();
                        stockService.viewPortfolio(userName);
                        break;
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("invalid command");
                return;
            }
        }
    }
}

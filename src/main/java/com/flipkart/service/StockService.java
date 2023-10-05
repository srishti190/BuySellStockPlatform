package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;
import com.flipkart.models.Stock;
import com.flipkart.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockService {
    public static List<Stock> stockList = new ArrayList<>();
    public static Map<String, Stock> stockMap = new HashMap<>();
    public static Map<String, List<Stock>> userStockMap = new HashMap<>();

    public void addStocks(String stockName, Double initialPrice){
        if(stockMap.containsKey(stockName)){
            System.out.println("stock " + stockName + "already added by the admin");
            return;
        }
        Stock stock = new Stock(stockName, initialPrice);
        stockList.add(stock);
        stockMap.put(stockName, stock);
        System.out.println("Stock successfully added");
    }

    public void moveTime(){
        for (Stock stock: stockList){
            Double stockPrice = stock.getLatestStockPrice();
            double minPrice = stockPrice - 0.5*stockPrice;
            double maxPrice = stockPrice + 0.5*stockPrice;
            Double updatedPrice = (Double) Math.floor(Math.random()*(maxPrice - minPrice + 1)+minPrice);
            stock.setLatestStockPrice(updatedPrice);
        }
    }

    public void ListAllStockPrices(){
        System.out.println("StockName " + "CurrentStockPrice ");
        for (Stock stock: stockList){
            System.out.println(stock.getStockName() + " " + stock.getLatestStockPrice());
        }
    }

    public void getStockPrice(String stockName){
        if(!stockMap.containsKey(stockName)){
            System.out.println("Stock " + stockName + " does not exist");
            return;
        }
        System.out.println(stockMap.get(stockName).getLatestStockPrice());
    }

    public void BuyStock(String userName, String stockName, int quantity) throws UserNotFoundException {
        User user = UserService.userMap.get(userName);
        if(user == null){
            throw new UserNotFoundException("user is not registered");
        }
        Double walletBalance = user.getLatestWalletAmount();
        System.out.println(userName + " has initial wallet balance as " + walletBalance);
        Stock stock = stockMap.get(stockName);
        Double stockCurrentPrice = stock.getLatestStockPrice();
        System.out.println(stockName+ " current price = " + stockCurrentPrice);
        System.out.println("quantity: "+ quantity);
        if(stockCurrentPrice*quantity > walletBalance){
            System.out.println("Stock purchase not possible");
            return;
        }
        Double updatedStockPrice = walletBalance - stockCurrentPrice*quantity;
        user.setLatestWalletAmount(updatedStockPrice);
        System.out.println("Updated Wallet balance "+ user.getLatestWalletAmount());
        List<Stock> stocks;
        if(!userStockMap.containsKey(userName)){
            stocks = new ArrayList<>();
        }
        else{
            stocks = userStockMap.get(userName);
        }
        int stockQuantity = stock.getStockQuantity() + quantity;
        stock.updateStockQuantity(stockQuantity);
        stocks.add(stock);
        userStockMap.put(userName, stocks);
    }

    public void SellStock(String userName, String stockName, int quantity){
        List<Stock> stocks = userStockMap.get(userName);
        boolean stockExistForUser = false;
        if(quantity > stockMap.get(stockName).getStockQuantity()){
            System.out.println("Not possible");
            return;
        }
        for (Stock stock: stocks){
            if(stock.getStockName().equals(stockName)){
                stock.updateStockQuantity(stock.getStockQuantity() - quantity);
                stockExistForUser = true;
                stocks.remove(stock);
                User user = UserService.getUserMap().get(userName);
                Double updatedUserBalance = user.getLatestWalletAmount() + quantity*stock.getLatestStockPrice();

                user.setLatestWalletAmount(updatedUserBalance);
                userStockMap.put(userName, stocks);
                break;
            }
        }
        if(!stockExistForUser){
            System.out.println("Not possible");
        }
    }

    public void viewPortfolio(String userName){
        List<Stock> userStocks = userStockMap.get(userName);
        User user = UserService.getUserMap().get(userName);
        System.out.println("Wallet amount "+ user.getLatestWalletAmount());

        System.out.println("Stocks: ");
        double finalInvestmentValue=0.0, initialInvestmentValue=0.0;
        for (Stock stock: userStocks){
            int stockQuantity = stock.getStockQuantity();
            System.out.println("Stocks "+ stock.getStockName() + "," + "quantity " + stockQuantity);
            finalInvestmentValue += stockQuantity*stock.getLatestStockPrice();
            initialInvestmentValue += stockQuantity*stock.getInitialStockPrice();
        }

        System.out.println("Return Rate: ");
        if(initialInvestmentValue>finalInvestmentValue){
            System.out.println(0 + "%");
            return;
        }
        double returnRate = (finalInvestmentValue - initialInvestmentValue)/initialInvestmentValue;
        System.out.println(returnRate);
    }
}

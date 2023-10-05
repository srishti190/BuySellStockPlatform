package com.flipkart.models;

public class Stock {
    private String stockName;
    private Double initialPrice;
    private Double latestPrice;
    private int stockQuantity;

    public Stock(String stockName, Double initialPrice) {
        this.stockName = stockName;
        this.initialPrice = initialPrice;
        this.latestPrice = initialPrice;
        this.stockQuantity = 0;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getInitialStockPrice() {
        return initialPrice;
    }


    public int getStockQuantity() {
        return stockQuantity;
    }

    public void updateStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getLatestStockPrice() {
        return latestPrice;
    }

    public void setLatestStockPrice(Double latestPrice) {
        this.latestPrice = latestPrice;
    }
}

package com.flipkart.models;

public class User {
    private String username;
    private Double initialWalletAmount;
    private Double latestWalletAmount;

    public User(String username, Double initialWalletAmount) {
        this.username = username;
        this.initialWalletAmount = initialWalletAmount;
        this.latestWalletAmount = initialWalletAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getInitialWalletAmount() {
        return initialWalletAmount;
    }

    public void setInitialWalletAmount(Double initialWalletAmount) {
        this.initialWalletAmount = initialWalletAmount;
    }

    public Double getLatestWalletAmount() {
        return latestWalletAmount;
    }

    public void setLatestWalletAmount(Double latestWalletAmount) {
        this.latestWalletAmount = latestWalletAmount;
    }
}

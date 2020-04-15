package com.example.currencyconverter;

public class CurrencyModel {
    String currencyName;
    int currencySymbol;
    double currencyRate;

    public CurrencyModel(String currencyName, int currencySymbol, double currencyRate) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(int currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }
}

package com.ainul.currencyconverter.models;

/**
 * Currency model with exchange rate per 1 EUR.
 */
public class Currency {
    private String code;
    private String name;
    private double exchangeRatePerEUR;

    public Currency(String code, String name, double exchangeRatePerEUR) {
        this.code = code;
        this.name = name;
        this.exchangeRatePerEUR = exchangeRatePerEUR;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExchangeRatePerEUR() {
        return exchangeRatePerEUR;
    }

    public void setExchangeRatePerEUR(double exchangeRatePerEUR) {
        this.exchangeRatePerEUR = exchangeRatePerEUR;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}

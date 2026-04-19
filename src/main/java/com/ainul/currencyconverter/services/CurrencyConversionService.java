package com.ainul.currencyconverter.services;

import com.ainul.currencyconverter.models.Currency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service for currency conversion operations
 */
public class CurrencyConversionService {
    private List<Currency> currencies;
    private Map<String, Currency> currencyMap;

    public CurrencyConversionService() {
        initializeCurrencies();
    }

    private void initializeCurrencies() {
        currencies = new ArrayList<>();
        currencyMap = new HashMap<>();

        // Initialize currencies with exchange rates per 1 EUR
        Currency[] currencyList = {new Currency("USD", "US dollar", 1.1797),
                new Currency("JPY", "Japanese yen", 187.72),
                new Currency("CZK", "Czech koruna", 24.317),
                new Currency("DKK", "Danish krone", 7.4734),
                new Currency("GBP", "Pound sterling", 0.87168),
                new Currency("HUF", "Hungarian forint", 362.70),
                new Currency("PLN", "Polish zloty", 4.2328),
                new Currency("RON", "Romanian leu", 5.0989),
                new Currency("SEK", "Swedish krona", 10.8030),
                new Currency("CHF", "Swiss franc", 0.9231),
                new Currency("ISK", "Icelandic krona", 144.00),
                new Currency("NOK", "Norwegian krone", 11.0170),
                new Currency("TRY", "Turkish lira", 52.9272),
                new Currency("AUD", "Australian dollar", 1.6438),
                new Currency("BRL", "Brazilian real", 5.8707),
                new Currency("CAD", "Canadian dollar", 1.6129),
                new Currency("CNY", "Chinese yuan renminbi", 8.0483),
                new Currency("HKD", "Hong Kong dollar", 9.2382),
                new Currency("IDR", "Indonesian rupiah", 20267.48),
                new Currency("INR", "Indian rupee", 109.5025),
                new Currency("BDT", "Bangladeshi taka", 145.00)};

        for (Currency currency : currencyList) {
            currencies.add(currency);
            currencyMap.put(currency.getCode(), currency);
        }
    }

    /**
     * Get all available currencies
     */
    public List<Currency> getAllCurrencies() {
        return new ArrayList<>(currencies);
    }

    /**
     * Get currency by code
     */
    public Currency getCurrencyByCode(String code) {
        return currencyMap.get(code);
    }

    /**
     * Convert amount from one currency to another
     */
    public double convert(double amount, String fromCode, String toCode) {
        Currency fromCurrency = getCurrencyByCode(fromCode);
        Currency toCurrency = getCurrencyByCode(toCode);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        // Convert to EUR first, then to target currency
        double amountInEUR = amount / fromCurrency.getExchangeRatePerEUR();
        return amountInEUR * toCurrency.getExchangeRatePerEUR();
    }

    /**
     * Get exchange rate between two currencies
     */
    public double getExchangeRate(String fromCode, String toCode) {
        return convert(1.0, fromCode, toCode);
    }
}

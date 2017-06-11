package com.davedaniels.j8ia.model;


import java.util.*;
import java.util.stream.Collectors;

public class Transaction {

    private int price = 0;

    private Currency currency = Currency.getInstance(Locale.US);

    public Transaction(int price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static Map<Currency, List<Transaction>> transactionsByCurrenciesOld(List<Transaction> transactions) {

        Map<Currency, List<Transaction>> tByCurr = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 1000) {
                Currency currency = transaction.getCurrency();
                List<Transaction> tForCurr = tByCurr.get(currency);
                if (tForCurr == null) {
                    tForCurr = new ArrayList<>();
                    tByCurr.put(currency, tForCurr);
                }
                tForCurr.add(transaction);
            }
        }

        return tByCurr;
    }

    public static Map<Currency, List<Transaction>> transactionsByCurrencies(List<Transaction> transactions) {
        return transactions.stream().filter(t -> t.getPrice() > 1000)
                .collect(Collectors.groupingBy(Transaction::getCurrency));
    }
}

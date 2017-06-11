package com.davedaniels.j8ia.model;

import com.google.common.truth.Truth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

@RunWith(JUnit4.class)
public class TransactionTest {

    @Test
    public void transactionsByCurrencies() throws Exception {

        Transaction t1 = new Transaction(1001, Currency.getInstance(Locale.US));
        Transaction t2 = new Transaction(1001, Currency.getInstance(Locale.US));
        Transaction t3 = new Transaction(1001, Currency.getInstance(Locale.FRANCE));
        List<Transaction> transactions = Arrays.asList(t1, t2, t3);

        Map<Currency, List<Transaction>> actualOld = Transaction.transactionsByCurrenciesOld(transactions);
        Map<Currency, List<Transaction>> actual = Transaction.transactionsByCurrencies(transactions);

        Map<Currency, List<Transaction>> expected = new HashMap<>();
        expected.put(Currency.getInstance(Locale.US), Arrays.asList(t1, t2));
        expected.put(Currency.getInstance(Locale.FRANCE), Arrays.asList(t3));

        Truth.assertThat(expected).isEqualTo(actual);
        Truth.assertThat(expected).isEqualTo(actualOld);
    }

}
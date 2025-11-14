package Problems.MEDIUM.DigitalWalletSystem.Service;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CurrencyConverter {
    private static Map<Currency, Double> exchangeRates = new ConcurrentHashMap<>();

   static {
        exchangeRates.put(Currency.USD, 1.0);
        exchangeRates.put(Currency.EUR, 0.85);
        exchangeRates.put(Currency.GBP, 0.72);
        exchangeRates.put(Currency.JPY, 110.0);
    }

    public static double convert(double amount, Currency src, Currency dest){
        return (amount*exchangeRates.get(dest))/exchangeRates.get(src);
    }
}

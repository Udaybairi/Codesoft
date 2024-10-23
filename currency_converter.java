import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    private static HashMap<String, Double> getExchangeRates(String baseCurrency) {
        HashMap<String, Double> exchangeRates = new HashMap<>();
        switch (baseCurrency) {
            case "USD":
                exchangeRates.put("INR", 83.00);
                exchangeRates.put("EUR", 0.95);
                exchangeRates.put("GBP", 0.82);
                exchangeRates.put("JPY", 148.50);
                exchangeRates.put("AUD", 1.60);
                break;
            case "EUR":
                exchangeRates.put("USD", 1.05);
                exchangeRates.put("INR", 88.00);
                exchangeRates.put("GBP", 0.86);
                exchangeRates.put("JPY", 155.00);
                exchangeRates.put("AUD", 1.68);
                break;
            case "INR":
                exchangeRates.put("USD", 0.012);
                exchangeRates.put("EUR", 0.011);
                exchangeRates.put("GBP", 0.0099);
                exchangeRates.put("JPY", 1.80);
                exchangeRates.put("AUD", 0.019);
                break;
            default:
                System.out.println("Exchange rates for " + baseCurrency + " are not available.");
        }
        return exchangeRates;
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base currency (e.g., USD, EUR, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency (e.g., INR, EUR, USD): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        HashMap<String, Double> exchangeRates = getExchangeRates(baseCurrency);

        if (exchangeRates.containsKey(targetCurrency)) {
            double exchangeRate = exchangeRates.get(targetCurrency);
            double convertedAmount = convertCurrency(amount, exchangeRate);
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Conversion rate for " + targetCurrency + " is not available.");
        }

        scanner.close();
    }
}


public class PriceMetrics {
    
    private double minPrice;
    private double maxPrice;
    private double sumPrices;
    private double avgPrice;
    private int numPrices;
    
    PriceMetrics() {
        minPrice = Double.POSITIVE_INFINITY;
        maxPrice = Double.NEGATIVE_INFINITY;
        sumPrices = 0.0;
        avgPrice = 0.0;
        numPrices = 0;
    }

    public void addPrice(double price) {
        if (price < minPrice) minPrice = price;
        if (price > maxPrice) maxPrice = price;
        sumPrices += price;
        numPrices++;
        avgPrice = sumPrices / numPrices;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public double getAveragePrice() {
        return avgPrice;
    }

    public boolean isEmpty() {
        if (numPrices == 0) return true;
        return false;
    }

    public String toString() {
        String metricString = "Min: " + minPrice + ", Max: " + maxPrice + ", Mean: " + avgPrice;
        return metricString;
    }
}

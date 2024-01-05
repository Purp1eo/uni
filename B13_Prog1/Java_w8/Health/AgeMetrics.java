public class AgeMetrics {

    private double minAge;
    private double maxAge;
    private double sumAges;
    private double avgAge;
    private int numAges;

    AgeMetrics() {        
        minAge = Double.POSITIVE_INFINITY;
        maxAge = Double.NEGATIVE_INFINITY;
        sumAges = 0.0;
        avgAge = 0.0;
        numAges = 0;
    }

    public void addAge(double age) {
        if (age < minAge) minAge = age;
        if (age > maxAge) maxAge = age;
        sumAges += age;
        numAges++;
        avgAge = sumAges / numAges;
    }

    public double getMinAge() {
        return minAge;
    }

    public double getMaxAge() {
        return maxAge;
    }

    public double getAverageAge() {
        return avgAge;
    }

    public boolean isEmpty() {
        if (numAges == 0) return true;
        return false;
    }

    public String toString() {
        String metricString = "Min: " + minAge + ", Max: " + maxAge + ", Mean: " + avgAge;
        return metricString;
    }
}

public class AgeMetrics {

    private double minAge;
    private double maxAge;
    private double sumAges;
    private double avgAge;
    private int numAges;

    AgeMetrics() {        
        minAge = 1.0;
        maxAge = 1.0;
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
        String avgAgeRounded = String.format("%.2f", avgAge);

        String metricString = "Min: " + (int)minAge + ", Max: " + (int)maxAge + ", Mean: " + avgAgeRounded;
        return metricString;
    }
}

public class harmony {
    public static double getHarmonicSeriesAt(int n) {
        if (n <= 0) return 0.0;

        double sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += 1.0/i;
        }
        return sum;
    }

    public static void printHarmonicSeriesFormula(int n) {
        StringBuilder fractions = new StringBuilder("1");
        
        if (n <= 0) {}
        else if (n == 1) System.out.println(fractions);
        else {
            for(int i = 2; i <= n; i++) {
                fractions.append(" + (1/").append(i).append(")");
                if (i % 10 == 0) fractions.append("\n");
            }
            fractions.append(" = ").append(getHarmonicSeriesAt(n));
            System.out.println(fractions);
        }
    }

    public static void main(String[] args) {
            printHarmonicSeriesFormula(13);
    }
}
public class harmony {
    static double getHarmonicSeriesAt(int n) {
        double sum = 1;
        for(int i = 1; i <= n; i++) {
            sum += 1.0/i;
        }
        return sum-1;
    }

    static String printHarmonicSeriesFormula(int n) {
        StringBuilder fractions = new StringBuilder("1");
        if (n == 0) return "0";
        for(int i = 2; i <= n; i++) {
            fractions.append(" + (1/").append(i).append(")");
            if (i % 10 == 0) fractions.append("\n");
        }
        fractions.append(" = ").append(getHarmonicSeriesAt(n));
        return fractions.toString();
    }

    public static void main(String[] args) {
        System.out.println(printHarmonicSeriesFormula(35));
    }
}
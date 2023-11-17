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
        
        /////////////////////////////////////////////////////////////////////// using a StringBuilder
        
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

        /////////////////////////////////////////////////////////////////////// using a normal String
        
        /* if (n <= 0) {}
        else if (n == 1) System.out.println(1);
        else {
            System.out.print(1 + " ");
            for (int i = 2; i <= n; i++) {
                System.out.print("+ (1/"+ i + ") ");
                if (i % 10 == 0) System.out.print("\n");
            }
            System.out.println("= " + getHarmonicSeriesAt(n));
        } */

        /////////////////////////////////////////////////////////////////////// using Daniel's Code TM
        
        /* if (n <= 0) {
            System.out.print("");
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 10 == 0) {
                    System.out.print(" + (1/" + i + ")");
                    System.out.print("\n");
                } else if (i == n && i > 1) {
                    System.out.print(" + " + "(1/" + i + ") = " + getHarmonicSeriesAt(n));
                } else if (i == 1) {
                    System.out.print(1);
                } else {
                    System.out.print(" + " + "(1/" + i + ")");
                }
            }
        } */
    }

    public static void main(String[] args) {
            printHarmonicSeriesFormula(15);
    }
}
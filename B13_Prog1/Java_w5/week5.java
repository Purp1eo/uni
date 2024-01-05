public class week5 {
    public static int compare(int x, int y) {
        if (x < y) return -1;
        else if (x > y) return 1;
        else return 0;
    }
    public static boolean isSafe(int a, int b, char operation) {
        if (operation != 'a' && operation != 's' || ((long)java.lang.Math.abs(a) + (long)java.lang.Math.abs(b)) > Integer.MAX_VALUE) return false;
        return true;
    }
    public static boolean isPrime(int val) {
        if (val <= 1) return false;
        else if (val <= 3) return true;
        else if (val % 2 == 0 || val % 3 == 0) return false;
        for (int i = 5; i * i <= val; i += 6) if (val % i == 0) return false;
        for (int i = 7; i * i <= val; i += 6) if (val % i == 0) return false;
        return true;
    }
    public static int countPrimes(int from, int to) {
        int counter = 0;
        for(int i = from; i <= to; i++) {
            if (isPrime(i)) counter++;
        }
        return counter;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            //System.out.println(i + " is a prime number: " + isPrime(i));
            System.out.println(countPrimes(0, i));
        }
    }
}
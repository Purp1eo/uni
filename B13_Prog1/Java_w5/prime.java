public class prime {
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
            System.out.println(i + " is prime: " + isPrime(i));
        }
    }
}

// 2--1-1-3-1-3-        0-17
// 1-3-5-1-5-3-         18+
// 6n+-1
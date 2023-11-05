public class fibonacciStage {
    public static int fibonacci(int f) {
        int a = 0, b = 1, c = 1;
        if (f < 1) return a;

        for(int i = 1; i<f; i++) {
            if (((long)a + (long)b) > Integer.MAX_VALUE) {
                return -1;
            }
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String args[]) {
        for (int i = 1; i < 50; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
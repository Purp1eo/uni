public class fibonacciStage {
    public static int fibonacci(int f) {
        int a = 0, b = 1, c = 1;
        if (f < 1) return a;

        for(int i = 1; i<f; i++) {
            c = a + b;
            a = b;
            b = c;
            if (c < 0) {
                return -1;
            }
        }
        return c;
    }
    public static void main(String args[]) {
        for (int i = 1; i < 50; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
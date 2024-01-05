public class week4 {
    public static int getMax(int a, int b, int c) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        return max;
    }
    public static char uppercaseChar(char x) {
        if (Character.isLetter(x) == true)  return Character.toUpperCase(x);
        else return (char) 0;
    }
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
    public static void main(String[] args) {
        for(int i = 1; i < 50; i++) {
            System.out.println(fibonacci(i));
        }
    }
}

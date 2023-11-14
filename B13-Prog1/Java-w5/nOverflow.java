public class nOverflow {
    public static boolean isSafe(int a, int b, char operation) {

        long sum;
        if (operation == 'a') {
            sum = (long)a + (long)b;
            if (sum < Integer.MAX_VALUE) {
                return true;
            }
        }

        if (operation == 's') {
            sum = (long)a - (long)b;
            if (sum < Integer.MAX_VALUE) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isSafe(1000000000, -1200000000, 'a'));
    }
}
public class threeRows {
    public static int getMax(int a, int b, int c) {
            
        int max = a;

        if (max<b) {
            max = b;
        }
        if (max<c) {
            max = c;
        }

        return max;
    }
    public static void main(String[] args) {

        System.out.print(getMax(6, 3, 2));

    }
    
}

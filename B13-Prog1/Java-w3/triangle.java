public class triangle {
    public static void main(String[] args) {
        int e = 6;
        int a = 7;
        for (int i = 1; i <= 28; i++) {
            System.out.print((i > 13 && i < 19 ? '.' : '*'));
            if (i == a) {
                System.out.print("\n");
                a += e;
                e--;
            }
        }
    }
}
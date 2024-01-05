public class asterisk {
    public static void main(String[] args) {
        for (int i = 1; i <= 28; i++) {
            if (i <= 14) System.out.print((i > 7 ? '.' : '*'));
            else if (i >= 14) System.out.print((i > 21 ? '.' : '*'));
            if (i % 7 == 0) System.out.print("\n");
        }
    }
}


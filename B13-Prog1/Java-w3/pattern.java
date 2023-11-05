public class pattern {
    public static void main(String[] args) {             
        for(int i = 1; i <= 81; i++) System.out.print((i % 2 == 0 ? '.' : '*') + (i % 9 == 0 ? "\n" : ""));
    }
}
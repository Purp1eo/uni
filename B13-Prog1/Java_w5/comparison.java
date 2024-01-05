public class comparison {
    public static int compare(int x, int y) {
        if (x < y) return -1;
        else if (x > y) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            System.out.println(compare(i, 10-i));
        }
    }
}
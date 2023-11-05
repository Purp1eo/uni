public class pyramid {
    public static void main(String[] args) {
        int a = 1; 
        for (int i = 1; i <= 9; i++) {

            for (int e = 1; e <= a; e++) System.out.print("*");            
            if (i <= 4) a++;
            else if (i > 4) a--;
            
            System.out.print("\n");    
        }
    }
}
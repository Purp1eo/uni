public class uppercase {
    public static int uppercaseChar(char x) {
        if (Character.isLetter(x) == true) return Character.toUpperCase(x);
        else return (char) 0;
    }
    public static void main(String[] args) {
        System.out.println(uppercaseChar('@'));
    }
}
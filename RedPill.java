public class RedPill {

    public static void matrixTyping(String phrase) {
        StringBuilder phraseBuilder = new StringBuilder("");
        char symbol = ' ';

        for (int i = 0; i <= phrase.length() - 1; i++) {
            symbol = ' ';
            for (int j = 0; j <= 95; j++) {
                System.out.println("\033[H\033[2J");
                System.out.print(phraseBuilder);
                System.out.println(symbol);
                if (phrase.charAt(i) == symbol) break;
                symbol++;
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            phraseBuilder.append(symbol);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        matrixTyping("Example text.");
    }
}
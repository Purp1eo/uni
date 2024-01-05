public class Zusatz {
    public static int countBases(char[] sequence, char toFind) {

        int count = 0;
        for (char element : sequence) if (element == toFind) count++;

        return count;
    }

    public static int countPurines(char[] sequence) {
        return countBases(sequence, 'A') + countBases(sequence, 'G');
    }

    public static int countPyrimidines(char[] sequence) {
        return countBases(sequence, 'C') + countBases(sequence, 'T');
    }

    public static int[] countBases(char[] sequence) {
        int[] baseCount = new int[4];
        for (char element : sequence) {
            switch (element) {
                case 'A':
                    baseCount[0]++;
                    break;
                case 'C':
                    baseCount[1]++;
                    break;
                case 'G':
                    baseCount[2]++;
                    break;
                case 'T':
                    baseCount[3]++;
                    break;
            }
        }
        return baseCount;
    }

    public static char[] complementSequence(char[] sequence) {
        char[] complement = new char[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            switch (sequence[i]) {
                case 'A':
                    complement[i] = 'T';
                    break;
                case 'C':
                    complement[i] = 'G';
                    break;
                case 'G':
                    complement[i] = 'C';
                    break;
                case 'T':
                    complement[i] = 'A';
                    break;
            }
        }
        return complement;
    }

    public static char[] reverseSequence(char[] sequence) {
        char[] reverse = new char[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            reverse[i] = sequence[sequence.length - i - 1];
        }
        return reverse;
    }

    public static char[] reverseComplementSequence(char[] sequence) {
        return reverseSequence(complementSequence(sequence));
    }

    public static void main(String[] args) {
        char[] sequence = {'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
        System.out.println(java.util.Arrays.toString(sequence));
        System.out.println("Number of Purines: " + countPurines(sequence));
        System.out.println("Number of Pyrimidines: " + countPyrimidines(sequence));
        System.out.println("Number of Bases: " + java.util.Arrays.toString(countBases(sequence)));
        System.out.println("Complement: " + java.util.Arrays.toString(complementSequence(sequence)));
        System.out.println("Reverse: " + java.util.Arrays.toString(reverseSequence(sequence)));
        System.out.println("Reverse Complement: " + java.util.Arrays.toString(reverseComplementSequence(sequence)));
    }
}

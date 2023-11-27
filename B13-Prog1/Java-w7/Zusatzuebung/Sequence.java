public class Sequence {
    char[] sequence;
    
    public Sequence(char[] seq) {
        this.sequence = seq;
    }

    public int getLength() {
        return this.sequence.length;
    }

    public int getNumPyrimidines() {
        return Zusatz.countBases(sequence, 'C') + Zusatz.countBases(sequence, 'T');
    }

    public int getNumPurines() {
        return Zusatz.countBases(sequence, 'A') + Zusatz.countBases(sequence, 'G');
    }

    public Sequence reverseComplement() {
        return new Sequence(Zusatz.complementSequence(Zusatz.reverseSequence(this.sequence)));
    }

    public static void main(String[] args) {
        char[] seq = {'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
        Sequence DNASample = new Sequence(seq);
        System.out.println(DNASample.getLength());
        System.out.println(DNASample.getNumPyrimidines());
        System.out.println(DNASample.getNumPurines());
        System.out.println(DNASample.reverseComplement().sequence);
    }
}

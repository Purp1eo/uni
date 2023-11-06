public class Patient {

    private char status;
    private double age;

    Patient(char status, double age) {
        this.status = status;
        this.age = age;
    }

    public char getStatus() {
        return status;
    }

    public double getAge() {
        return age;
    }
}

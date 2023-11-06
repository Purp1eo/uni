public class Patient {

    char status;
    double age;

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

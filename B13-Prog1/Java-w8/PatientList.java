import java.util.ArrayList;
import java.util.List;

public class PatientList {

    private List<Patient> patients;

    PatientList() {
        patients = new ArrayList<>();
    }

    void addPatient(Patient p) {
        patients.add(p);
    }

    int getNumPatients() {
        return patients.size();
    }

    public AgeMetrics getAgeMetrics() {
        
        AgeMetrics data = new AgeMetrics();


        
        return data;
    }

    public PatientList filterByStatus(char status) {
        return null;
    }
}

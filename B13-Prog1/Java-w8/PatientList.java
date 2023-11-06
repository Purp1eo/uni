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
        AgeMetrics patientMetrics= new AgeMetrics();
        
        for (Patient element : patients) {
            patientMetrics.addAge(element.getAge());
        }
        
        return patientMetrics;
    }

    public PatientList filterByStatus(char status) {
        return null;
    }
}

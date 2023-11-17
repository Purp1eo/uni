import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientList {

    private List<Patient> patients;
    
    PatientList() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void addFromCSVFile(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                Patient person = Patient.parseCSVLine(line);
                addPatient(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumPatients() {
        return patients.size();
    }

    public PatientList filterByFromAge(int minfromage, int maxfromage) {
        
        PatientList filteredPatients = new PatientList();
        for (Patient person : patients) {
            if (person.getFromAge() > minfromage && person.getFromAge() < maxfromage) filteredPatients.addPatient(person);
        }

        return filteredPatients;
    }

    public PatientList filterByToAge(int mintoage, int maxtoage) {

        PatientList filteredPatients = new PatientList();
        for (Patient person : patients) {
            if (person.getToAge() > mintoage && person.getToAge() < maxtoage) filteredPatients.addPatient(person);
        }
        
        return filteredPatients;
    }

    public PatientList filterBySex(String sex) {

        PatientList filteredPatients = new PatientList();
        for (Patient person : patients) {
            if (person.getSex().equals(sex)) filteredPatients.addPatient(person);
        }
        
        return filteredPatients;
    }

    public PatientList filterByYear(int year) {

        PatientList filteredPatients = new PatientList();
        for (Patient person : patients) {
            if (person.getYear() == year) filteredPatients.addPatient(person);
        }
        
        return filteredPatients;
    }

    public PatientList filterByMonth(int month) {

        PatientList filteredPatients = new PatientList();
        for (Patient person : patients) {
            if (person.getMonth() == month) filteredPatients.addPatient(person);
        }
        
        return filteredPatients;
    }

    public PatientList filterByDay(int day) {

        PatientList filteredPatients = new PatientList();
        for (Patient person : patients) {
            if (person.getDay() == day) filteredPatients.addPatient(person);
        }
        
        return filteredPatients;
    }
}

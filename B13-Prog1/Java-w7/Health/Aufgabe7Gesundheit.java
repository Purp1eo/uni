import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aufgabe7Gesundheit {
    
    // outputs the youngest, the oldest, and the mean patient age from a Patient[] array
    public static double[] ageMetrics(Patient[] patients) {

        double min = patients[0].age;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].age < min) min = patients[i].age;
        }

        double max = patients[0].age;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].age > max) max = patients[i].age;
        }

        double Sum = 0;
        for (Patient element : patients) {
            Sum += element.age;
        }

        double[] patientsAgeMetrics = new double[3];
        patientsAgeMetrics[0] = min;
        patientsAgeMetrics[1] = max;
        patientsAgeMetrics[2] = Sum/patients.length;

        return patientsAgeMetrics;
    }

    // outputs a new Patient[] array patients containing a specific status
    public static Patient[] filterByStatus(Patient[] patients, char status) {

        List<Patient>  patientStatusList = new ArrayList<>();
        
        for (Patient element : patients) {
            if (element.status == status) {
                patientStatusList.add(element);
            }
        }

        Patient[] patientStatusArray = new Patient[patientStatusList.size()];

        for (int i = 0; i < patientStatusList.size(); i++) {
            patientStatusArray[i] = patientStatusList.get(i);
        }

        return patientStatusArray;
    }

    // puts two arrays of status and age together into a new Patient[] array, making objects at indexes with coresponding status/age
    public static Patient[] createPatients(char[] stati, double[] ages) {
        
        List<Patient> newPatientsList = new ArrayList<>();

        for (int i = 0; i < stati.length; i++) {
            newPatientsList.add(new Patient(stati[i], ages[i]));
        }
        
        Patient[] newPatientsArray = new Patient[newPatientsList.size()];

        for (int i = 0; i < newPatientsList.size(); i++) {
            newPatientsArray[i] = newPatientsList.get(i);
        }

        return newPatientsArray;
    }

    public static String[] showMetrics(Patient[] patients) {
        
    // 1. uses filterByStatus to separate Patient[] patients into two arrays;
    //    one for recovered ones, and one for deceased ones
    //
    // 2. takes both Patient[] arrays,
    //    puts the smallest, biggest, and mean value of patients.ages
    //    into two Strings for outputting data from recovered and deceased
    //    patients respectively
    //     
    //                                                                 1.
    /////////////////////////////////////////////////////////////////////

        Patient[] recoveredPatients = new Patient[filterByStatus(patients, 'r').length];
        for (int i = 0; i < recoveredPatients.length; i++) {
            recoveredPatients[i] = filterByStatus(patients, 'r')[i];
        }

        Patient[] deceasedPatients = new Patient[filterByStatus(patients, 'd').length];
        for (int i = 0; i < deceasedPatients.length; i++) {
            deceasedPatients[i] = filterByStatus(patients, 'd')[i];
        }

    //                                                                 2.
    /////////////////////////////////////////////////////////////////////

        Arrays.sort(recoveredPatients, Comparator.comparingDouble(recPat -> recPat.age));
        Arrays.sort(deceasedPatients, Comparator.comparingDouble(decPat -> decPat.age));

        double rSum = 0;
        for (Patient element : recoveredPatients) {
            rSum += element.age;
        }

        double dSum = 0;
        for (Patient element : deceasedPatients) {
            dSum += element.age;
        }

        double[] recoveredPatientsMetrics = new double[3];
        recoveredPatientsMetrics[0] = recoveredPatients[0].age;
        recoveredPatientsMetrics[1] = recoveredPatients[recoveredPatients.length - 1].age;
        recoveredPatientsMetrics[2] = rSum/recoveredPatients.length;

        double[] deceasedPatientsMetrics = new double[3];
        deceasedPatientsMetrics[0] = deceasedPatients[0].age;
        deceasedPatientsMetrics[1] = deceasedPatients[deceasedPatients.length - 1].age;
        deceasedPatientsMetrics[2] = dSum/deceasedPatients.length;

        String recMeanRound = String.format("%.2f", recoveredPatientsMetrics[2]);
        String decMeanRound = String.format("%.2f", deceasedPatientsMetrics[2]);

        String recoveredData = "Genesen - Min: " + (int)recoveredPatientsMetrics[0] + ", Max: " + (int)recoveredPatientsMetrics[1] + ", Mean: " + recMeanRound;
        String deceasedData = "\nVerstorben - Min: " + (int)deceasedPatientsMetrics[0] + ", Max: " + (int)deceasedPatientsMetrics[1] + ", Mean: " + decMeanRound;

        String[] patientsData = new String[2];
        patientsData[0] = recoveredData;
        patientsData[1] = deceasedData;
        
        return patientsData;
    }

    public static void main(String[] args) {
        double[] ages = {20, 45, 69, 70, 45, 16, 59, 45, 24, 54};
        char[] stati = {'r', 'r', 'd', 'r', 'd', 'r', 'r', 'd', 'd', 'd'};

        Patient Patrick = new Patient('d', 62);
        Patient Egenolf = new Patient('r', 4);
        Patient SusyBecker = new Patient('r', 52);
        Patient Marco = new Patient('d', 25);
        Patient Roberto = new Patient('r', 12);
        
        Patient[] people = {Patrick, Egenolf, SusyBecker, Marco, Roberto};

        System.out.println(Arrays.toString(ageMetrics(createPatients(stati, ages))));       // tests if ageMetrics and createPatients work

        System.out.println(Arrays.toString(showMetrics(people)));                           // tests if showMetrics (and filterByStatus, since it is used in showMetrics) work
    }
}
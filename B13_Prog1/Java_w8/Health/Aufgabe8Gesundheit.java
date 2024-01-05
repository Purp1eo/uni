public class Aufgabe8Gesundheit {

    public static String[] showMetrics(PatientList patients) {
        String[] patientMetrics = new String[2];

        PatientList recoveredPatientList = patients.filterByStatus('r');
        PatientList deceasedPatientList = patients.filterByStatus('d');

        AgeMetrics recoveredPatientAgeMetrics = recoveredPatientList.getAgeMetrics();
        AgeMetrics deceasedPatientAgeMetrics = deceasedPatientList.getAgeMetrics();

        String recoveredResult = "\nGenesen - " + recoveredPatientAgeMetrics.toString();
        String deceasedResult = "\nVerstorben - " + deceasedPatientAgeMetrics.toString() + "\n";

        patientMetrics[0] = recoveredResult;
        patientMetrics[1] = deceasedResult;

        return patientMetrics;
    }
}

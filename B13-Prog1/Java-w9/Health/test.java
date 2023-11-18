import java.util.ArrayList;
import java.util.List;

public class test {
    public static int[] monthlyInfections(PatientList pl, int fromYear, int toYear, int fromMonth, int toMonth) {

        List<Integer> numberOfInfections = new ArrayList<>();
        int endMonth = 12;

        for (int i = fromYear; i <= toYear; i++) {

            PatientList filteredPatientsByYear = pl.filterByYear(i);

            for (int j = fromMonth; j <= endMonth; j++) {
                
                if (i == toYear) endMonth = toMonth;
                
                numberOfInfections.add(filteredPatientsByYear.filterByMonth(j).getNumPatients());

                fromMonth = 1;
            }

            i++;
        }

        int[] InfectionsInTimeSpan = new int[numberOfInfections.size()];
        
        for (int i = 0; i < numberOfInfections.size(); i++) {
            InfectionsInTimeSpan[i] = numberOfInfections.get(i);
        }

        return InfectionsInTimeSpan;
    }
    public static void main(String[] args) {
        PatientList testSubjects = new PatientList();

        testSubjects.addFromCSVFile("C:/Users/aatan/OneDrive/Documents/Berlin.csv");

        System.out.println(testSubjects.getNumPatients());
    }
}

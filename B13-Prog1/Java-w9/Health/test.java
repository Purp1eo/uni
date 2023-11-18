import java.util.ArrayList;
import java.util.List;

public class test {
    public static int[] monthlyInfections(PatientList pl, int fromYear, int toYear, int fromMonth, int toMonth) {

        int numMonths = ((toYear - fromYear) * 12) + (toMonth - fromMonth) + 1;
        int[] infectionsPerMonth = new int[numMonths];

        int index = 0;
        for (int year = fromYear; year <= toYear; year++) {
            int startMonth = (year == fromYear) ? fromMonth : 1;
            int endMonth = (year == toYear) ? toMonth : 12;

            for (int month = startMonth; month <= endMonth; month++) {
                PatientList filteredByYearAndMonth = pl.filterByYear(year).filterByMonth(month);
                int infections = filteredByYearAndMonth.getNumPatients();
                infectionsPerMonth[index++] = infections;
            }
        }

        return infectionsPerMonth;
    }
    public static void main(String[] args) {
        PatientList testSubjects = new PatientList();

        testSubjects.addFromCSVFile("C:/Users/aatan/OneDrive/Documents/Berlin.csv");

        System.out.println(testSubjects.getNumPatients());
    }
}

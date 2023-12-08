import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        String csvFile = "Berlin.csv";
        String line = "";
        String csvSplitBy = ",";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

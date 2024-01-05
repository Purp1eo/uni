import java.util.ArrayList;
import java.util.List;

public class test {
    public static int[] dailyInfections(PatientList pl, int fromYear, int toYear, int fromDay, int toDay, boolean cumulative) {
        
        List<Integer> dailyInfectionsList = new ArrayList<>();
        
        int amount = 0;

        for (int year = fromYear; year <= toYear; year++) {
            int startDay = (year == fromYear) ? fromDay : 1;
            int endDay = (DateUtilities.isLeapYear(year)) ? (year == toYear) ? toDay : 366 : (year == toYear) ? toDay : 365;

            for (int day = startDay; day <= endDay; day++) {
                PatientList filteredByYearAndDay = pl.filterByYear(year).filterByDayOfYear(day);
                int infections = filteredByYearAndDay.getNumPatients();
                
                if (cumulative) {
                    amount += infections;
                    dailyInfectionsList.add(amount);
                } else {
                    dailyInfectionsList.add(infections);
                }
            }
        }

        int[] dailyInfections = new int[dailyInfectionsList.size()];
        for (int i = 0; i < dailyInfectionsList.size(); i++) {
            dailyInfections[i] = dailyInfectionsList.get(i);
        }

        return dailyInfections;
    }

    public static void main(String[] args) {
        PatientList pl = new PatientList();
        pl.addFromCSVFile("C:/Users/aatan/OneDrive/Documents/uni/Additional-Files/Berlin.csv");
        int[] dailyInfections = dailyInfections(pl, 2019, 2023, 333, 2, true);
        for (int i = 0; i < dailyInfections.length; i++) {
            System.out.println(dailyInfections[i]);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class test {
    public static int[] dailyInfections(PatientList pl, int fromYear, int toYear, int fromDay, int toDay, boolean cumulative) {
        
        List<Integer> dailyInfectionsList = new ArrayList<>();
        
        int index = 0;
        for (int year = fromYear; year <= toYear; year++) {
            int startDay = (year == fromYear) ? fromDay : 1;
            int endDay;
            if (DateUtilities.isLeapYear(year)) {
                endDay = (year == toYear) ? toDay : 366;
            } else {
                endDay = (year == toYear) ? toDay : 365;
            }
            
            for (int day = startDay; day <= endDay; day++) {
                PatientList filteredByYearAndDay = pl.filterByYear(year).filterByDayOfYear(day);
                int infections = filteredByYearAndDay.getNumPatients();
                if (cumulative) {
                    if (index == 0) {
                        dailyInfectionsList.add(infections);
                    } else {
                        dailyInfectionsList.add(dailyInfectionsList.get(index - 1) + infections);
                    }
                } else {
                    dailyInfectionsList.add(infections);
                }
                index++;
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
        pl.addFromCSVFile("data/health.csv");
        int[] dailyInfections = dailyInfections(pl, 2019, 2023, 29, 145, false);
        for (int i = 0; i < dailyInfections.length; i++) {
            System.out.println(dailyInfections[i]);
        }
    }
}

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
        PatientList pl = new PatientList();
        pl.addFromCSVFile("C:/Users/aatan/OneDrive/Documents/uni/Additional-Files/Berlin.csv");
        int[] infectionsPerMonth = monthlyInfections(pl, 2019, 2023, 5, 10);
        for (int i = 0; i < infectionsPerMonth.length; i++) {
            System.out.println(infectionsPerMonth[i]);
        }
    }
}

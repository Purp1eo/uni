public class test {
    public static int[] monthlySales(ArtAuctionList pl, int fromYear, int toYear, int fromMonth, int toMonth) {

        int numMonths = ((toYear - fromYear) * 12) + (toMonth - fromMonth) + 1;
        int[] salesPerMonth = new int[numMonths];

        int index = 0;
        for (int year = fromYear; year <= toYear; year++) {
            int startMonth = (year == fromYear) ? fromMonth : 1;
            int endMonth = (year == toYear) ? toMonth : 12;

            for (int month = startMonth; month <= endMonth; month++) {
                ArtAuctionList filteredByYearAndMonth = pl.filterByYear(year).filterByMonth(month);
                int sales = filteredByYearAndMonth.getTotalSales();
                salesPerMonth[index++] = sales;
            }
        }

        return salesPerMonth;
    }
    public static void main(String[] args) {

    }
}
public class ArtAuction {
    private int lots;
    private double sale;
    private int day;
    private int month;
    private int year;

    private ArtAuction() {}

    public static ArtAuction parseCSVLine(String line) {
        String fileDelimiter = ",";
        ArtAuction event = new ArtAuction();

        String[] attributes = line.split(fileDelimiter);

        String dateOfAuction = attributes[0];
        String[] auctionDates = dateOfAuction.split("-");
        
        event.day = Integer.parseInt(auctionDates[0]);
        event.month = Integer.parseInt(auctionDates[1]);
        event.year = Integer.parseInt(auctionDates[2]);
        event.lots = (attributes[1].equals("NA")) ? -1 : Integer.parseInt(attributes[1]);
        event.sale = (attributes[2].equals("NA")) ? -1 : Integer.parseInt(attributes[2]);

        return event;
    }

    public int getLots() {
        return lots;
    }

    public double getSale() {
        return sale;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}

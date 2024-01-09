import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ArtAuctionList {

    private List<ArtAuction> auctions;

    ArtAuctionList() {
        auctions = new ArrayList<>();
    }

    public void addAuction(ArtAuction a) {
        auctions.add(a);
    }

    public void addFromCSVFile(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                addAuction(ArtAuction.parseCSVLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumAuctions() {
        return auctions.size();
    }

    public int getTotalSales() {
        double totalSales = 0;

        for (ArtAuction element : auctions) {
            totalSales += element.getSale();
        }

        return (int)totalSales;
    }

    public ArtAuctionList filterByLots(int minlots, int maxlots) {

        ArtAuctionList filteredAuctions = new ArtAuctionList();
        for (ArtAuction event : auctions) {
            if (event.getLots() >= minlots && event.getLots() <= maxlots) filteredAuctions.addAuction(event);
        }

        return filteredAuctions;
    }

    public ArtAuctionList filterBySale(int minsale, int maxsale) {

        ArtAuctionList filteredAuctions = new ArtAuctionList();
        for (ArtAuction event : auctions) {
            if (event.getSale() >= minsale && event.getSale() <= maxsale) filteredAuctions.addAuction(event);
        }

        return filteredAuctions;
    }

    public ArtAuctionList filterByYear(int year) {

        ArtAuctionList filteredAuctions = new ArtAuctionList();
        for (ArtAuction event : auctions) {
            if (event.getYear() == year) filteredAuctions.addAuction(event);
        }

        return filteredAuctions;
    }

    public ArtAuctionList filterByMonth(int month) {

        ArtAuctionList filteredAuctions = new ArtAuctionList();
        for (ArtAuction event : auctions) {
            if (event.getMonth() == month) filteredAuctions.addAuction(event);
        }

        return filteredAuctions;
    }

    public ArtAuctionList filterComplete() {

        ArtAuctionList filteredAuctions = new ArtAuctionList();
        for (ArtAuction event : auctions) {
            if (event.getLots() != -1 && event.getSale() != -1) filteredAuctions.addAuction(event);
        }

        return filteredAuctions;
    }
}

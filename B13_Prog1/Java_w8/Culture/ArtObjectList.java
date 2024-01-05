import java.util.ArrayList;
import java.util.List;

public class ArtObjectList {

    private List<ArtObject> artObjects;

    public ArtObjectList() {
        artObjects = new ArrayList<>();
    }

    public void addArtObject(ArtObject p) {
        artObjects.add(p);
    }

    public int getNumArtObjects() {
        return artObjects.size();
    }

    public PriceMetrics getPriceMetrics() {
        PriceMetrics artObjectMetrics = new PriceMetrics();

        for (ArtObject element : artObjects) {
            artObjectMetrics.addPrice(element.getPrice());
        }

        return artObjectMetrics;
    }

    public ArtObjectList filterByStatus(char status) {
        ArtObjectList filteredArtObjects = new ArtObjectList();

        for (ArtObject element : artObjects) {
            if (element.getStatus() == status) filteredArtObjects.addArtObject(element);
        }

        return filteredArtObjects;
    }
}

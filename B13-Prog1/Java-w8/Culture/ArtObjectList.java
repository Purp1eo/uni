import java.util.ArrayList;
import java.util.List;

public class ArtObjectList {

    private List<ArtObject> artObjects;

    void addArtObject(ArtObject p) {
        artObjects = new ArrayList<>();
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

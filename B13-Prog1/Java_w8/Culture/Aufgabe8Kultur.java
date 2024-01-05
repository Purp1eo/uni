public class Aufgabe8Kultur {
    
    public static String[] showMetrics(ArtObjectList artObjects) {
        String[] artObjectMetrics = new String[2];

        ArtObjectList soldArtObjectList = artObjects.filterByStatus('s');
        ArtObjectList unsoldArtObjectList = artObjects.filterByStatus('u');

        PriceMetrics soldArtObjectPriceMetrics = soldArtObjectList.getPriceMetrics();
        PriceMetrics unsoldArtObjectPriceMetrics = unsoldArtObjectList.getPriceMetrics();

        String soldResult = "\nVerkauft - " + soldArtObjectPriceMetrics.toString();
        String unsoldResult = "\nNicht verkauft - " + unsoldArtObjectPriceMetrics.toString() + "\n";

        artObjectMetrics[0] = soldResult;
        artObjectMetrics[1] = unsoldResult;

        return artObjectMetrics;
    }
}

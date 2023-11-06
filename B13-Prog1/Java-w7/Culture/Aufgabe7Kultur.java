import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Aufgabe7Kultur {

    // outputs the lowest, highest, and the mean price from an ArtObject[] array
    public static double[] priceMetrics(ArtObject[] objects) {

        double min = objects[0].price;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].price < min) min = objects[i].price;
        }

        double max = objects[0].price;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].price > max) max = objects[i].price;
        }

        double Sum = 0;
        for (ArtObject element : objects) {
            Sum += element.price;
        }

        double[] priceMetrics = new double[3];
        priceMetrics[0] = min;
        priceMetrics[1] = max;
        priceMetrics[2] = Sum/objects.length;

        return priceMetrics;
    }

    // outputs a new ArtObject[] array with objects containing a specific status
    public static ArtObject[] filterByStatus(ArtObject[] objects, char status) {

        List<ArtObject>  artStatusList = new ArrayList<>();
        
        for (ArtObject element : objects) {
            if (element.status == status) {
                artStatusList.add(element);
            }
        }

        ArtObject[] artStatusArray = new ArtObject[artStatusList.size()];

        for (int i = 0; i < artStatusList.size(); i++) {
            artStatusArray[i] = artStatusList.get(i);
        }

        return artStatusArray;
    }
    
    // puts two arrays of status and price together into a new ArtObject[] array, making objects at indexes with coresponding status/price
    public static ArtObject[] createArtObjects(char[] stati, double[] prices) {
        
        List<ArtObject> newArtList = new ArrayList<>();

        for (int i = 0; i < stati.length; i++) {
            newArtList.add(new ArtObject(stati[i], prices[i]));
        }
        
        ArtObject[] newArtArray = new ArtObject[newArtList.size()];

        for (int i = 0; i < newArtList.size(); i++) {
            newArtArray[i] = newArtList.get(i);
        }

        return newArtArray;
    }

    public static String[] showMetrics(ArtObject[] objects) {
        
    // 1. uses filterByStatus to separate ArtObject[] objects into two arrays;
    //    one for sold ones, and one for unsold ones
    //
    // 2. takes both ArtObject[] arrays,
    //    puts the lowest, highest, and mean price of objects.price
    //    into two Strings for outputting data from recovered and deceased
    //    patients respectively
    //     
    //                                                                 1.
    /////////////////////////////////////////////////////////////////////

        ArtObject[] soldArt = new ArtObject[filterByStatus(objects, 's').length];
        for (int i = 0; i < soldArt.length; i++) {
            soldArt[i] = filterByStatus(objects, 's')[i];
        }

        ArtObject[] unsoldArt = new ArtObject[filterByStatus(objects, 'u').length];
        for (int i = 0; i < unsoldArt.length; i++) {
            unsoldArt[i] = filterByStatus(objects, 'u')[i];
        }

    //                                                                 2.
    /////////////////////////////////////////////////////////////////////

        Arrays.sort(soldArt, Comparator.comparingDouble(sA -> sA.price));
        Arrays.sort(unsoldArt, Comparator.comparingDouble(uA -> uA.price));

        double sSum = 0;
        for (ArtObject element : soldArt) {
            sSum += element.price;
        }

        double uSum = 0;
        for (ArtObject element : unsoldArt) {
            uSum += element.price;
        }

        double[] soldArtMetrics = new double[3];
        soldArtMetrics[0] = soldArt[0].price;
        soldArtMetrics[1] = soldArt[soldArt.length - 1].price;
        soldArtMetrics[2] = sSum/soldArt.length;

        double[] unsoldArtMetrics = new double[3];
        unsoldArtMetrics[0] = unsoldArt[0].price;
        unsoldArtMetrics[1] = unsoldArt[unsoldArt.length - 1].price;
        unsoldArtMetrics[2] = uSum/unsoldArt.length;

        String soldMeanRound = String.format("%.2f", soldArtMetrics[2]);
        String unsoldMeanRound = String.format("%.2f", unsoldArtMetrics[2]);

        String soldData = "Verkauft - Min: " + (int)soldArtMetrics[0] + ", Max: " + (int)soldArtMetrics[1] + ", Mean: " + soldMeanRound;
        String unsoldData = "\nNicht verkauft - Min: " + (int)unsoldArtMetrics[0] + ", Max: " + (int)unsoldArtMetrics[1] + ", Mean: " + unsoldMeanRound;

        String[] objectsData = new String[2];
        objectsData[0] = soldData;
        objectsData[1] = unsoldData;
        
        return objectsData;
    }
    public static void main(String[] args) {

        char[] stati = new char[] {'s', 's', 's', 'u', 'u', 'u', 's', 's', 'u', 'u', 'u', 'u', 's', 's', 'u', 's', 's', 's', 
        's', 'u', 'u', 's', 's', 's', 's', 'u', 's', 's', 'u', 'u', 's', 'u', 'u', 's', 's', 'u', 'u', 's', 's', 'u'};
        
        double[] prices = new double[] {600, 6000, 1500, 1000, 1000, 1500, 2500, 1800, 1500, 400, 4000, 2000, 5000, 1000, 
        2000, 6000, 800, 1000, 1500, 1000, 1500, 500, 1500, 1500, 1500, 8000, 3000, 8000, 2500, 5000, 1500, 5000, 10000, 
        2000, 1500, 3500, 1500, 2500, 2500, 2500}; 

        ArtObject artPiece = new ArtObject('u', 6500);
        ArtObject artPiece2 = new ArtObject('s', 420);
        ArtObject artPiece3 = new ArtObject('s', 10);
        ArtObject artPiece4 = new ArtObject('u', 999000);
        ArtObject artPiece5 = new ArtObject('s', 13500);
        
        ArtObject[] arts = {artPiece, artPiece2, artPiece3, artPiece4, artPiece5};

        System.out.println(Arrays.toString(priceMetrics(createArtObjects(stati, prices))));

        System.out.println(Arrays.toString(showMetrics(arts)));
    }
}

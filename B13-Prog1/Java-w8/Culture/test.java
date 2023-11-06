import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {        
        char[] stati = new char[] {'s', 's', 's', 'u', 'u', 'u', 's', 's', 'u', 'u', 'u', 'u', 's', 's', 'u', 's', 's', 's', 
        's', 'u', 'u', 's', 's', 's', 's', 'u', 's', 's', 'u', 'u', 's', 'u', 'u', 's', 's', 'u', 'u', 's', 's', 'u'};
        
        double[] prices = new double[] {600, 6000, 1500, 1000, 1000, 1500, 2500, 1800, 1500, 400, 4000, 2000, 5000, 1000, 
        2000, 6000, 800, 1000, 1500, 1000, 1500, 500, 1500, 1500, 1500, 8000, 3000, 8000, 2500, 5000, 1500, 5000, 10000, 
        2000, 1500, 3500, 1500, 2500, 2500, 2500}; 

/////////////////////////////////////////////////////////// creates an ArtObjectList object (array filled with ArtObject objects) from stati and prices
        List<ArtObject> bilderList = new ArrayList<>();

        for (int i = 0; i < stati.length; i++) {
            bilderList.add(new ArtObject(stati[i], prices[i]));
        }
        
        ArtObject[] bilderArray = new ArtObject[bilderList.size()];

        for (int i = 0; i < bilderList.size(); i++) {
            bilderArray[i] = bilderList.get(i);
        }

        ArtObjectList bilder = new ArtObjectList();

        for (int i = 0; i < prices.length; i++) {
            bilder.addArtObject(bilderArray[i]);
        }

/////////////////////////////////////////////////////////// takes bilder (ArtObjectList object) and splits it in two (split by status: 's', 'u'), 
/////////////////////////////////////////////////////////// instantiates two PriceMetrics objects, prints them to console (stringified)
        ArtObjectList verkaufteBilder = bilder.filterByStatus('r');
        PriceMetrics verkaufteBilderMetrics = verkaufteBilder.getPriceMetrics();
        System.out.println(verkaufteBilderMetrics.toString());

        ArtObjectList nichtVerkaufteBilder = bilder.filterByStatus('d');
        PriceMetrics nichtVerkaufteBilderMetrics = nichtVerkaufteBilder.getPriceMetrics();
        System.out.println(nichtVerkaufteBilderMetrics.toString());

        System.out.println(Arrays.toString(Aufgabe8Kultur.showMetrics(bilder)));
    }
}

import java.util.stream.DoubleStream;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

public class Analysis {

    private EntryManager managingManager;

    public Analysis(String populationFilename, String HIVfilename, String country) {
        
        managingManager = new EntryManager(populationFilename, HIVfilename, country);
    } 

    public double[] getCrudeDeathrates(int fromYear, int toYear) {
        
        double[] CDRs = new double[(toYear-fromYear)+1];
        
        int index = 0;
        for (int i = fromYear; i <= toYear; i++) {
            CDRs[index] = (managingManager.getPopulationEntryForYear(i) == null) ? 0 : managingManager.getPopulationEntryForYear(i).getDeathRate() * 100;
            index++;
        }

        return CDRs;
    }

    public double[] getHIVDeathrates(int fromYear, int toYear) {
        
        double[] HIVDs = new double[(toYear-fromYear)+1];
        
        int index = 0;
        for (int i = fromYear; i <= toYear; i++) {
            HIVDs[index] = (managingManager.getHIVDeathrateForYear(i) == null) ? 0 : managingManager.getHIVDeathrateForYear(i).getValue();
            index++;
        }

        return HIVDs;
    }

    public double[] getHIVPrevalences(int fromYear, int toYear) {

        double[] HIVPs = new double[(toYear-fromYear)+1];
        
        int index = 0;
        for (int i = fromYear; i <= toYear; i++) {
            HIVPs[index] = (managingManager.getHIVPrevalenceForYear(i) == null) ? 0 : managingManager.getHIVPrevalenceForYear(i).getValue();
            index++;
        }

        return HIVPs;
    }

    public double[] getPercentageHIVDeathrates(int fromYear, int toYear) {
        
        double[] PHIVDs = new double[(toYear-fromYear)+1];

        double[] HIVDs = getHIVDeathrates(fromYear, toYear);
        double[] CDRs = getCrudeDeathrates(fromYear, toYear);

        for (int i = 0; i < PHIVDs.length; i++) {
            if(HIVDs[i] == 0.0 || CDRs[i] == 0.0) {
                PHIVDs[i] = 0;
                continue;
            }
            PHIVDs[i] = HIVDs[i] / CDRs[i] * 100;
        }

        return PHIVDs;
    }

    public void plotPercantageAnalysis(int fromYear, int toYear, boolean plotPrevalence, boolean plotCrudeDeathrate, String filename) {

        XYChart countryChart = new XYChart(1000, 500);
        countryChart.setXAxisTitle("Year");        
        countryChart.setYAxisGroupTitle(0, "%");
        countryChart.setYAxisGroupTitle(1, "Prevalence");
        countryChart.setYAxisGroupTitle(2, "Crude Deathrate");

        double[] yearsArray = DoubleStream.iterate(fromYear, n -> n + 1).limit((toYear-fromYear)+1).toArray();
        double[] percentageArray = getPercentageHIVDeathrates(fromYear, toYear);
        XYSeries percentageOverTime = countryChart.addSeries("Deathrate % due to HIV", yearsArray, percentageArray);
        percentageOverTime.setYAxisGroup(0);

        if(plotPrevalence) {
            double[] prevalenceArray = getHIVPrevalences(fromYear, toYear);
            XYSeries prevalenceOverTime = countryChart.addSeries("HIV prevalence (per 100k)", yearsArray, prevalenceArray);
            prevalenceOverTime.setYAxisGroup(1);
        }

        if(plotCrudeDeathrate) {
            double[] CDRArray = getCrudeDeathrates(fromYear, toYear);
            XYSeries CDROverTime = countryChart.addSeries("Crude deathrate (per 100k)", yearsArray, CDRArray);
            CDROverTime.setYAxisGroup(2);
        }

        new SwingWrapper(countryChart).displayChart();
       
        try {
            BitmapEncoder.saveBitmap(countryChart, filename, BitmapFormat.PNG);
        } catch(Exception e) {
            System.out.println("Fehler beim Speichern der Bilddatei.");
        }
    }
    
    public static void main(String[] args) {
        
        String popFilepath = "D:\\Uni\\B13_Prog1\\Java_exam\\UN_popIndicators.csv";
        String HIVdataFilepath = "D:\\Uni\\B13_Prog1\\Java_exam\\GDBx_HIVdata.csv";
        
        Analysis analysingAnalysis = new Analysis(popFilepath, HIVdataFilepath, "United States of America");
        analysingAnalysis.plotPercantageAnalysis(1990, 2018, true, true, "myChart.png"); 
    }
}

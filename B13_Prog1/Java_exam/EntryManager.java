import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntryManager {
    
    private String populationFilename;
    private String HIVfilename;
    private String country;

    public EntryManager(String populationFilename, String HIVfilename, String country) {

    }
    
    public void addFromCSVFile(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;

            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                addPatient(Patient.parseCSVLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public populationEntry getPopulationEntryForYear(int year) {
        
       // return entry from year 
        
        return null;
    }

    public HIVEntry getHIVDeathrateForYear(int year) {

        // return entry for "death" measure from year

        return null;
    }

    public HIVEntry getHIVPrevalenceForYear(int year) {

        // return entry for "prevalence" measure from year

        return null;
    }

    public String getCountry() {
        
        // return country, for which entry was made

        return null;
    }
}
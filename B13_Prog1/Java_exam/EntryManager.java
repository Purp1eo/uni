import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EntryManager {
    
    private String country;
    private String populationFilename;
    private String HIVfilename;
    private ArrayList<PopulationEntry> population = new ArrayList<PopulationEntry>();
    private ArrayList<HIVEntry> HIVDeaths = new ArrayList<HIVEntry>();
    private ArrayList<HIVEntry> HIVPrevalence = new ArrayList<HIVEntry>();

    public EntryManager(String populationFilename, String HIVfilename, String country) {
        this.country = country;
        this.populationFilename = populationFilename;
        this.HIVfilename = HIVfilename;
        addFromCSVFile(populationFilename);
        addFromCSVFile(HIVfilename);
    }
    
    public void addFromCSVFile(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            
            br.readLine();
            while ((line = br.readLine()) != null) {
                if(filepath.equals(populationFilename) && parsePopulation(line) != null) population.add(parsePopulation(line));
                if(filepath.equals(HIVfilename) && parseHIV(line) != null) {
                    if(parseHIV(line).getMeasure().equals("Deaths")) HIVDeaths.add(parseHIV(line));
                    if(parseHIV(line).getMeasure().equals("Prevalence")) HIVPrevalence.add(parseHIV(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PopulationEntry parsePopulation(String line) {

        String fileDelimiter = ",";
        String[] attributes = line.split(fileDelimiter);

        try {

            String location = attributes[1];
            if(!country.equals(location)) return null;
            int fromYear = Integer.parseInt(attributes[4].split("-")[0]);
            int toYear = Integer.parseInt(attributes[4].split("-")[1]);
            double deathRate = Double.parseDouble(attributes[15]);

            return new PopulationEntry(location, fromYear, toYear, deathRate);

        } catch (Exception e) {
            return null;
        }
    }

    public HIVEntry parseHIV(String line) {
        
        String fileDelimiter = ",";
        String[] attributes = line.split(fileDelimiter);

        try {

            String location = attributes[3];
            if (!country.equals(location))
                return null;
            String measure = attributes[1];
            int year = Integer.parseInt(attributes[12]);
            double value = Double.parseDouble(attributes[13]);

            return new HIVEntry(measure, year, value);

        } catch (Exception e) {
            return null;
        }
    }

    public PopulationEntry getPopulationEntryForYear(int year) {
        
        for (PopulationEntry element : population) {
            if(element.isValidForYear(year)) return element;
        } 

        return null;
    }

    public HIVEntry getHIVDeathrateForYear(int year) {

        for (HIVEntry element : HIVDeaths) {
            if(element.getYear() == year) return element;
        } 

        return null;
    }

    public HIVEntry getHIVPrevalenceForYear(int year) {

        for (HIVEntry element : HIVPrevalence) {
            if(element.getYear() == year) return element;
        } 

        return null;
    }

    public String getCountry() {
        
        return country;
    }
}
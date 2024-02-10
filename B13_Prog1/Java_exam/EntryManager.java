import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EntryManager {
    
    private String country;
    private ArrayList<PopulationEntry> population = new ArrayList<PopulationEntry>();
    private ArrayList<HIVEntry> HIVDeaths = new ArrayList<HIVEntry>();
    private ArrayList<HIVEntry> HIVPrevalence = new ArrayList<HIVEntry>();

    public EntryManager(String populationFilename, String HIVfilename, String country) {
        this.country = country;
        addFromCSVFile(populationFilename);
        addFromCSVFile(HIVfilename);
    }
    
    public void addFromCSVFile(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;

            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                if(filepath.equals("populationFilename")) population.add(parsePopulation(line));
                if(filepath.equals("HIVfilename")) {
                    HIVDeaths.add(parseHIVDeaths(line));
                    HIVPrevalence.add(parseHIVPrevelance(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PopulationEntry parsePopulation(String line) {
                
        String fileDelimiter = ",";
        String[] attributes = line.split(fileDelimiter);
        
        String location = attributes[1];
        if(!country.equals(location)) return null;
        int fromYear = Integer.parseInt(attributes[4].split("-")[0]);
        int toYear = Integer.parseInt(attributes[4].split("-")[1]);
        double deathRate = Double.parseDouble(attributes[15]);
        
        PopulationEntry pop = new PopulationEntry(location, fromYear, toYear, deathRate);

        return pop;
    }

    public HIVEntry parseHIVDeaths(String line) {
        
        String fileDelimiter = ",";
        String[] attributes = line.split(fileDelimiter);
        
        String location = attributes[3];
        if(!country.equals(location)) return null;
        String measure = attributes[1];
        int year = Integer.parseInt(attributes[12]);
        double value = Double.parseDouble(attributes[13]);

        HIVEntry HIVD = new HIVEntry(measure, year, value);
    
        return HIVD;
    }

    public HIVEntry parseHIVPrevelance(String line) {

        String fileDelimiter = ",";
        String[] attributes = line.split(fileDelimiter);

        String location = attributes[3];
        if(!country.equals(location)) return null;
        String measure = attributes[1];
        int year = Integer.parseInt(attributes[12]);
        double value = Double.parseDouble(attributes[13]);

        HIVEntry HIVP = new HIVEntry(measure, year, value);
    
        return HIVP;
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
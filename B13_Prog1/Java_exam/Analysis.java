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

        for (int i = 0; i <= PHIVDs.length; i++) {
            if(HIVDs[i] == 0.0 || CDRs[i] == 0.0) {
                PHIVDs[i] = 0;
                continue;
            }
            PHIVDs[i] = HIVDs[i] / CDRs[i] * 100;
        }

        return PHIVDs;
    }
}

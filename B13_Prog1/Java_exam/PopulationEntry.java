pulbic class PopulationEntry {
    
    private String country;
    private int fromYear;
    private int toYear;
    private double deathRate;
    
    public PopulationEntry(String country, int fromYear, int toYear, double deathRate) {
        country = this.country;
        fromYear = this.fromYear;
        toYear = this.toYear;
        deathRate = this.deathRate;
    }

    public boolean isValidForYear(int year) {
        return (year <= fromYear && year > toYear);
    }

    public String getCountry() {
        return country;
    }

    public int getFromYear() {
        return fromYear;
    }

    public int getToYear() {
        return toYear;
    }

    public double getDeathRate() {
        return deathRate;
    }
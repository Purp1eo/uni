public class Patient {
    private int fromAge;
    private int toAge;
    private String sex;
    private int day;
    private int month;
    private int year;

    private Patient() {}

    public static Patient parseCSVLine(String line) {
        String fileDelimiter = ",";
        Patient person = new Patient();

        String[] attributes = line.split(fileDelimiter);

        String ageValue = attributes[0];
        person.sex = attributes[1];
        String dateOnset = attributes[2];

        if (ageValue.equals("N/A")) {
            person.fromAge = -1;
            person.toAge = -1;

        } else if (ageValue.contains("-")) {
            String[] ageRangeNumbers = ageValue.split("-");
            person.fromAge = Integer.parseInt(ageRangeNumbers[0]);
            person.toAge = Integer.parseInt(ageRangeNumbers[1]);
            
        } else {
            person.fromAge = Integer.parseInt(ageValue);
            person.toAge = Integer.parseInt(ageValue);
        }

        String[] onsetDates = dateOnset.split("-");
        person.day = Integer.parseInt(onsetDates[0]);
        person.month = Integer.parseInt(onsetDates[1]);
        person.year = Integer.parseInt(onsetDates[2]);

        return person;
    }

    public int getFromAge() {
        return fromAge;
    }

    public int getToAge() {
        return toAge;
    }

    public String getSex() {
        return sex;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public static void main(String[] args) {
        
    }
}

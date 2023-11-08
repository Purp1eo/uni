import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Patient {
    private int fromAge;
    private int toAge;
    private String sex;
    private int day;
    private int month;
    private int year;

    private Patient() {}

    public static Patient parseCSVLine(String line) {
        
        
        return null;
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
}

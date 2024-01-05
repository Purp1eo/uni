public class DateUtilities {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? true : false; 
    }

    public static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    public static int daysInMonth(int year, int month) {
        int days = 0;
        switch (month) {
            case 2:
                days = isLeapYear(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
        }
        return days;
    }
}

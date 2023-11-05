import java.util.Arrays;

public class calculation {
    public static double[] metrics(double[] values) {
        
        Arrays.sort(values);

        double sum = 0;
        for (double num : values) {
            sum += num;
        }

        double[] result = new double[3];
        result[0] = values[0];
        result[1] = values[values.length - 1];
        result[2] = sum/values.length;

        return result;
    } 
    
    public static void main(String[] args) {
        double[] doubleArray = {3.14, 4.669, 2.718, 0.577, 1.89};
        double[] showArray = metrics(doubleArray);

        System.out.println(Arrays.toString(showArray));
    }
}
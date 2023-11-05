import java.util.Arrays;

public class selection {
    public static double[] select(double[] values, int[] indices) {
        
        double[] selectedValues = new double[indices.length];
        
        for (int i = 0; i < indices.length; i++) {
            selectedValues[i] = values[indices[i]];
        }

        return selectedValues;
    }
    public static void main(String[] args) {
        double[] randomDoubleArray = {1.23, 2.45, 3.67, 4.89, 5.12, 6.34};
        int[] randomIntArray = {5, 2, 0};

        double[] showArray = select(randomDoubleArray, randomIntArray);

        System.out.println(Arrays.toString(showArray));
    }
}
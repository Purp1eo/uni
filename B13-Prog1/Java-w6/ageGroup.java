public class ageGroup {
    public static void main(String[] args) {
        double[] ages = {20, 45, 69, 70, 45, 16, 59, 45, 24, 54, 53, 65, 61, 3, 48, 47, 13, 85, 27, 69, 45, 20, 67, 63, 18, 56, 25, 35, 35, 
        24, 70, 65, 34, 32, 23, 67, 53, 35, 33, 38, 22, 27, 69, 64, 36, 27, 51, 48, 46, 85, 38, 41, 24, 22, 73, 69, 23, 41, 32, 40, 65, 56, 
        47, 65, 70, 23, 65, 37, 63, 59, 26, 63, 69, 23, 24, 33, 35, 70, 36, 53, 35, 1, 60, 22, 18, 21, 21, 23, 70, 32, 38, 18, 74, 21, 20, 
        44, 38, 21, 42, 68, 29, 58, 1, 51, 45, 32, 34, 24, 48, 35, 26, 73, 75, 67, 67, 65, 44, 62, 75, 60, 1, 80, 72, 71, 65, 66, 55, 22, 
        50, 80, 50, 45};

        char[] stati = {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'd', 'r', 'r', 'r', 
        'r', 'r', 'r', 'r', 'r', 'r', 'r', 'd', 'r', 'r', 'r', 'r', 'd', 'r', 'r', 'r', 'd', 'r', 'r', 'd', 'r', 'r', 'r', 'r', 'r', 'r', 
        'd', 'r', 'r', 'r', 'r', 'r', 'd', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'd', 'r', 'r', 'd', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 
        'r', 'r', 'd', 'r', 'r', 'd', 'r', 'd', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'd', 'r', 'r', 'd', 'r', 'r', 'r', 'd', 'r', 
        'r', 'r', 'r', 'd', 'r', 'r', 'r', 'd', 'r', 'r', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 
        'd', 'd', 'd', 'd', 'd'};
    
        // first >> filtration (make two arrays for the indices of all recovered and all deceased patients) 

        int[] recIndex = filtration.filter(stati, 'r');
        int[] decIndex = filtration.filter(stati, 'd');

        // second >> selection (link the indices to the patients' ages) 

        double[] recAges = selection.select(ages, recIndex);
        double[] decAges = selection.select(ages, decIndex);

        // third >> calculation (use the metrics on both arrays, recovered patients and deceased ones)
            // (and round the mean :D)

        double[] recMetrics = calculation.metrics(recAges);
        double[] decMetrics = calculation.metrics(decAges);
        String recRound = String.format("%.2f", recMetrics[2]);
        String decRound = String.format("%.2f", decMetrics[2]);

        System.out.println("Verstorben - Min: " + (int)recMetrics[0] + ", Max: " + (int)recMetrics[1] + ", Mean: " + recRound);
        System.out.println("Genesen - Min: " + (int)decMetrics[0] + ", Max: " + (int)decMetrics[1] + ", Mean: " + decRound);

        
    }
}
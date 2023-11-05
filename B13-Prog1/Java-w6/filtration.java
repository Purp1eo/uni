import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class filtration {
    public static int[] filter(char[] values, char toSelect) {

        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (values[i] == toSelect) indexList.add(i);
        }

        int[] indexArray = new int[indexList.size()];
        
        for (int i = 0; i < indexList.size(); i++) {
            indexArray[i] = indexList.get(i);
        }

        return indexArray;
    }
    
    public static void main(String[] args) {
        char[] charArray = {'a', 'h', 'g', 'a', 'v', 'k', 'a', 'b', 'k', 'd', 'g', 'h'};
        int[] showArray = filter(charArray, 'a');
        
        System.out.println(Arrays.toString(showArray));
    }
}

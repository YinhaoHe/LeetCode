
// A naive method to find maximum of
// minimum of all windows of different sizes
import java.util.*;

class Test {
    public static int availableSpace(List<Integer> freeSpace, int blockLength) {
        // Consider all windows of different
        // sizes starting from size 1
        int maxOfMin = Integer.MIN_VALUE;
        for (int k = 1; k <= blockLength; k++) {
            // Initialize max of min for current
            // window size k
            maxOfMin = Integer.MIN_VALUE;

            // Traverse through all windows of
            // current size k
            for (int i = 0; i <= blockLength - k; i++) {
                // Find minimum of current window
                int min = freeSpace.get(i);
                for (int j = 1; j < k; j++) {
                    if (freeSpace.get(i + j) < min)
                        min = freeSpace.get(i + j);
                }
                // Update maxOfMin if required
                if (min > maxOfMin)
                    maxOfMin = min;
            }
        }
        return maxOfMin;
    }

    // Driver method
    public static void main(String[] args) {

    }
}

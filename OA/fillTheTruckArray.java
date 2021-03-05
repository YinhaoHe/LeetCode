import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {
        int maxUnits = 0;

        if (containers == null || itemSize == 0 || itemsPerContainer == null || itemsPerContainer.length == 0
                || cargoSize <= 0 || num < 1) {
            return maxUnits;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < num; i++) {
            int box = containers[i];
            int unit = itemsPerContainer[i];
            while (box > 0) {
                maxHeap.add(unit);
                box--;
            }
        }

        while (cargoSize > 0) {
            if (!maxHeap.isEmpty()) {
                maxUnits += maxHeap.poll();
            }
            cargoSize--;
        }

        return maxUnits;
    }
}
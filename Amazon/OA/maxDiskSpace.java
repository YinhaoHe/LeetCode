import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int availableSpace(List<Integer> hardDiskSpace, int blockLength) {
        int res = Integer.MIN_VALUE;
        // strictly monotone increasing of (index, space)
        ArrayDeque<Map.Entry<Integer, Integer>> mins = new ArrayDeque<>();
        for (int i = 0; i < hardDiskSpace.size(); i++) {
            int space = hardDiskSpace.get(i);
            if (mins.size() > 0 && mins.getFirst().getKey() <= i - blockLength)
                mins.pollFirst();
            while (mins.size() > 0 && mins.getLast().getValue() >= space)
                mins.pollLast();
            mins.addLast(Map.entry(i, space));
            if (i >= blockLength)
                res = Math.max(res, mins.getFirst().getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> freeSpace = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int blockLength = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = availableSpace(freeSpace, blockLength);
        System.out.println(res);
    }
}
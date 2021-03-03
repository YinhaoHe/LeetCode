import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class AvailableSpace {
    public static int availableSpace(List<Integer> freeSpace, int blockLength) {
        int res = Integer.MIN_VALUE;
        // strictly monotone increasing of (index, space)
        ArrayDeque<Map.Entry<Integer, Integer>> lows = new ArrayDeque<>();
        for (int i = 0; i < freeSpace.size(); i++) {
            int space = freeSpace.get(i);
            if (lows.size() > 0 && lows.getFirst().getKey() <= i - blockLength)
                lows.pollFirst();
            while (lows.size() > 0 && lows.getLast().getValue() >= space) {
                lows.pollLast();
            }
            lows.offerLast(Map.entry(i, space));
            if (i >= blockLength) {
                res = Math.max(res, lows.getFirst().getValue());
            }
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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

class NearestPins {
    public static List<String> nearestPins(List<String> pins, List<Integer> xCoordinates, List<Integer> yCoordinates,
            List<String> queries) {
        String[] res = new String[queries.size()];
        Map<Integer, TreeMap<Integer, String>> xMap = new HashMap<>();
        Map<Integer, TreeMap<Integer, String>> yMap = new HashMap<>();
        Map<String, int[]> nodeMap = new HashMap<>();

        for (int i = 0; i < pins.size(); i++) {

            nodeMap.put(pins.get(i), new int[] { xCoordinates.get(i), yCoordinates.get(i) });

            xMap.putIfAbsent(xCoordinates.get(i), new TreeMap<>());

            yMap.putIfAbsent(yCoordinates.get(i), new TreeMap<>());

            xMap.get(xCoordinates.get(i)).put(yCoordinates.get(i), pins.get(i));
            yMap.get(yCoordinates.get(i)).put(xCoordinates.get(i), pins.get(i));

        }

        for (int i = 0; i < queries.size(); i++) {

            int[] node = nodeMap.get(queries.get(i));

            TreeMap<Integer, String> ym = xMap.getOrDefault(node[0], new TreeMap<>());

            TreeMap<Integer, String> xm = yMap.getOrDefault(node[1], new TreeMap<>());

            Integer yl = ym.lowerKey(node[1]), yh = ym.higherKey(node[1]);

            Integer xl = xm.lowerKey(node[0]), xh = xm.higherKey(node[0]);

            int dist = Integer.MAX_VALUE;
            if (yl != null && Math.abs(yl - node[1]) <= dist) {
                dist = Math.abs(yl - node[1]);
                res[i] = res[i] == null ? ym.get(yl) : res[i].compareTo(ym.get(yl)) > 0 ? ym.get(yl) : res[i];

            }

            if (yh != null && Math.abs(yh - node[1]) <= dist) {
                dist = Math.abs(yh - node[1]);
                res[i] = res[i] == null ? ym.get(yh) : res[i].compareTo(ym.get(yh)) > 0 ? ym.get(yh) : res[i];

            }

            if (xl != null && Math.abs(xl - node[0]) <= dist) {
                dist = Math.abs(xl - node[0]);
                res[i] = res[i] == null ? xm.get(xl) : res[i].compareTo(xm.get(xl)) > 0 ? xm.get(xl) : res[i];

            }
            if (xh != null && Math.abs(xh - node[1]) <= dist) {
                dist = Math.abs(xh - node[1]);
                res[i] = res[i] == null ? xm.get(xh) : res[i].compareTo(xm.get(xh)) > 0 ? xm.get(xh) : res[i];

            }

            if (res[i] == null)

                res[i] = "NONE";

        }
        return Arrays.asList(res);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> pins = Arrays.asList(scanner.nextLine().split(" "));
        List<Integer> xCoordinates = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> yCoordinates = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<String> queries = Arrays.asList(scanner.nextLine().split(" "));
        scanner.close();
        List<String> res = nearestPins(pins, xCoordinates, yCoordinates, queries);
        System.out.println(String.join(" ", res));
    }
}

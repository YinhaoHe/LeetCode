import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class FetchResultsToDisplay {
    public static List<String> fetchResultsToDisplay(int sortColumn, int sortOrder, int pageSize, int pageIndex,
            Map<String, int[]> results) {
        ArrayList<String> ordered = new ArrayList<>(results.keySet()); // create a list of result names
        ordered.sort((a, b) -> {
            int res;
            if (sortColumn == 0) { // compare result name alphabetical
                res = a.compareTo(b);
            } else {
                // compare by relevance or price. sortParamter - 1 because subtracting the
                // result name spot
                res = results.get(a)[sortColumn - 1] - results.get(b)[sortColumn - 1];
            }
            return res * (sortOrder == 0 ? 1 : -1); // if reverse order, then * -1
        });
        int startIndex = pageSize * pageIndex;
        return ordered.subList(startIndex, Math.min(startIndex + pageSize, ordered.size()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sortColumn = Integer.parseInt(scanner.nextLine());
        int sortOrder = Integer.parseInt(scanner.nextLine());
        int resultsPerPage = Integer.parseInt(scanner.nextLine());
        int pageIndex = Integer.parseInt(scanner.nextLine());
        int resultsLength = Integer.parseInt(scanner.nextLine());
        HashMap<String, int[]> results = new HashMap<>();
        for (int i = 0; i < resultsLength; i++) {
            String[] segs = scanner.nextLine().split(" ");
            results.put(segs[0], new int[] { Integer.parseInt(segs[1]), Integer.parseInt(segs[2]) });
        }
        scanner.close();
        List<String> res = fetchResultsToDisplay(sortColumn, sortOrder, resultsPerPage, pageIndex, results);
        System.out.println(String.join(" ", res));
    }
}
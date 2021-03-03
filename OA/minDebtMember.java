import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

class Solution {
    public static List<String> debtRecords(List<List<String>> debts) {
        HashMap<String, Integer> bals = new HashMap<>();
        for (List<String> debt : debts) {
            int amount = Integer.parseInt(debt.get(2));
            bals.merge(debt.get(0), -amount, (a, b) -> (a + b));
            bals.merge(debt.get(1), amount, (a, b) -> (a + b));
        }
        int minBal = -1;
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> e : bals.entrySet()) {
            int bal = e.getValue();
            if (bal > minBal) {
                continue;
            }
            if (bal < minBal) {
                minBal = bal;
                res.clear();
            }
            res.add(e.getKey());
        }
        if (res.isEmpty()) {
            return List.of("No countries have debt.");
        }

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int debtsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> debts = new ArrayList<>();
        for (int i = 0; i < debtsLength; i++) {
            debts.add(Arrays.asList(scanner.nextLine().split(" ")));
        }
        scanner.close();
        List<String> res = debtRecords(debts);
        System.out.println(String.join(" ", res));
    }
}

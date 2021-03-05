import java.util.*;

public class countTeams {
    public int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel) {
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (skills[i] >= minLevel && skills[i] <= maxLevel)
                count++;
        }
        int res = 0;
        for (int i = minAssociates; i <= count; i++) {
            res += comb(count, i);
        }
        return res;
    }

    Map<String, Integer> map = new HashMap<String, Integer>();

    private int comb(int m, int n) {
        String key = m + "," + n;
        if (n == 0)
            return 1;
        if (n == 1)
            return m;
        if (n > m / 2)
            return comb(m, m - n);
        if (n > 1) {
            if (!map.containsKey(key))
                map.put(key, comb(m - 1, n - 1) + comb(m - 1, n));
            return map.get(key);
        }
        return 0;
    }

    public static void main(String args[]) {
        countTeams c = new countTeams();
        int[] list = { 6, 13, 5, 10, 12, 4, 2, 15 };
        System.out.println(c.countTeams(8, list, 3, 4, 10));
    }
}

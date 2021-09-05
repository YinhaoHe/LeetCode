import java.util.LinkedList;
import java.util.List;

public class Turnsites {
    public int[] getTimes(int numCustomers, int[] arrTime, int[] directions) {
        // Store index of the cars
        List<Integer> entry = new LinkedList<>();
        List<Integer> exit = new LinkedList<>();
        for (int i = 0; i < arrTime.length; i++) {
            if (directions[i] == 0) {
                entry.add(i);
            } else
                exit.add(i);
        }
        int curTime = -1;
        int prevDir = 1;
        int[] ret = new int[arrTime.length];
        while (!entry.isEmpty() && !exit.isEmpty()) {
            int curEntry = entry.get(0);
            int curExit = exit.get(0);
            int curEnterTime = Math.max(arrTime[curEntry], curTime);
            int curExitTime = Math.max(arrTime[curExit], curTime);

            if (curEnterTime < curExitTime) {
                ret[curEntry] = curEnterTime;
                prevDir = 0;
                entry.remove(0);
                curTime = curEnterTime + 1;
            } else if (curExitTime < curEnterTime) {
                ret[curExit] = curExitTime;
                prevDir = 1;
                exit.remove(0);
                curTime = curExitTime + 1;
            } else {
                if (prevDir == 0) {
                    ret[curEntry] = curEnterTime;
                    entry.remove(0);
                    curTime = curEnterTime + 1;
                } else {
                    ret[curExit] = curExitTime;
                    exit.remove(0);
                    curTime = curExitTime + 1;
                }
            }
        }

        while (!entry.isEmpty()) {
            int curEntry = entry.remove(0);
            int curEnterTime = Math.max(arrTime[curEntry], curTime);
            ret[curEntry] = curEnterTime;
            curTime = curEnterTime + 1;
        }

        while (!exit.isEmpty()) {
            int curExit = exit.remove(0);
            int curExitTime = Math.max(arrTime[curExit], curTime);
            ret[curExit] = curExitTime;
            curTime = curExitTime + 1;
        }

        return ret;
    }

    private static void test(int[] result, int[] expects) {
        assert (result.length == expects.length);
        for (int i = 0; i < result.length; i++) {
            assert (result[i] == expects[i]);
        }
    }

    public static void main(String[] args) {
        Turnsites obj = new Turnsites();
        int[] times = { 0, 0, 1, 5 };
        int[] directions = { 0, 1, 1, 0 };
        int[] expects = { 2, 0, 1, 5 };
        Turnsites.test(obj.getTimes(times, directions), expects);

        times = new int[] { 1, 2, 4 };
        directions = new int[] { 0, 1, 1 };
        expects = new int[] { 1, 2, 4 };
        Turnsites.test(obj.getTimes(times, directions), expects);

        times = new int[] { 1, 1 };
        directions = new int[] { 1, 1 };
        expects = new int[] { 1, 2 };
        Turnsites.test(obj.getTimes(times, directions), expects);

        times = new int[] { 1, 1, 3, 3, 4, 5, 6, 7, 7 };
        directions = new int[] { 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        expects = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Turnsites.test(obj.getTimes(times, directions), expects);
    }
}
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static List<Integer> getTimes(int numCustomers, int[] arrTime, int[] direction) {
        ArrayDeque<Map.Entry<Integer, Integer>> enterQueue = new ArrayDeque<>();
        ArrayDeque<Map.Entry<Integer, Integer>> exitQueue = new ArrayDeque<>();
        int curTime = -1;
        String lastUsedType = "exit";
        for (int i = 0; i < numCustomers; i++) {
            if (direction[i] == 0)
                enterQueue.offer(Map.entry(arrTime[i], i));
            else
                exitQueue.offer(Map.entry(arrTime[i], i));
        }
        List<Integer> ans = Arrays.asList(new Integer[numCustomers]);
        while (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {
            ArrayDeque<Map.Entry<Integer, Integer>> curQueue;
            if (enterQueue.peek().getKey() <= curTime && exitQueue.peek().getKey() <= curTime) {
                if (curTime == -1 || lastUsedType == "exit")
                    curQueue = exitQueue;
                else
                    curQueue = enterQueue;
            } else if (enterQueue.peek().getKey() < exitQueue.peek().getKey()) {
                curQueue = enterQueue;
            } else {
                curQueue = exitQueue;
            }
            Map.Entry<Integer, Integer> worker = curQueue.poll();
            int time = worker.getKey();
            int i = worker.getValue();
            lastUsedType = curQueue == enterQueue ? "enter" : "exit";
            curTime = Math.max(time, curTime);
            ans.set(i, curTime);
            curTime++;
        }
        ArrayDeque<Map.Entry<Integer, Integer>> remainingQueue = !enterQueue.isEmpty() ? enterQueue : exitQueue;
        while (!remainingQueue.isEmpty()) {
            Map.Entry<Integer, Integer> worker = remainingQueue.poll();
            int time = worker.getKey();
            int i = worker.getValue();
            curTime = Math.max(time, curTime);
            ans.set(i, curTime);
            curTime++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numWorker = Integer.parseInt(scanner.nextLine());
        List<Integer> arrTime = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> direction = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        scanner.close();
        List<Integer> res = getTimes(numWorker, arrTime, direction);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
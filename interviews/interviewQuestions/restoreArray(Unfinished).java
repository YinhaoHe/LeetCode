import java.util.*;

class solution {
    public static void restoreArray(int[][] pairs) {
        List<Integer> arrayList = new ArrayList<>();
        for (int[] pair : pairs) {
            for (int e : pair) {
                if (arrayList.contains(e)) {
                    continue;
                } else {
                    arrayList.add(e);
                }
            }
        }
        int size = arrayList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i ++) {
            res[i] = arrayList.get(i);
        }
        for (int i = 0; i < res.length; i ++) {
            System.out.println(res[i]);
        }
    }
    public static void main(String[] args) {
        int[][] pairs = {{5,3},{4,1},{2,4},{1,5}};
        restoreArray(pairs);
    }
}
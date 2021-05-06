class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set 去重
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);
        // 动态数组存储结果
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer s : set1) {
            if (set2.contains(s)) res.add(s);
        }   
        // list转为需要的return array
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); ++ i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
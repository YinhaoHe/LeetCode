public class Solution {
    /**
     * @param nums: a integer array
     * @return: return an integer denoting the number of non-unique(duplicate) values
     */
    public List<Integer> countduplicates(List<Integer> nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); ++ i) {
            Integer num = nums.get(i);
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                    res.add(nums.get(map.get(num)));
            }
        }
        // Set set = new HashSet<>();
        // List<Integer> ans = new ArrayList<>();
        // for (Integer n : res) {
        //     if (set.add(n)) {
        //         ans.add(n);
        //     }
        // }
        // return ans;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.addAll(res);
        res.clear();
        res.addAll(set);
        return res;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // utwRecords根据用户名组合三个数组
        // 第一个HashMap里面使用TreeMap是为了方便排序
        HashMap<String, TreeMap<Integer, String>> utwRecords = new HashMap<>();
        for (int i = 0; i < username.length; i ++) {
            if (!utwRecords.containsKey(username[i])) {
                utwRecords.put(username[i], new TreeMap<Integer, String>());
            }
            
            utwRecords.get(username[i]).put(timestamp[i], website[i]);
        }
        
        // uwRecords 提取utwRecords 里面除了时间戳的数据 
        // 用户名 以及 对应的访问的网页（按照时间戳排序）
        HashMap<String, ArrayList<String>> uwRecords = new HashMap<>();
        for (String name : utwRecords.keySet()) {
            uwRecords.put(name, new ArrayList<String>());
            for (Integer time : utwRecords.get(name).keySet()) {
                uwRecords.get(name).add(utwRecords.get(name).get(time));
            }
        }
        
        // cntWP 存储所枚举的每一条网页访问路径 并且记录出现的次数
        // <网页访问路径(3个网页名称合成1条字符串), 出现次数>
        HashMap<String, Integer> cntWP = new HashMap<>();
        // maxCnt 记录网页路径出现最多次数
        int maxCnt = 0;
        // res 记录访问次数最多的路径
        String res = new String();
        for (String name : uwRecords.keySet()) {
            // len 为当前访问的网页数
            int len = uwRecords.get(name).size();
            // single 存储当前用户所访问网页的访问路径 并去重
            HashSet<String> single = new HashSet<>();
            for (int i = 0; i < len - 2; i ++) {
                for (int j = i + 1; j < len - 1; j ++) {
                    for (int k = j + 1; k < len; k ++) {
                        String cur = (new StringBuilder()).append(uwRecords.get(name).get(i))
                            .append("->")
                            .append(uwRecords.get(name).get(j))
                            .append("->")
                            .append(uwRecords.get(name).get(k)).toString();
                        single.add(cur);
                    }
                }
            }
        
        
            // 遍历当前用户所访问网络的路径 存储并给访问路径计数
            for (String str : single) {
                if (!cntWP.containsKey(str)) {
                    cntWP.put(str, 0);
                }
                cntWP.put(str, cntWP.get(str)+1);

                int curCnt = cntWP.get(str);
                // 当该访问路径出现次数curCnt大于最大访问次数maxCnt 
                //      那么结果路径res就是该路径
                // 或者
                // 当该访问路径出现次数curCnt等于最大访问次数maxCnt 且字典序小于原出现次数最多的路径res 
                //      那么结果路径res就是该路径
                if (curCnt > maxCnt | (curCnt == maxCnt && str.compareTo(res) < 0)) {
                    maxCnt = curCnt;
                    res = str;
                }
            }
        }
        
        // ans 存储所求结果访问路径的3个网页
        // 其实也可以使用 Arrays.asList(res.split("->"))
        ArrayList<String> ans = new ArrayList<>();
        for (String str : res.split("->")) {
            ans.add(str);
        }
        
        return ans;
    }
}
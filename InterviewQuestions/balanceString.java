/*

balance String 找到一个最长字符串 对于每一个字符 要同时包含大小写 数量不考虑

*/

import java.util.*;

public class Solution2 {
    static public int solution(String S) {
        for (int k = 1; k <= S.length(); k++) {
            for (int i = 0; i < S.length() - k + 1; i++) {
                Set<Character> lowerSet = new HashSet<>();
                Set<Character> upperSet = new HashSet<>();
                String temp = S.substring(i, i + k);
                char[] tempCharArr = temp.toCharArray();
                for (char ch : tempCharArr) {
                    if (Character.isLowerCase(ch))
                        lowerSet.add(ch);
                    else
                        upperSet.add(ch);
                }
                if (containsAllElements(lowerSet, upperSet)) {
                    return temp.length();
                }
            }
        }
        return -1;
    }

    static public boolean containsAllElements(Set<Character> first, Set<Character> second) {
        Set<Character> lower1 = new HashSet<>();
        Set<Character> lower2 = new HashSet<>();
        first.forEach((e) -> {
            lower1.add(Character.toLowerCase(e));
        });
        second.forEach((e) -> {
            lower2.add(Character.toLowerCase(e));
        });
        
        return lower1.containsAll(lower2) && lower1.size() == lower2.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("ABcabbCa"));
        System.out.println(solution("azABaabza"));
        System.out.println(solution("CATattac"));
        System.out.println(solution("TacoCat"));
        System.out.println(solution("Madam"));
        System.out.println(solution("AcZCbaBz"));
        System.out.println(solution("aZABcabbCa"));
    }
}

// char[] s = S.toCharArray();
        
//         boolean upper[] = new Boolean[26];
//         boolean lower[] = new Boolean[26];
//         Arrays.fill(upper, false);
//         Arrays.fill(lower, false);
        
//         for (int i = 0; i < s.length; i ++) {
//             if (Character.isUpperCase(s[i])) {
//                 boolean upper[s[i] - 'A'] = true;
//             }
//             if (Character.isLowerCase(s[i])) {
//                 boolean lower[s[i] - 'a'] = true;
//             }
//         }
        
//         int left = s[0];
//         int right = s[length - 1]
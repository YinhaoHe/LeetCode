import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        if (pages.size() == 0)
            return 0;
        List<Integer> cache = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < pages.size(); i++) {
            if (cache.contains(pages.get(i))) {
                cache.remove(pages.get(i));
            } else {
                count++;
                if (maxCacheSize == cache.size())
                    cache.remove(0);
            }
            cache.add(pages.get(i));
        }
        return count;
    }

}
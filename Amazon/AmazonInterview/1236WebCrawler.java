/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    
    // find the startUrl 
    // get the homeUrl from all urls - split the string
    // remove the duplicate - use Set
    
    private Set<String> res = new HashSet<>();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = getUrl(startUrl);
        res.add(startUrl);
        dfs(startUrl, host, htmlParser);
        return new ArrayList<>(res);
    }
    
    public void dfs(String startUrl, String host, HtmlParser htmlparser) {
        List<String> urls = htmlparser.getUrls(startUrl);
        for (String url : urls) {
            if (res.contains(url) || !getUrl(url).equals(host)) continue;
            res.add(url);
            dfs(url, host, htmlparser);
        }
    }
    
    public String getUrl(String url) {
        String[] args = url.split("/");
        return args[2];
    }
}



/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    
    private Set<String> res = new HashSet<>(); // remove duplicate
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = getUrl(startUrl); // get host
        Queue<String> q = new LinkedList<>(); // bfs queue
        res.add(startUrl);
        q.offer(startUrl);
        
        while(q.size() > 0) {
            String url = q.poll();
            List<String> urls = htmlParser.getUrls(url);
            
            for (String u : urls) {
                if (res.contains(u) || !getUrl(u).equals(host)) continue;
                res.add(u);
                q.offer(u);
            }
        }
        return new ArrayList<>(res);
    }
    
    public String getUrl(String url) {
        String[] args = url.split("/");
        return args[2];
    }
}
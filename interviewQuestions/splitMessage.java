import java.util.*;

class Solution{

	public static List<String> segments(String message) {
	    int lastSpace = 0, curStart = 0, totalSplit = 0, count = 0, i = 0;
	    List<String> ans = new ArrayList<String>();

	    while (i < message.length()) {
	    	count ++;
	    	if (message.charAt(i) == ' ') {
	    		lastSpace = i;
	    	}

	    	if (count == 155) {
	    		if (message.charAt(i) != ' ') {
	    			if (i < message.length() - 1 && message.charAt(i + 1) == ' ' || i == message.length() - 1) {
	    				lastSpace = i;
	    			}
	    		}
	    		totalSplit ++;
	    		count = 0;
	    		ans.add(message.substring(curStart, lastSpace + 1));

	    		if (i > lastSpace) {
	    			i = lastSpace;
	    		}

	    		curStart = i + 1;

	    	}
	    	i ++;
	    }

	    if (curStart < message.length()) {
	    	if (totalSplit == 0) {
	    		ans.add(message);
	    		return ans;
	    	}
	    	ans.add(message.substring(curStart));
	    	totalSplit ++;
	    }

	    if (ans.size() > 1) {
	    	for (int j = 0; j < ans.size(); j  ++) {
	    		ans.set(j, ans.get(j) + "(" + (j + 1) + "/" + (ans.size()) + ")");
	    	}
	    }

	    return ans;
	}

	public static void main(String args[]) {
        String a = "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg";

        for (String str : segments(a)) {
            System.out.println(str);
        }

    }
}



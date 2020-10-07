/*

Given a String, convert all space character to "%20" ASCII number

*/

import java.util.*;

class URLify {
	public String makeURL (String s) {
		String res = s.trim().replace(" ", "%20");
		return res;
	}

	public static void main(String[] args) {
		String s = "   I love you";
		URLify urlify = new URLify();
		System.out.println(urlify.makeURL(s));
	}
}

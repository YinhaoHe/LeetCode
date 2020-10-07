/*

Given a String, convert all space character to "%20" ASCII number

*/

import java.util.*;

/*

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

*/

class URLConvertor {
	public String urlify(String url) {

		char[] result = new char[url.length() + 4];
		url = url.trim();

		char[] urlChars = url.toCharArray();

		int pointer = 0;

		for (int i = 0; i < urlChars.length; i ++) {
			if (urlChars[i] != ' ') {
				result[pointer] = urlChars[i];
				pointer ++;
			} else {
				result[pointer] = '%';
				result[pointer + 1] = '2';
				result[pointer + 2] = '0';
				pointer += 3;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char res : result) {
			sb.append(res);
		}

		//String str = Arrays.toString(result); return will be array
		return sb.toString();
		// return String.valueOf(result); this is doable
	}

	public static void main(String[] args) {
		String s = "I love u";
		URLConvertor urlConvertor = new URLConvertor();
		System.out.println(urlConvertor.urlify(s));
	}
}





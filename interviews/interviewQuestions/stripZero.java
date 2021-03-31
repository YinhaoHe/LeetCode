// stripZero from a string
// Use recrusion get rid of a 0 at a time

public class Solution{

	public String stripZeros(String str) {
		if (str.startWith("0")) {
			String subString = str.substring(1);
			String newStr = stripZeros(subString);
			return newStr;
		}
		return str;
	}

}
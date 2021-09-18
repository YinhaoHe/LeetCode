// https://leetcode.com/discuss/interview-question/1010329/goldman-sachs-online-encode-string

public class DecodeString {
	private static void decode(String input, int[] output) {
		int len = input.length();
		int num = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (input.charAt(i) == ')') {
				int k = i - 1;
				int p = 1;
				while (k >= 0 && input.charAt(k) != '(') {
					num = p * (input.charAt(k) - '0') + num;
					k--;
                    p *= 10;
				}
				i = k + 1;
			} else if (input.charAt(i) == '#') {
				int sum = (input.charAt(i - 2) - '0') * 10 + (input.charAt(i - 1) - '0');
				output[sum - 1] += num == 0 ? 1 : num;
				i -= 2;
				num = 0;
			} else if (Character.isDigit(input.charAt(i))) {
				output[input.charAt(i) - '0' - 1] += num == 0 ? 1 : num;
				num = 0;
			}
		}
	}

	public static void main(String[] args) {
		String input1 = "23#(2)24#25#26#23#(3)°";
		int[] output1 = new int[26];
		decode(input1, output1);
		for (int i = 0; i < 26; i++)
			System.out.print(output1[i] + " ");
		System.out.println();
		
		String input2 = "1226#24#";
		int[] output2 = new int[26];
		decode(input2, output2);
		for (int i = 0; i < 26; i++)
			System.out.print(output2[i] + " ");
		System.out.println();
	}

}
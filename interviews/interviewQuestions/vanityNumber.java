import java.util.*;

class Result{

	public static List<String> vanity(List<String> codes, List<String> numbers) {
		List<String> res = new ArrayList<>();

		HashMap<Character, String> map = new HashMap<Character, String>(){
			{
				put('A', "2");
				put('B', "2");
				put('C', "2");
				put('D', "3");
				put('E', "3");
				put('F', "3");
				put('G', "4");
				put('H', "4");
				put('I', "4");
				put('J', "5");
				put('K', "5");
				put('L', "5");
				put('M', "6");
				put('N', "6");
				put('O', "6");
				put('P', "7");
				put('Q', "7");
				put('R', "7");
				put('S', "7");
				put('T', "8");
				put('U', "8");
				put('V', "8");
				put('W', "9");
				put('X', "9");
				put('Y', "9");
				put('Z', "9");
			}
		};

		List<String> convertedCodes = convert(codes, map);
		Set<String> set = new HashSet<>();
		for (String number : numbers) {
			if (number.length() > 16) {
				continue;
			}
			for (int i = 0; i < convertedCodes.size(); i ++) {
				if (ifContains(number, convertedCodes.get(i))) {
					if (!set.contains(number)) {
						set.add(number);
					}
				}
			}
		}
		res = new ArrayList<>(set);
		Collections.sort(res);

		return res;

	}

	private static List<String> convert(List<String> codes, HashMap<Character, String> map) {
		List<String> convertedCode = new ArrayList<>();
		for (String code : codes) {
			String s = "";
			for (int i = 0; i < code.length(); i ++) {
				s += map.get(code.charAt(i));
			}
			convertedCode.add(s);
		}
		return convertedCode;
	}

	private static boolean ifContains(String number, String convertedCode) {
		if (number.indexOf(convertedCode) == -1) {
			return false;
		}
		return true;
	}

	public static void main(String args[]) {
		List name = Arrays.asList("TWLO", "CODE", "HTCH");
		List numbers = Arrays.asList("+17474824380", "+14157088956", "+919810155555", "+15109926333", "+1415123456");
		for (Object str : vanity(name, numbers)) {
			System.out.println(str);
		}	
	}

}

/*

import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');
        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');
        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');
        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');
        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');
        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');
        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');
        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');
        List name = Arrays.asList("TWLO", "CODE", "HTCH");
        List nameToNum = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            String curr = (String)name.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < curr.length(); j++) {
                sb.append(map.get(curr.charAt(j)));
            }
            nameToNum.add(sb.toString());
        }
        List numbers = Arrays.asList("+17474824380", "+14157088956", "+919810155555", "+15109926333", "+1415123456");
        List out = new ArrayList<>();

        for (int i = 0; i < nameToNum.size(); i++) {
            out.add(findMatch((String)nameToNum.get(i), numbers));
        }

        Collections.sort(out);
        for (Object str : out) {
            System.out.println(str);
        }
    }

    public static String findMatch(String find, List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).contains(find)) {
                return numbers.get(i);
            }
        }
        return "";
    }
}

*/
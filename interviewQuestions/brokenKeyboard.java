int brokenKeyboard(String text, char[] letters) {
    
    List<Character> list = new ArrayList<Character>();
    for (int i = 0; i < letters.length; i ++) {
        list.add(letters[i]);
    }
    
    if (letters.length == 0) {
        return text.split(" ").length;
    }
    
    int res = 0;
    boolean flag = false;
    String[] words = text.toLowerCase().split(" ");
    for (String word: words) {
        for (Character i: word.toCharArray()) {
            if (Character.isLowerCase(i)) {
                if (!list.contains(i)) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            res++;
        } else {
            flag = false;
        }
    }
    return res;
}
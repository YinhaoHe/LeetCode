int oddOccurrencesOfZeros(int[] a) {
    
    int count = 0;
    for (int i = 0; i < a.length; i ++) {
        
        String str = null;
        str = Integer.toString(a[i]);
        int[] arr = new int[str.length()];
        for (int j = 0; j < arr.length; j ++) {
            char c = str.charAt(j);
            String s = String.valueOf(c);
            int num = Integer.parseInt(s);
            arr[j] = num;
        }
        
        int zeroCount = 0;
        for (int k = 0; k < arr.length; k ++) {
            if (arr[k] == 0) {
                zeroCount ++;
            }
        }
        if (zeroCount % 2 != 0) {
            count ++;
        }
        
    }
    return count;
}
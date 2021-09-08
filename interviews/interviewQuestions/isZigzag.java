int[] isZigzag(int[] numbers) {
    ArrayList<Integer> listResults = new ArrayList<>();
    int left, mid, right;
    for (int i = 0; i < numbers.length - 2; ++ i) {
        left = i;
        mid = i + 1; 
        right = i + 2;
        if (numbers[mid] > numbers[left] && numbers[mid] > numbers[right]) {
            listResults.add(1);
        } else if (numbers[mid] < numbers[left] && numbers[mid] < numbers[right]) {
            listResults.add(1);
        } else {
            listResults.add(0);
        }
    }
    int[] results = new int[listResults.size()];
    for (int i = 0; i < listResults.size(); ++ i) {
        results[i] = listResults.get(i);
    }
    return results;
}

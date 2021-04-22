class Solution {
    public String intToRoman(int num) {
        // 直接定义一个data数组和num一一对应
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = nums.length - 1; //index of nums
        StringBuilder res = new StringBuilder();
        
        //loop until num = 0
        while(num != 0) {
            if (num < nums[i]) i--;
            else {
                num -= nums[i];
                res.append(rom[i]);
            }
        }
        return res.toString();
    }
}
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
class Solution {
    public List<String> helper(List<String> init, int digit, String arr[]) {
        List<String> list = new ArrayList<>();

        for(String prefix: init) {
            for(char c : arr[digit].toCharArray()) 
                list.add(prefix+c);
        }

        return list;
    }

    public List<String> letterCombinations(String digits) {
        // Create an array of arrayList
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> init = new ArrayList<>();

        // Base Case
        if(digits.length() == 0) return init;
        
        // Initialization
        int dig = digits.charAt(0) - '0';
        for(char c : arr[dig].toCharArray()) {
            init.add(String.valueOf(c));
        }

        for(int i=1; i<digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            init = helper(init, digit, arr);
        }

        return init;
    }
}

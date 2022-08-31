/*
5 main variable: 
digits: string digit inputs
list: list of string output
map: mapping of each number; first two {} are 0 and 1
sb: temp list to keep current list; will add result to list when reach condition; 
startindex  = start index 

int num = digits.charAt(startIndex) - '0';
will gain the corresponding num after sustraction of 0--> map[num]

*/
class Solution {
    public List<String> letterCombinations3(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(digits, 0, mapping, res, new StringBuilder());
        return res;
    }
    
    private void helper(String digits, int index, String[] mapping, 
        List<String> res, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        } else {
            String digit = digits.substring(index, index + 1);
            for (char c : mapping[Integer.parseInt(digit)].toCharArray()) {
                sb.append(c);
                helper(digits, index + 1, mapping, res, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}

########
String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<String>();
    if(digits == null || digits.length() == 0) return result;
    backtracking(result, new StringBuilder(), digits, 0);
    return result;
}

public void backtracking(List<String> result, StringBuilder sb, String digits, int index) {
    if(index == digits.length()) {
        result.add(sb.toString());
        return;
    }
    
    String str = chars[digits.charAt(index) - '0'];
    for(char c : str.toCharArray()) {
        sb.append(c);
        backtracking(result, sb, digits, index + 1);
        sb.setLength(sb.length() - 1);
    }
}
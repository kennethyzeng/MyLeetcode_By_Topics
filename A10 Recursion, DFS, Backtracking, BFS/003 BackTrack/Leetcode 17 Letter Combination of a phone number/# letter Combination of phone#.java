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
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) 
            return list; 
        
        char[][]map = {{}, {}, {'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'},{'j', 'k', 'l'},{'m', 'n', 'o'},{'p', 'q', 'r','s'},{'t', 'u', 'v'},{'w', 'x', 'y','z'}};
        
        backtracking(digits, list, map, new StringBuilder(), 0);
        return list; 
        
    }
    
    private void backtracking(String digits, List<String> list, char[][] map, StringBuilder sb, int startIndex){
        if (startIndex == digits.length()){
            list.add(new String(sb));
            return; 
        }
        int num = digits.charAt(startIndex) - '0';
        for (int i = 0; i < map[num].length; i ++){
            sb.append(map[num][i]);
            backtracking(digits, list, map, sb, startIndex + 1);
            sb.deleteCharAt(sb.length() -1);
        }
        
    }
}
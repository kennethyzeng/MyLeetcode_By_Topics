/*
Time Complexity: see video
Space Complexity:

*/ 

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<> ();
        //corner case 
        if (n < 0) return res; 
        dfs("", n, n, res); 
        return res; 
    }
    
    private void dfs(String curr, int left, int right, List<String> res){
        //base case 
        if (left == 0 && right == 0){
            res.add(curr); 
            return; 
        }
        
        if (left > 0){
            dfs(curr + "(", left -1, right, res);
        }
        
        if (right > left && right > 0){
            dfs(curr + ")", left, right -1, res);
        }
    }
}

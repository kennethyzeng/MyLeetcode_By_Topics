/*
Time Complexity: see video
Space Complexity:
time : I would say worst case is O(2 ^ 2n),even though some guys say it should be O(2 ^ n)
space : O(n)

StringBuilder Vs STring. see the difference
*/ 

public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        StringBuilder curr = new StringBuilder();
        backTracking(n, n, res, curr);
        return res;
    }
    private void backTracking(int left, int right, List<String> res, StringBuilder curr){
        if(left == 0 && right == 0){
            res.add(curr.toString());
            return;
        }
        if(left > 0){
            curr.append("(");
            backTracking(left - 1, right, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(right > left){
            curr.append(")");
            backTracking(left, right - 1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }


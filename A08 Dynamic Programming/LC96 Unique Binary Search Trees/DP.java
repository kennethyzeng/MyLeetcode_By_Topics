class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1; 
        
        int res = 0; 
        for(int i = 0; i <n; i++){
            res += numTrees(i) * numTrees(n-1 -i);
        }
        return res; 
    }
}
/*


*/ 
//18ms

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0; 
        
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int price:prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
        
    }
}

////1 ms
class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
}
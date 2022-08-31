/*
Dynamic programming: three different code below. same concept

Time: O(n)
Space: O(1)
*/ 

public int minCost(int []][] costs){
    if (costs == null || cost.length == 0) return 0; 
    for (int i =1; i < cost.length; i ++){     //i =1
        cost[i][0] += Math.min(costs[i-1][1],cost[i-1][2]);
        cost[i][1] += Math.min(costs[i-1][0],cost[i-1][2] );
        cost[i][2] += Math.min(costs[i][0],cost[i-1][1] );
    }
    int n = costs.length -1; 
    return Math.min(costs[n][0],Math.min(cost[n][1], costs[n][2]))
}


##########easier to understnad
public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }
}

###################
class Solution {
public:
    int minCost(int[][] costs) {
        if (costs.empty() || costs[0].empty()) return 0;
        int[][] dp = costs;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                dp[i][j] += min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }
};
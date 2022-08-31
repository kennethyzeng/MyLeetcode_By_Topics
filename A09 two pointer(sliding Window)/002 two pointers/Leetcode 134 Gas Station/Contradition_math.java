/*
Time Complexity: O(n)
Space Complexity: O(1)

*/ 

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0; // it will give us a difference b/w gas & cost
        int surplus = 0; // our tank
        int start = 0; // and the index of gas station
        
        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){ // if the tank goes -ve
                surplus = 0; // reset our tank
                start = i + 1; // and update the stating gas station
            }
        }
        return (total_surplus < 0) ? -1 : start;
        
    }
}



########
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainGas = 0; 
        int totalGas = 0; 
        int totalCost = 0; 
        int i = 0;
        
        for (int j = 0; j < gas.length; j++){
            totalGas += gas[j]; 
            totalCost += cost[j];
        }
        if (totalGas < totalCost)
            return -1; 
        
        for(int j = 0; j < gas.length; j++){
            remainGas += gas[j] - cost[j];
            if (remainGas < 0){
                i = j+1;
                remainGas = 0;
            }
        }
        
        return i; 
        
    }
}



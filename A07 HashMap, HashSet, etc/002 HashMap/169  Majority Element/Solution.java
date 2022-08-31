/*
Time Complexity:
Space Complexity:

*/ 


public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}

#######
public int majorityElement(int[] nums) {
    int L = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<L; i++) {
        if(map.containsKey(nums[i])) {
            if(map.get(nums[i]) >= L/2)
                return nums[i];
            map.replace(nums[i], map.get(nums[i])+1);
        }
        else
            map.put(nums[i], 1);
    }
    return nums[L-1];
}
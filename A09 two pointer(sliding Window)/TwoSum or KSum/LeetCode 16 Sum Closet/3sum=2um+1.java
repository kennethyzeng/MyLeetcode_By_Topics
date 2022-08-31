//2ms 
logo
Explore
Problems
Interview
Contest
Discuss
Store
🚀 September LeetCoding Challenge 2021 🚀

Premium
3
3Sum Closest
Submission Detail
131 / 131 test cases passed.
Status: Accepted
Runtime: 6 ms
Memory Usage: 38.7 MB
Submitted: 1 minute ago
Accepted Solutions Runtime Distribution
020406080100120140160510152025
java
You are here!
Your runtime beats 61.32 % of java submissions.
Runtime (ms)Distribution (%)

0204060801001201401601020
Zoom area by dragging across this chart

Accepted Solutions Memory Distribution
330003400035000360003700038000390004000024681012
java
You are here!
Your memory usage beats 57.22 % of java submissions.
Memory (KB)Distribution (%)

3300034000350003600037000380003900040000510
Zoom area by dragging across this chart
Invite friends to challenge 3Sum Closest
25
Submitted Code: 1 minute ago
Language: java

Back to problem
×Close
sample 2 ms submission
class Solution {
    int diff = Integer.MAX_VALUE;
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && diff != 0; i++) {
            twoSumClosest(nums, i, target);
        }       
        
        return target - diff;
    }
    
    public void twoSumClosest(int[] nums, int current, int target) {
        int low = current + 1;
        int high = nums.length - 1;
        
        while (low < high) {
            int sum = nums[current] + nums[low] + nums[high];
            if (sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            }
            
            if (Math.abs(target - sum) < Math.abs(diff)) {
                diff = target - sum;
                if (diff == 0)
                    return;
            }
        }
    }
}


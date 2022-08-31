class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length
        while(i<j){
            int sum = numbers[i] + numbers[j];
            
            if(sum < target) {
                i++;
            } else if (sum > target){
                j--;
            } else{
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }
}

//////////////////////
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[]{i+1,j+1};
            
            if(sum > target) j--;
            else i++;
        }
        return null;
    }
}


////////////////////////////////
public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while(start < end){
            if(numbers[start] + numbers[end] == target) break;
            if(numbers[start] + numbers[end] < target) start++;
            else end--;
        }
        return new int[]{start + 1, end + 1};
    }
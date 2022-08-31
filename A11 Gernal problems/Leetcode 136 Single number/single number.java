/*


*/ 


class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}


##############
class Solution {
    public int singleNumber(int[] nums) {
        int sumOfSet = 0; int sumOfNums = 0;
        Set<Integer> set = new HashSet();
        
        for (int num : nums) {
            if (!set.contains(num)){
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
    return (2*sumOfSet - sumOfNums);
    }
}
/*
First, set the two pointers i to index 0 and j to index length - 1 respectively.
If the sum of i + j is greater than the target, find the biggest number that is smaller than target - numbers[left]

First, check if the number on the left of the right pointer is smaller than target - numbers[left]. If it is, then move the right pointer one to the left.
However, if it is not, then use binary search to find the biggest number smaller than target - numbers[left].
On the other hand, if the sum is smaller than the target, then find the smallest number that is larger than target - nums[right]

Check if the number on the right of the left pointer is greater than target - nums[right]. If it is, move the left pointer one to the right.
However, if it is not, then use binary search to find the smallest number that is larger than target - nums[right].
In this way, the average case would be O(logn), since we divide by half every time. However, the worst case scenario would be O(n), if the pointers have to move by 1 every single time.

Note that it is not doing binary search for every move, but only for moves where the number to the left of the right pointer OR the number to the right of the left pointer do not fulfill the condition.

If you didn't understand, maybe checking @samuelkanezhao2 explanation might help
*/

public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) {
            if (numbers[r - 1] > target - numbers[l])
                r = binarySearch(numbers, l + 1, r - 1, target - numbers[l]);
            else
                r--;
        } 
		else {
            if (numbers[l + 1] < target - numbers[r])
                l = binarySearch(numbers, l + 1, r - 1, target - numbers[r]);
            else
                l++;
        }
    }
    return new int[] { l + 1, r + 1 };
}

private int binarySearch(int[] nums, int lo, int hi, int target) {
    int mid = (lo + hi) / 2;
    if (hi <= lo)
        return mid;
    if (nums[mid] == target)
        return mid;
    else if (nums[mid] > target)
        return binarySearch(nums, lo, (mid - 1), target);
    else if (nums[mid] < target)
        return binarySearch(nums, (mid + 1), hi, target);
    return mid;
}
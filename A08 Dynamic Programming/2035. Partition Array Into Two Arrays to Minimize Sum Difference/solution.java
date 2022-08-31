/*
Time Complexity:
Space Complexity:
https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/discuss/1513541/Java-meet-in-the-middle-and-two-pointers.-Time-O(n-*-2(n2))-Space-O(2(n2))
*/ 

class Solution {
    public int minimumDifference(int[] nums) {
    int L = nums.length;
    int[][] diff1 = generate(Arrays.copyOfRange(nums, 0, L / 2));
    int[][] diff2 = generate(Arrays.copyOfRange(nums, L / 2, L));

    int min = Integer.MAX_VALUE;
    for (int len = 0; len <= L / 2; len++) {
        int[] left = diff1[len];
        int[] right = diff2[len];

        int l = 0;
        int r = 0;

        while(l < left.length && r < left.length) {
            //arrays are already sorted so we move one pointer at a time to make the diff closer to 0
            int diff = left[l] - right[r];
            min = Math.min(min, Math.abs(diff));
            if (diff < 0) l++;
            else if (diff > 0) r++;
            else return 0;
        }
    }

    return min;
}

private int[][] generate(int[] arr) { //generate sets[i][]: all the results of subsetSum(len == i) - subsetSum(len == n - i)
    int n = arr.length;
    int[][] ans = new int[n + 1][]; //n + 1 for length can be 0

    int combo = 1;
    ans[0] = new int[combo]; //when len is 0, there is only one possibility
    for (int i = 1; i <= n; i++) { //how many combos there are when len is i
        combo = combo * (n - i + 1) / i;
        ans[i] = new int[combo];
    }

    int total = 0;
    for (int i : arr) total += i;

    int limit = 1 << n; //using bits to represent the combos: 1 means the number at that index is chosen to form the subset
    int[] counter = new int[n + 1]; //used to keep the current index for each length
    for (int i = 0; i < limit; i++) {
        int subSum = 0;
        for (int j = 0; j < n; j++) {
            if ((i >> j & 1) == 1) subSum += arr[j];
        }

        int rest = total - subSum;
        //instead of storing the subSum we store the difference to avoid binary search later
        //(sub1 - rest1) - (sub2 - rest2) = (sub1 + rest2) - (sub2 + rest1) = what the prob is asking for
        //(sub1 + rest2) and (sub2 + rest1) are of the same length

        int lenOfSub = Integer.bitCount(i);
        ans[lenOfSub][counter[lenOfSub]++] = subSum - rest;
    }

    for (int[] a : ans) Arrays.sort(a);

    return ans;
}

}

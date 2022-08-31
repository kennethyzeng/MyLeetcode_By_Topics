/*From DP to Greedy O(n), with explanation, easy way to see this problem
We could see this problem in a DP view and with some tricks we could do it in a greedy way which is O(n) time complexity.
Let's define S(i...j) to be the max volume from index i to j and v(i, j) be the volume of the container with boundary i and j . So we just need to figure out S(0...n) (0 and n are the leftmost and rightmost index of the array).
It is easy to derive that S(0..n) = max{v(0, n), S(1...n), S(0...n-1)}, and the time complexity is O(n^2). But we can optimize it. WLOG(without loss of generality), we assume height(0) > height(n), then we can simplify S(0..n) as S(0...n) = max{v(0, n), S(0...n-1)} and the complexity is O(n). Below is the proof :
1, if v(0, n) is the largest volume, sicne we have figured out the result, the simplifier is all right.
2, if not, we could find out that n can't be the boundry of the container. If n is the right boundry, becaues of height(0) > height(n) , the max volumn must be height(n) * (n - 0) = v(0, n), which arrives at a contradiction. So S(1...n) can be simplified as S(1...n-1) which is included in S(0...n-1).
The code is from the forum and mainly from https://discuss.leetcode.com/topic/16754/simple-and-fast-c-c-with-explanation/5
The relationship can be represented as :

           / max{v(i, j), S(i...j-1)};  height(i) >= height(j)
S(i..j) = |
           \ max{v(i, j), S(i+1...j)};  height(i) < height(j)


*/ 
public class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while(lo < hi) {
            int min = Math.min(height[lo], height[hi]);
            max = Math.max(max, min * (hi - lo));
            while(lo <= hi && height[lo] <= min) lo++;
            while(lo <= hi && height[hi] <= min) hi--;
        }
        return max;
    }
}


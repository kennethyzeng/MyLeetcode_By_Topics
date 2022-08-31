class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int  i = m - 1; 
        int j = n - 1;
        int k = m + n -1; 
        
        while ( i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        //nums1[k--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--])
        
        while (j >= 0){        // case: nums1 is doned but nums2 still have element to sorted;
            nums1[k--] = nums2[j--];
        }
        
        
    }
}
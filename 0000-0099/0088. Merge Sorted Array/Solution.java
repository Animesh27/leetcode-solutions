class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int insertIndex = (m+n) - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] < nums2[j]){
                nums1[insertIndex--] = nums2[j];
                j--;
            } else if(nums1[i] >= nums2[j]){
                nums1[insertIndex--] = nums1[i];
                i--;
            }
        }

        while(j >= 0){
            nums1[insertIndex--]= nums2[j];
            j--;
        }
        while(i >= 0){
            nums1[insertIndex--]= nums1[i];
            i--;
        }
    }
}
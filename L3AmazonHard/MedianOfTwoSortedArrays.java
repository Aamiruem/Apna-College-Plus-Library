// package L3AmazonHard;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 > N2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = N1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (N1 + N2 + 1) / 2 - mid1;

            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            double r1 = (mid1 == N1) ? Integer.MAX_VALUE : nums1[mid1];
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            double r2 = (mid2 == N2) ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((N1 + N2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 5, 7};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Output: 3.0
    }
}

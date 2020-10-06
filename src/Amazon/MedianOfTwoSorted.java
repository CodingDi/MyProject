package Amazon;

public class MedianOfTwoSorted {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if (len % 2 == 0) {
                int a = helper(nums1, 0, nums2, 0, len/2 + 1);
                int b =  helper(nums1, 0, nums2, 0, len/2);
                return (a + b) / 2.0;
            } else {
                return helper(nums1, 0, nums2, 0, len/ 2 + 1);
            }



        }

        private int helper(int[] a, int aleft, int[] b, int bleft, int k) {
            if (aleft >= a.length) {
                return b[bleft + k - 1];
            }

            if (bleft >= b.length) {
                return a[aleft + k - 1];
            }

            if (k == 1) {
                return Math.min(a[aleft], b[bleft]);
            }

            int amid = aleft + k/2 - 1;
            int bmid = bleft + k/2 - 1;

            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

            if (aval > bval) {
                return helper(a, aleft, b, bmid + 1, k - k/2);

            } else {
                return helper(a, amid + 1, b, bleft, k - k/2);
            }
        }

}

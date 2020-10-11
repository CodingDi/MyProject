package Array;

public class Candy {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            //use two arrays, one used for start at 0, go right and check left back
            //another used for start at the end, go left and check right back
            int n = ratings.length;
            int[] left = new int[n];
            left[0] = 1;
            int[] right = new int[n];

            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }


            right[n - 1] = 1;
            int total = Math.max(left[n - 1], right[n - 1]);

            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
                total += Math.max(left[i], right[i]);
            }

            return total;

    }
}

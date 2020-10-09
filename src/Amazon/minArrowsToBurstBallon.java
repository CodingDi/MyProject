package Amazon;

import java.util.Arrays;

public class minArrowsToBurstBallon {

    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length == 0) {
                return 0;
            }


            //in case of overflow
            Arrays.sort(points, (a, b) -> {
                if (a[1] > b[1]) {
                    return 1;
                } else {
                    return -1;
                }
            });


            int cnt = 1;
            int prevStart = points[0][0];
            int prevEnd = points[0][1];

            for (int i = 1; i < points.length; i++) {
                int start = points[i][0];
                int end = points[i][1];

                if (prevEnd < start) {
                    cnt++;
                    prevEnd = end;
                }

            }

            return cnt;
        }
    }

}

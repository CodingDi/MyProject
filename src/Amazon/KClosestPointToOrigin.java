package Amazon;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
        public int[][] kClosest(int[][] points, int K) {
            if(points.length <= K){
                return points;
            }
            //maintain a maxheap of size k
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] -a[1]*a[1]));

            for(int[] point: points){
                pq.offer(point);

                if(pq.size() > K){
                    pq.poll();//poll the farest one
                }
            }

            int[][] res = new int[K][2];
            int end = K - 1;
            while(!pq.isEmpty()){
                res[end--] = pq.poll();
            }

            return res;
        }



}

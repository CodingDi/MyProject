package PQ;

import java.util.PriorityQueue;

public class ConnectSticks {


        public int connectSticks(int[] sticks) {

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < sticks.length; i++) {
                pq.offer(sticks[i]);
            }

            int res = 0;

            while (pq.size() > 1) {
                int first = pq.poll();
                int second = pq.poll();
                int cur = first + second;
                res += cur;
                pq.offer(cur);
            }

            return res;
        }

}

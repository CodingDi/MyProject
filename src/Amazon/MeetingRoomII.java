package Amazon;
import java.util.*;

public class MeetingRoomII {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
            int roomNumber = 1;

            PriorityQueue<int[]> rooms = new PriorityQueue<>(new Comparator<>() {
                @Override
                public int compare(int[] meeting1, int[] meeting2) {
                    int endTime1 = meeting1[1];
                    int endTime2 = meeting2[1];
                    if (endTime1 == endTime2) {
                        return 0;
                    }
                    return endTime1 > endTime2 ? 1 : -1;
                }
            });

            rooms.offer(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                int[] curInterval = intervals[i];
                if (rooms.peek()[1] <= curInterval[0]) {
                    //case1. no overlap, update end time
                    int[] prevInterval = rooms.poll();
                    prevInterval[1] = curInterval[1];
                    rooms.offer(prevInterval);
                } else {
                    //case2. has overlap, offer a new one
                    rooms.offer(curInterval);
                    roomNumber++;
                }
            }
            return roomNumber;
        }
    }

// prev[1] > curInterval[0] cnt++//overlap
// else prv[1] = Max()//no overlap, update endtime
}

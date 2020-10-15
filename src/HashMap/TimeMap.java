package HashMap;
import java.util.*;
public class TimeMap {

    class Data {
        String val;
        int time;
        Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }


        /** Initialize your data structure here. */
        Map<String, List<Data>> map;
        public TimeMap() {
            map = new HashMap<String, List<Data>>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) map.put(key, new ArrayList<Data>());
            map.get(key).add(new Data(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            return binarySearch(map.get(key), timestamp);
        }

        protected String binarySearch(List<Data> list, int time) {
            int left = 0;
            int right = list.size() - 1;

            while (left < right - 1) {
                int mid = left + (right - left)/2;
                Data midLog = list.get(mid);
                if (midLog.time == time) {
                    return midLog.val;
                }
                if (midLog.time < time) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            if (list.get(right).time <= time) {
                return list.get(right).val;
            }

            if (list.get(left).time <= time) {
                return list.get(left).val;
            }

            return "";
        }

}

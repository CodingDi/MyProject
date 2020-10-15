package HashMap;
import java.util.*;
public class TimeMapTreeMap {

        //hashmap + treemap way
        Map<String, TreeMap<Integer, String>> map;

        /** Initialize your data structure here. */
        public TimeMapTreeMap() {
            map = new HashMap<>();
        }
        //time: O(1) for set,  O(logN) for get
        //space:O(n)
        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            TreeMap<Integer, String> values = map.get(key);
            Integer res = values.floorKey(timestamp);
            return res == null ? "" : values.get(res);

    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}

package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationsForTelephonePasI {
        public String[] combinations(int number) {
            //construct a map of intege with char[]
            Map<Character, char[]> map = new HashMap<>();
            map.put('2', new char[]{'a', 'b', 'c'});
            map.put('3', new char[]{'d', 'e', 'f'});
            map.put('4', new char[]{'g', 'h', 'i'});
            map.put('5', new char[]{'j', 'k', 'l'});
            map.put('6', new char[]{'m', 'n', 'o'});
            map.put('7', new char[]{'p', 'q', 'r', 's'});
            map.put('8', new char[]{'t', 'u', 'v'});
            map.put('9', new char[]{'w', 'x', 'y', 'z'});

            StringBuilder sb = new StringBuilder();
            List<String> strs = new ArrayList<>();
            char[] nums = Integer.toString(number).toCharArray();
            //for the input string, at each index, try all char to append and call next index for recursion
            helper(strs, nums, 0, sb, map);
            String[] res = new String[strs.size()];
            return strs.toArray(res);

        }

        private void helper(List<String> strs, char[] nums, int index, StringBuilder sb, Map<Character, char[]> map) {
            //base case
            if (index == nums.length) {
                strs.add(sb.toString());
                return;
            }

            //iterate the corresponding char

            if (nums[index] == '0' || nums[index] == '1') {
                helper(strs, nums, index + 1, sb, map);
                return;
            }

            for (char c : map.get(nums[index])) {
                sb.append(c);
                helper(strs, nums, index + 1, sb, map);
                //go back
                sb.deleteCharAt(sb.length() - 1);
            }

        }



}

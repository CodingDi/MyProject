package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
        public List<String> Restore(String ip) {
            List<String> res = new ArrayList<>();

            //corner case
            if (ip == null) {
                return res;
            }

            char[] input = ip.toCharArray();
            StringBuilder sb = new StringBuilder();

            helper(res, sb, input, 0, 0);
            return res;

        }

        //level: how many ips generated so far 0-4
        //index: the index in the input[]
        private void helper(List<String> res, StringBuilder sb, char[] input, int level, int index) {
            //base case
            if (index == input.length) {
                if (level == 4) {
                    res.add(sb.substring(0, sb.length() - 1));
                }
                return;
            }

            //recursion
            //for 1-digit IP
            if (index < input.length) {
                sb.append(input[index]).append('.');
                helper(res, sb, input, level + 1, index + 1);
                sb.delete(sb.length() - 2, sb.length());
            }

            //for 2-digit
            if (index + 1 < input.length) {
                if (input[index] != '0') {
                    sb.append(input[index]).append(input[index + 1]).append('.');
                    helper(res, sb, input, level + 1, index + 2);
                    sb.delete(sb.length() - 3, sb.length());
                }
            }

            //for 3-digit
            if (index + 2 < input.length) {
                char a = input[index];
                char b = input[index + 1];
                char c = input[index + 2];
                if (a == '0' || a >= '3') {
                    return;
                }
                if (a == '1' || b < '5' || b == '5' && c <= '5') {
                    sb.append(a).append(b).append(c).append('.');
                    helper(res, sb, input, level + 1, index + 3);
                    sb.delete(sb.length() - 4, sb.length());
                }
            }



        }

}

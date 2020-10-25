package String;

public class LongestPalindromeSubstring {

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            int left = 0;
            int right = 0;

            for (int i = 0; i < s.length(); i++) {
                int odd = expand(s, i, i);
                int even = expand(s, i, i + 1);
                int cur = Math.max(odd, even);
                if (right - left + 1 < cur) {
                    left = i - (cur - 1)/2;
                    right = i + cur/2;
                }
            }

            return s.substring(left, right + 1);
        }

        private int expand(String s, int left, int right) {
            if (left > right) {
                return 0;
            }
            int length = 0;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                length++;
                left--;
                right++;
            }
            return right - left - 1;
        }

}

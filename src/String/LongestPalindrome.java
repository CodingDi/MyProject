package String;

public class LongestPalindrome {

        public String longestPalindrome(String s) {
            //for each chr, try both case of even parlindrom and odd parlindrome
            if (s == null || s.length() <= 1) {
                return s;
            }

            int left = 0;
            int right = 0;

            for (int i = 0; i < s.length() - 1; i++) {
                int even = expand(s, i, i + 1);
                int odd = expand(s, i, i );
                int cur = Math.max(even, odd);
                if (cur > right - left + 1) {
                    left = i - (cur - 1)/2;
                    right = i + cur/2;
                }
            }

            return s.substring(left, right + 1);
        }

        //helper functipn returns the longest parlindrom substring centered at left and right
        // cbbd
        // left: 1  0
        // right: 1   2

        private int expand(String str, int left, int right) {
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }


}

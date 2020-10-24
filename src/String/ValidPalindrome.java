package String;

public class ValidPalindrome {

        public boolean isPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return true;
            }
            s = s.toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }

                while (j > i && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }

                if (i < j && s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }

}

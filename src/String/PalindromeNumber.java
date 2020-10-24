package String;

public class PalindromeNumber {

        public boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0) {
                return false;
            }

            String number = String.valueOf(x);
            int i = 0;
            int j = number.length() - 1;
            while (i < j) {
                if (number.charAt(i) == number.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }

            return true;
        }

}

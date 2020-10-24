package String;

public class PalindromeNumberII {


        public boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }

            int reverseNumber = 0;
            int copy = x;
            while (copy > 0) {
                reverseNumber = reverseNumber*10 + copy%10;
                copy /= 10;
            }

            return reverseNumber == x;


        }

}

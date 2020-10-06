package String;

public class StringToInteger {

        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            int i = 0;
            int len = str.length();
            //remove space
            while (i < len && str.charAt(i) == ' ') {
                i++;
            }

            //invalid number
            if (i < len && (str.charAt(i) != '+' && str.charAt(i) != '-' && !Character.isDigit(str.charAt(i)))) {
                return 0;
            }

            boolean isNegative = false;
            if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                isNegative = str.charAt(i) == '-' ? true : false;
                i++;
            }

            int res = 0;

            while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (res > Integer.MAX_VALUE/10 ||
                        res == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > Integer.MAX_VALUE%10) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                }
                res = res*10 + (str.charAt(i) - '0');
                i++;
            }


            return isNegative ? -1*res: res;
        }

}

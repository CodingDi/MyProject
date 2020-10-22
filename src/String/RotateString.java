package String;

public class RotateString {
        public boolean rotateString(String A, String B) {

            if (A == null || B == null) {
                return false;
            }

            if (A.length() != B.length()) {
                return false;
            }

            if (A.length() == 0) {
                return true;
            }


            for (int i = 0; i < A.length(); i++) {
                if (canRotate(A, B, i)) {
                    return true;
                }
            }
            return false;

        }
        private boolean canRotate(String A, String B, int shift) {
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt((i + shift) % B.length())) {
                    return false;
                }
            }
            return true;
        }
}

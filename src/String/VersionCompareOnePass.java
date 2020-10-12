package String;

public class VersionCompareOnePass {

        public int compareVersion(String version1, String version2) {
            //two pointer way
            int i = 0;
            int j = 0;
            int val1 = 0;
            int val2 = 0;
            int n = version1.length();
            int m = version2.length();

            while (i < n || j < m) {
                while (i < n && version1.charAt(i) != '.') {
                    val1 = val1*10 + version1.charAt(i) - '0';
                    i++;
                }

                while (j < m && version2.charAt(j) != '.') {
                    val2 = val2*10 + version2.charAt(j) - '0';
                    j++;
                }

                if (val1 > val2) {
                    return 1;
                } else if (val1 < val2) {
                    return -1;
                }
                val1 = 0;
                val2 = 0;//reset for next revision comparison
                i++;
                j++;
            }

            return 0;
        }

}

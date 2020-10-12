package String;

public class CompareVersionNumber {

    //time:O(n + m + max(n, m))
    //space:O(m + n)
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int i = 0;
            int j = 0;
            int val1 = 0;
            int val2 = 0;

            while (i < v1.length && j < v2.length) {
                val1 = Integer.valueOf(v1[i]);
                val2 = Integer.valueOf(v2[j]);

                if (val1 == val2) {
                    i++;
                    j++;
                } else if (val1 > val2) {
                    return 1;
                } else {
                    return -1;
                }
            }

            System.out.println(i + "," + j);
            if (i == v1.length && j == v2.length) {
                return 0;
            }

            while (i < v1.length) {
                val1 = Integer.valueOf(v1[i]);
                if (val1 > 0) {
                    return 1;
                }
                i++;
            }

            while (j < v2.length) {
                val2 = Integer.valueOf(v2[j]);
                if (val2 > 0) {
                    return -1;
                }
                j++;
            }

            return 0;
        }

}

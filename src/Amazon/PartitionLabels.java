package Amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    /*Time Complexity: O(N) O(N), where NN is the length of SS.
    Space Complexity: O(1) O(1) to keep data structure last of not more than 26 characters.
    *
    * */
        public List<Integer> partitionLabels(String S) {

            List<Integer> res = new ArrayList<>();
            if(S == null|| S.length() == 0) return res;
            int[] last = new int[26];//records the end index of each character map a->0, b->1 etc

            //build the last occurence of the character
            for(int i = 0; i < S.length(); i++){
                char cur = S.charAt(i);
                last[cur - 'a'] = i;//update the last occurence of charcater cur
            }

            int start = 0;//begin of the sliding window, the current label
            int  end = 0;//the end of cur sliding window
            //traverse the string again
            for(int i = 0; i < S.length(); i++){
                char cur = S.charAt(i);
                int index = last[cur-'a'];
                end = Math.max(end, index);

                //we can cur here
                if(end == i){
                    end = i;
                    res.add(i - start + 1);
                    //update the begin index
                    start = i + 1;
                }
            }

            return res;
        }
    }

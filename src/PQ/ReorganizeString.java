package PQ;
import java.util.*;
public class ReorganizeString {

        public String reorganizeString(String S) {
            int len = S.length();
            //1. count the frequency of each char
            int[] count = new int[26];
            for (char c : S.toCharArray()) {
                count[c - 'a']++;
            }

            //2. put all unique char in PQ according to its frequency
            PriorityQueue<CountChar> pq = new PriorityQueue<>((a, b) -> (b.count == a.count ? a.letter - b.letter : b.count - a.count));
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    //impossible case:
                    if (count[i] > (len + 1)/2 ) {
                        return "";
                    }
                    pq.offer(new CountChar(count[i], (char)(i + 'a')));
                }

            }

            //3. biuld the string
            StringBuilder resStr = new StringBuilder();

            while (pq.size() > 1) {
                CountChar top1 = pq.poll();
                CountChar top2 = pq.poll();

                if (resStr.length() == 0 || resStr.charAt(resStr.length() - 1) != top1.letter) {
                    resStr.append(top1.letter).append(top2.letter);
                } else {
                    resStr.append(top2.letter).append(top1.letter);
                }

                if (top1.count - 1> 0) {
                    top1.count--;
                    pq.offer(top1);
                }

                if (top2.count - 1 > 0) {
                    top2.count--;
                    pq.offer(top2);
                }
            }


            if (pq.size() > 0) {
                resStr.append(pq.poll().letter);
            }

            return resStr.toString();

        }
        class CountChar {
            int count;
            char letter;
            CountChar (int count, char letter) {
                this.count = count;
                this.letter = letter;
            }
        }

}

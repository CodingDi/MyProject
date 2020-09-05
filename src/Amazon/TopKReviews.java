package Amazon;

import java.util.*;

public class TopKReviews {
    /*
    https://leetcode.com/discuss/interview-question/542597/
    Given a list of reviews, a list of keywords and an integer k.
    Find the most popular k keywords in order of most to least frequently mentioned.
    The comparison of strings is case-insensitive.
    Multiple occurances of a keyword in a review should be considred as a single mention.
    If keywords are mentioned an equal number of times in reviews, sort alphabetically.
    Example 1:
    Input:
    k = 2
    keywords = ["anacell", "cetracular", "betacellular"]
    reviews = [
    "Anacell provides the best services in the city",
    "betacellular has awesome services",
    "Best services provided by anacell, everyone should use anacell",
    ]
    Output:
    ["anacell", "betacellular"]
    Explanation:
    "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
    * */

//    public static void main(String[] args) {
//
//        //topKelements
//        String[] reviews = new String[]{"Anacell provides the best services in the city",
//                "betacellular has awesome services",
//                "Best services provided by anacell, everyone should use anacell",};
//
//        String[] keywords = new String[]{"anacell", "cetracular", "betacellular", "deltacellular"};
//        String[] res = topK(reviews, keywords, 2);
//        String[] reviews2 = new String[]{
//                //d  d  a  d  b c a b d d c
//                "deltacellular",
//                "deltacellular  ll ",
//                "I love Anacell Best services; Best services provided by anAcell",
//                "deltacellular provides much better services than betacellular",
//                "cetracular is worse than anacell",
//                "Betacellular is better than deltacellular",
//                "deltacellular lll cetracular"
//
//        };
//        String[] keyword2 = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
//        String[] res2 = topK(reviews2, keywords, 2);
////        for(int i = 0; i < res.length; i++) {
////            System.out.println(res[i]);
////        }
////        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.toString(res2));
//
//    }

    public String[] topK(String[] reviews, String[] keywords, int k) {

        //construct a map with its corresponding occurences, allinitialized as 0
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keywords.length; i++) {
            map.put(keywords[i], 0);
        }
        //split each review into words
        for (String str : reviews) {
            Set<String> used = new HashSet<>();
            String[] review = str.split("\\W");
            for (String word : review) {
                word = word.toLowerCase();
                if (map.containsKey(word) && !used.contains(word)) {
                    map.put(word, map.get(word) + 1);
                    used.add(word);//marked as used
                }
            }
        }

        //now every keyword with its occurrences are in the map
        //we will sort and output it by its occurrence
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> (map.get(s1) == map.get(s2) ? s2.compareTo(s1) : map.get(s1) - map.get(s2)));
        for (String keyword : map.keySet()) {
            keyword = keyword.toLowerCase();
            if (minHeap.size() < k) {
                minHeap.offer(keyword);
            } else if (map.get(minHeap.peek()) < map.get(keyword)) {
                minHeap.poll();
                minHeap.offer(keyword);
            }
        }

        //output
        String[] res = new String[minHeap.size()];
        int end = 0;
        while (!minHeap.isEmpty()) {
            res[end++] = minHeap.poll();
        }

        return res;
    }
}


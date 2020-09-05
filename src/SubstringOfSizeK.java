import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringOfSizeK {
    /*Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
    Example 1:
    Input: s = "abcabc", k = 3
    Output: ["abc", "bca", "cab"
    Example 2:
    Input: s = "abacab", k = 3
    output: ["bac", "cab"]
    Example 3:
    Input: s = "awaglknagawunagwkwagl", k = 4
    Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
    Explanation:
    Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
    "wagl" is repeated twice, but is included in the output once.
    */

    public static void main(String[] args) {
        System.out.println(substringOfSizeK("awaglknagawunagwkwagl", 4));
        System.out.println(substringOfSizeK("abacab", 3));
        System.out.println(substringOfSizeK("aaaaaaaa", 1));
        System.out.println(substringOfSizeK("abbbabbccc", 1));
        System.out.println(substringOfSizeK(" ", 0));
    }
    public static List<String> substringOfSizeK(String s, int k) {
        //sliding window: the current unique chars with size < = k
        //use two pointers of left and right
        // a hashset to store each unique substring
        //another hashset to store each unique chars in the sliding window
        //add the char(right) only when the the hashset doesn't contains char(right),
        //else move the left pointer and remove the corresponding chars at the hashset
        //when hashset size reaches to k, add it to the result.
        char[] input = s.toCharArray();

        Set<String> strs = new HashSet<>();
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int right = 0;

        while(right < input.length) {
            while(chars.contains(input[right])){
                chars.remove(input[left]);
                left++;
            }
            chars.add(input[right]);

            if(chars.size() == k) {
                String tmp = s.substring(left, right + 1);
                strs.add(tmp);
                chars.remove(input[left]);
                left++;
            }
            right++;
        }

        List<String> res = new ArrayList<>(strs);
        return res;
    }

}

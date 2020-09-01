import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsSystem {
    /*
    Complexity
    Time O(NlogN) for sorting
    Space O(logN) for quick sort.

    Time O(logN) for each query
    Space O(query) for each query
    where I take word operation as O(1)
    Given an array of strings products and a string searchWord.
    We want to design a system that suggests at most three product names from products
    after each character of searchWord is typed.
    Suggested products should have common prefix with the searchWord.
    If there are more than three products with a common prefix return the three lexicographically minimums products.
    Return list of lists of the suggested products after each character of searchWord is typed.
    Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
    * */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 1. sort the products in order
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        List<String> items = new ArrayList<>(Arrays.asList(products));

        // 2. build a treemap for the products key=product name, value= its index in thr sorted list
        //add each product to products []
        TreeMap<String, Integer> treemap = new TreeMap<>();
        for(int i = 0; i < products.length; i++ ){
            treemap.put(products[i], i);
        }

        // 3.for each prefix searchWord query, index its corresponding range in the treemap and addd them to res
        String query = "";
        for(char c : searchWord.toCharArray()) {
            query+= c;
            String startPro = treemap.ceilingKey(query);
            String endPro = treemap.floorKey(query + "{" );//use '{' because end should be exclusive

            if(startPro == null|| endPro == null){
                break;//nothing found, end all as them will be empty
            }
            int endIndex = Math.min(treemap.get(startPro) + 3, treemap.get(endPro) +1);//only take 3 or less than 3
            res.add(items.subList(treemap.get(startPro), endIndex));
        }

        // 4.if some query is null, we will still add an empty list to res
        while(res.size() < searchWord.length()) {
            res.add(new ArrayList<>());
        }
        return res;

    }
}

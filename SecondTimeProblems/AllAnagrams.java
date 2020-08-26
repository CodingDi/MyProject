package SecondTimeProblems;
import java.util.*;
public class AllAnagrams {
	/*find all occurrence of anagrams of a given string s in a given string l.
	 *  Return the list of starting indices.
	 */

	public AllAnagrams() {
		// TODO Auto-generated constructor stub
	}
	public List<Integer> allAnagrams(String sh, String lo){
	
		/*IDEA:use a hashMap to store all chars in short string,with respective frequency
		 * with each frequency,it also represents how many times need to appear for a match.
		 *
		 *For the long string,we do with two sides,left and right
		 * for each char in long string, if current char is in the map,we reduce the frequency by one.
		 * if the fre is already 1,we got a match;
		 * 
		 * for the left side,we need to check that when the left side char is out of bound,
		 * is it in the map or not.if yes,then the frequency needed to match should +1,
		 * otherwise no worry. if the frequency of the char in 0,then match reduces one.
		 * 
		 * for match,when the match is the same as the original map size,then its a valid res
		 */
		Map<Character,Integer> map=getMap(sh);
		List<Integer> list=new ArrayList<Integer>();
		int size=map.size();
		int match=0;
		
		for(int i=0;i<lo.length();i++) {	
			//step1: we deal with the right side char,to modify the match and the frequency of this char
			char ch=lo.charAt(i);
			Integer count=map.get(ch);
			//case1.1 if exist such char
			if(count!=null) {	
				map.put(ch,count-1);
				if(count==1) { //1-->0 match++
					match++;
				}
				
			}
			
		  //step2: deal with the left side char,when i out of the sh length,we need to remove left most
			if(i>=sh.length()) {
				ch=lo.charAt(i-sh.length());
				count=map.get(ch);
				if(count!=null) {
					map.put(ch,count+1);
					if(count==0) {//0-->1 match--
						match--;
					}
				}
			}
			//step3: check if the match satisfies the required,its a valid anagram
			//the index of first positon should be added
			if(match==size) {
				list.add(i-sh.length()+1);
			}
		}
		return list;
		
}
	
	//helper function to create the map of short string
	private Map<Character,Integer> getMap(String sh){
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<sh.length();i++) {
			char c=sh.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c,1);
			}else {
				map.put(c,map.get(c)+1);
			}
		}
		return map;
	}

}

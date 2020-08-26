package SecondTimeProblems;
import java.util.*;
public class LongestSubstring {
	
		  public int longest(String input) {
		    // C:
		    // A
		    // R: data structure HashSet<character> stores all unique characters appreared so far in the input
		    // global int max:maitain the max length of longest unique subarray
		    // for each char in the input string,we need to check if it exist in the set.
		    // case1.if not exists in the set,we can move the pointer right,and pit it in the set
		    // case2.if it exiss int the set,we need to remove set chars until no duplicates
		    // T:
		    //[left,right]:represents the current sliding window that constains all unqiue chars
		    if(input==null){
		      return 0;
		    }
		    int max=0;//initialization of the global max length
		    Set<Character> set=new HashSet<Character>();
		    for(int i=0;i<input.length();i++){
		      char tmp=input.charAt(i);
		      //case1.not in the set,update
		      if(!set.contains(tmp)){
		        set.add(tmp);
		        max=Math.max(max,set.size());
		      }else{//case2.if exists      
		        while(set.contains(tmp)){
		        set.remove(0);
		      }  
		      }
		    }
		    return max;
		  }
		  
		  public static void main(String[] args) {
			  
			  LongestSubstring test=new LongestSubstring();
			  String str1="ertyuirt";
			  System.out.println(test.longest(str1));
		  }


}

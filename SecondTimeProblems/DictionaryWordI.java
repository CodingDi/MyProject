package SecondTimeProblems;

import java.util.HashSet;
import java.util.Set;

/*Given a word and a dictionary,
 *  determine if it can be composed by concatenating words from the given dictionary.
 */
public class DictionaryWordI {

	public DictionaryWordI() {
		// TODO Auto-generated constructor stub
	}
	/*idea:use dynamic programming 
	 * use an array canCut[]  canCut[i] means we can cut between position i and (i+1)
	 * base case:canCut[0]=T
	 * induction rule:
	 * for each char in string,we do:
	 * 	for each of its previous char at j:
	 * if j can cut&&(j,i) is a word from dict,then i can cut too.
	 */
	public boolean canBreak(String input,String[] dict) {
		//corner case
		if(input==null||input.length()==0) {
			return true;
		}
		Set<String> set=new HashSet<String>();
		for(String word:dict) {
			set.add(word);
		}
		boolean[] canCut=new boolean[input.length()+1];
		//initialize
		canCut[0]=true;
		for(int i=1;i<=input.length();i++) {
			if(set.contains(input.substring(0,i))) {
				canCut[i]=true;
			}
			for(int j=1;j<i;j++) {
				if(canCut[j]&&set.contains(input.substring(j,i))){
					canCut[i]=true;
				}
			}
		}
		return canCut[input.length()];
	}

}

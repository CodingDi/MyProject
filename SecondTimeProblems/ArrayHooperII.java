package SecondTimeProblems;

public class ArrayHooperII {
/*
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
 * A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). 
 * Determine the minimum number of jumps you need to reach the end of array. 
 * If you can not reach the end of the array, return -1.
 */
	public ArrayHooperII() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * dynamic programming:use an array of int to record the min Jump need to reaches the end
	 * all elements are initialized to be -1 which means can't reach by default
	 * minJum[i] means the min Jumps need to reach array[i]
	 * starts form 0 to the end,
	 * for each position,we will iteratively check if its previous can reaches it
	 * case1:can reaches directly, if minJum[i]==-1 or minJump[i-1]+1<minJum[i],we fill the new jumps
	 * case2:can't reaches,
	 */
	public int minJump(int[] array) {
		if(array==null||array.length==0) {
			return 0;
		}
		int n=array.length;
		int[] minJump=new int[n];
		minJump[0]=0;//initialization:for position 0,its reacheable y default
		for(int i=1;i<n;i++) {
			minJump[i]=-1;
			for(int j=i-1;j>=0;j--) {//iteratively check its previous
				if(minJump[j]!=-1&&array[j]+j>=i) {//if its previous is reachable and it can reaches the cur
					minJump[i]=minJump[j]+1;
				}
			}
		}
		return minJump[n-1];
		
	}
	

}

package SecondTimeProblems;

public class LongestCross {
/*
 * Given a matrix that contains only 1s and 0s,
 *  find the largest cross which contains only 1s, 
 *  with the same arm lengths and the four arms joining at the central point.
 *  Return the arm length of the largest cross.
 */
	public LongestCross() {
		// TODO Auto-generated constructor stub
	}
	public int largest(int[][] matrix) {
		/*
		 * idea: look the length of longest ones frm four of its direction and get the min of between them.
		 * be careful that the (left and the u) /(right and the bottom)side is the same
		 * and we need a method to merge the four directions:consider merge two by two
		 */
		int N=matrix.length;
		int M=matrix[0].length;
		int[][] leftUp=leftUp(matrix,N,M);
		int[][] rightDown=rightDown(matrix,N,M);
		return merge(leftUp,rightDown,N,M);
		
	}
	//merge function
	private int merge(int[][] leftUp,int[][] rightDown,int N,int M){
		int res=0;//maintain the global max
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				leftUp[i][j]=Math.min(leftUp[i][j], rightDown[i][j]);
				res=Math.max(res, leftUp[i][j]);//update if necessary
			}
		}
		return res;
	}
	
	
	//get the longest arms from left and up side of consecutive ones
	private int[][] leftUp(int[][] matrix,int N,int M) {
		int[][] left=new int[N][M];//records the left side view of each position
		int[][] up=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {			
			if(matrix[i][j]==1) {
				if(i==0&&j==0) {
					left[i][j]=1;
					up[i][j]=1;
				}else if(i==0) {
					up[i][j]=1;
					left[i][j]=left[i][j-1]+1;
				}else if(j==0) {
					left[i][j]=1;
					up[i][j]=up[i-1][j]+1;
				}else {
					up[i][j]=up[i-1][j]+1;
					left[i][j]=left[i][j-1]+1;
				}
			}
				
			}
		}
		merge(left,up,N,M);
		return left;
	}
	
	//do right and the bottom side
	private int[][] rightDown(int[][] matrix,int N,int M){
		int[][] right=new int[N][M];
		int[][] down=new int[N][M];
		
		for(int i=N-1;i>=0;i--) {
			for(int j=M-1;j>=0;j--) {
				if(matrix[i][j]==1) {
					if(i==N-1&&j==M-1) {
						right[i][j]=1;
						down[i][j]=1;
					}else if(i==N-1) {
						right[i][j]=right[i][j+1]+1;
						down[i][j]=1;
					}else if(j==M-1) {
						right[i][j]=1;
						down[i][j]=down[i+1][j]+1;
					}else {
						right[i][j]=right[i][j+1]+1;
						down[i][j]=down[i+1][j]+1;
					}
				}
			}
		}
		merge(right,down,N,M);
		return right;
	}

}

package SecondTimeProblems;


public class ReverseBSTUpsideDownIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode reverse(TreeNode root) {
		if(root==null) {
			return root;
		}
		TreeNode prev=null;
		TreeNode prevRight=null;
		while(root!=null) {
			TreeNode next=root.left;
			TreeNode right=root.right;
			root.left=prev;
			root.right=prevRight;
			prev=root;
			root=next;
			prevRight=right;
		}
		return prev;
	}

}

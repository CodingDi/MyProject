package LinkedList;

import Amazon.ListNode;
import DFS.TreeNode;

public class ConvertSortedListToBST {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        ListNode globalHead;
        public TreeNode sortedListToBST(ListNode head) {
            globalHead = head;

            int len = 0;
            while(head != null) {
                len++;
                head = head.next;
            }

            return helper(0, len - 1);

        }

        private TreeNode helper(int l, int r) {
            //base case
            if (l > r) {
                return null;
            }
            int mid = (l + r) /2;
            TreeNode left = helper(l, mid - 1);
            TreeNode root = new TreeNode(globalHead.val);
            globalHead = globalHead.next;
            root.left = left;
            root.right = helper(mid + 1,r);

            return root;
        }

}

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

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    boolean isValid(TreeNode root , int min_value , int max_value){
        if(root == null){
            return true;
        }

        if(root.val <= min_value || root.val >=max_value){
            return false ; 
        }

        return isValid(root.left , min_value , root.val) && isValid(root.right , root.val , max_value);
    }
}

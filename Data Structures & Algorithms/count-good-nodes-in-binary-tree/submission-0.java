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
    public int goodNodes(TreeNode root) {
        return countgoodNode(root , root.val);
    }

    int countgoodNode(TreeNode node , int maxval){
        if(node == null){
            return 0;
        }

        int count = 0 ;
        if(node.val >= maxval){
            count = 1 ;
        } 

        maxval = Math.max(maxval , node.val);

        count+= countgoodNode(node.left , maxval);
        count+= countgoodNode(node.right , maxval);

        return count;
    }
}

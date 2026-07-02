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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        // The first element in preorder is always the root
        TreeNode root = new TreeNode(preorder[0]); 
        int mid = -1 ;
        for(int i = 0 ; i < inorder.length ; i++){
            if(inorder[i] == preorder[0]){
                mid = i ;
                break;
            }
        }

        int[] leftpre = Arrays.copyOfRange(preorder ,1,mid+1);
        int[] leftin = Arrays.copyOfRange(inorder , 0 , mid);
        root.left = buildTree(leftpre, leftin);

        int[] rightpre = Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[] rightin = Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.right = buildTree(rightpre , rightin);

        return root;
    }
}

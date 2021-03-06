package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * @Author zouxiaodong
 * @Date 2020/10/12 8:30
 */
//530. 二叉搜索树的最小绝对差
//        给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//        示例：
//        输入：
//
//        1
//         \
//          3
//         /
//        2
//
//        输出：
//        1
//
//        解释：
//        最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//        提示：
//        树中至少有 2 个节点。
//        本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
public class GetMinimumDifference_530 {

    int pre;
    int ans;

    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(pre != -1){
            ans = Math.min(ans,root.val-pre);
        }
        pre = root.val;
        inOrder(root.right);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
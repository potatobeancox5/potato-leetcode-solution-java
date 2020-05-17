package com.potato.study.leetcode.p1448;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1448. Count Good Nodes in Binary Tree
 *  
 *
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.



Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.


Constraints:

The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
 *         
 *
 *
 *
 *  思路：
 *      https://leetcode-cn.com/problems/build-an-array-with-stack-operations/solution/dan-ci-xun-huan-bian-li-jie-jue-fang-an-by-murong-/
 *
 *
 *      如果到这个节点位置 没有任何一个节点比他大 那么就是good
 *      找到goodNode 数量
 *      https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/solution/java-di-gui-de-liang-chong-jie-fa-by-imaginee/
 *     事故体变更方法返回值
 *
 */
public class Solution {



    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int max) {
        if (null == root) {
            return 0;
        }
        // 当前最大值
        max = Math.max(max, root.val);
        // 传递
        int count = 0;
        if (max == root.val) {
            count = 1;
        }
        // 左右孩子的结果一起算上
        return dfs(root.left, max) + dfs(root.right, max) + count;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] target = new int[]{1,3};
//        int n = 3;
//        List<String> res = solution.goodNodes(target, n);
//        System.out.println(res); // "Push","Push","Pop","Push"

    }
}

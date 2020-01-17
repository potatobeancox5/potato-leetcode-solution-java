package com.potato.study.leetcode.p0662;

import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         662. Maximum Width of Binary Tree
 * 
 *         Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input:

1
/   \
3     2
/ \     \
5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input:

1
/
3
/ \
5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input:

1
/ \
3   2
/
5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input:

1
/ \
3   2
/     \
5       9
/         \
6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
 *
 *
 *
 *         思路：
 *         找到给定 二叉树的宽度


https://www.cnblogs.com/grandyang/p/7538821.html

http://www.mamicode.com/info-detail-2428537.html
 *
 *         题目含义：计算二叉树的宽度
 *
 *
 */
public class Solution {

    /**
     * 存最大层的元素个数
     */
    private int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<Integer> startNodeIndex = new ArrayList<>();
        getWidth(root, 1, 0, startNodeIndex);
        return max;
    }


    /**
     *
     * @param root
     * @param index
     * @param level     层 index 从0开始
     * @param startNodeIndex
     */
    private void getWidth(TreeNode root, int index, int level, List<Integer> startNodeIndex) {

        // 0. 如果当前节点为空 直接返回
        if (null == root) {
            return;
        }
        // 1. 当前level  == 在 lastNodeIndex.len 时，说明当前节点为这一层的第一个node 需要记录下来
        if (startNodeIndex.size() == level) {
            startNodeIndex.add(index);
        }
        // 2. 使用当前节点与本层第一个节点进行一次最大值的探索
        max = Math.max(max, index + 1 - startNodeIndex.get(level));
        // 3. 往左右孩子中蔓延
        getWidth(root.left, 2 * index, level + 1, startNodeIndex);
        getWidth(root.right, 2 * index + 1, level + 1, startNodeIndex);
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = null;
        int width = solution.widthOfBinaryTree(root);
        System.out.println(width);
        Assert.assertEquals(2, width);
    }
}

package com.potato.study.leetcode.p0637;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *         637. Average of Levels in Binary Tree
 * 
 *         Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
3
/ \
9  20
/  \
15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 * 
 *         思路：层序遍历 记录每层的和与每层节点个数
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevelRes = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        TreeNode cur = root;
        levelQueue.add(cur);
        int curLevelNum = 1;
        int nextLevelNum = 0;
        int curLevelCounter = 0;
        long curLevelSum = 0;
        while (!levelQueue.isEmpty()) {
            TreeNode node = levelQueue.remove();
            curLevelNum--;
            curLevelCounter++;
            curLevelSum += (long)node.val;
            // 放置孩子节点
            if (node.left != null) {
                levelQueue.add(node.left);
                nextLevelNum++;
            }
            if (node.right != null) {
                levelQueue.add(node.right);
                nextLevelNum++;
            }
            if (curLevelNum == 0) { // 一个层的终结
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
                // 计算平均值并写入结果
                averageOfLevelRes.add((double)curLevelSum / curLevelCounter);
                // 回复原来计数器
                curLevelCounter = 0;
                curLevelSum = 0;
            }
        }
        return averageOfLevelRes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Double> doubles = solution.averageOfLevels(null);
        System.out.println(doubles);
    }
}

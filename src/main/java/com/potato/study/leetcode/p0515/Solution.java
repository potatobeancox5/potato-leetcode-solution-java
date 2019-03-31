package com.potato.study.leetcode.p0515;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *         515. Find Largest Value in Each Tree Row
 * 
 *         You need to find the largest value in each row of a binary tree.

Example:
Input:

1
/ \
3   2
/ \   \
5   3   9

Output: [1, 3, 9]


 * 
 * 
 *         思路：
 *          层序遍历
 *         https://blog.csdn.net/mine_song/article/details/70213201
 *          
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValueList = new ArrayList<>();
        // 队列保存 接下来要遍历的节点
        Queue<TreeNode> nextNodeQueue = new LinkedList<>();
        // 记录当前遍历的节点位置 记录当前层的下一层遍历的节点数量
        int currentLayerNum = 0;
        int nextLayerNum = 0;
        int currentNum = 0;
        if (root == null) {
            return largestValueList;
        }
        nextNodeQueue.add(root);
        currentLayerNum = 1;
        int max = Integer.MIN_VALUE;
        // 当前节点是最后一个节点 变更数量 max 如结果
        while (!nextNodeQueue.isEmpty()) {
            TreeNode node = nextNodeQueue.remove();
            currentNum++;
            if (node.val > max) {
                max = node.val;
            }
            if (node.left != null) {
                nextNodeQueue.add(node.left);
                nextLayerNum++;
            }
            if (node.right != null) {
                nextNodeQueue.add(node.right);
                nextLayerNum++;
            }
            // 判断是否是最后一个节点
            if (currentNum == currentLayerNum) {
                largestValueList.add(max);
                currentLayerNum = nextLayerNum;
                nextLayerNum = 0;
                currentNum = 0;
                max = Integer.MIN_VALUE;
            }
        }
        return largestValueList;
    }

    public static void main(String[] args) {

    }
}

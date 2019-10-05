package com.potato.study.leetcode.p0337;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.*;

/**
 * 
 * @author liuzhao11
 * 
 *         337. House Robber III
 * 
 *         The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

3
/ \
2   3
\   \
3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

3
/ \
4   5
/ \   \
1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 *         思路：
 *         https://blog.csdn.net/zdavb/article/details/50994413
 *
 *         设计一个结构 GotMoney 当前节点 可能获得的钱数
 *         两个属性字段 notRob 和 rob 分别代表不抢这个节点 和抢这个节点
 *          递归遍历 root
 *           获取 leftChild 孩子的情况和 right的
 *           计算最大值
 *              1. rob 当前节点 + left和right 都不能rob的钱数和
 *              2. not rob 当前节点 + Maxleft是否rob + max right 是否rob
 *
 *
 *
 *
 *
 *
 * 
 */
public class Solution {


    class GotMoney {
        public int notRob;
        public int rob;

        public GotMoney(int notRob, int rob) {
            this.notRob = notRob;
            this.rob = rob;
        }
    }

    public int rob(TreeNode root) {
        GotMoney wholeMoney = getWholeMoney(root);
        return Math.max(wholeMoney.notRob, wholeMoney.rob);
    }

    /**
     * 递归求解 rob 当前节点 一共能获得多少钱
     * @param root
     * @return
     */
    private GotMoney getWholeMoney(TreeNode root) {
        if (null == root) {
            return new GotMoney(0,0);
        }
        // 左右孩子的情况
        GotMoney leftChildMoney = this.getWholeMoney(root.left);
        GotMoney rightChildMoney = this.getWholeMoney(root.right);
//        计算最大值
//                *              1. rob 当前节点 + left和right 都不能rob的钱数和
//                *              2. not rob 当前节点 + Maxleft是否rob + max right 是否rob
        int robThisNode = root.val + leftChildMoney.notRob + rightChildMoney.notRob;
        int notRobThisNode = Math.max(leftChildMoney.notRob, leftChildMoney.rob) + Math.max(rightChildMoney.notRob, rightChildMoney.rob);
        return new GotMoney(notRobThisNode, robThisNode);
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int totalMoney = solution.rob(root);
        System.out.println(totalMoney);
	}
}

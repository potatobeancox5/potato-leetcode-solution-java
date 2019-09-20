package com.potato.study.leetcode.p0337;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 *         层序遍历求出每层的和
 *         遍历和求每个隔层能赚多少前，奇数层与偶数层
 *
 *
 *
 * 
 */
public class Solution {

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLayerNum = 1;
        int nextLayerNum = 0;
        int currentLayTotalMoney = 0;
        List<Integer> moneyList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            currentLayTotalMoney += cur.val;
            currentLayerNum--;
            if (cur.left != null) {
                nextLayerNum++;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                nextLayerNum++;
                queue.add(cur.right);
            }
            // 判断是否处理到当前层最后一个节点
            if (currentLayerNum == 0) {
                moneyList.add(currentLayTotalMoney);
                currentLayTotalMoney = 0;
                currentLayerNum = nextLayerNum;
                nextLayerNum = 0;
            }
        }
//        System.out.println(moneyList);
        // 遍历和求每个隔层能赚多少前，奇数层与偶数层 dp i = max { money[i] + dp i -2 , dp i -i }
        int[] dp = new int[moneyList.size() + 1];
        dp[1] = moneyList.get(0);
        dp[0] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + moneyList.get(i-1), dp[i-1]);
        }
        return dp[moneyList.size()];
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

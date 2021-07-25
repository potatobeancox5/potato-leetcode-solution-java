package com.potato.study.leetcodecn.p00437.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

  

 示例 1：



 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 输出：3
 解释：和等于 8 的路径有 3 条，如图所示。
 示例 2：

 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 输出：3
  

 提示:

 二叉树的节点个数的范围是 [0,1000]
 -109 <= Node.val <= 109 
 -1000 <= targetSum <= 1000 


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/path-sum-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 回溯 使用 m
     *
     * 回溯

     使用map 记录出现的前缀数量 要记录map 0 1
     前缀和为0的次数为1


     当前节点空 直接返回

     记录当前前缀

     计算target 数量

     更新 当前前缀数量

     递归找孩子数量

     剪去本次的个数
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        this.target = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        // 什么都不选
        countMap.put(0, 1);
        getPath(root, targetSum, 0, countMap);
        return target;
    }

    private int target;

    private void getPath(TreeNode current, int targetSum, int currentSum, Map<Integer, Integer> countMap) {
        if (current == null) {
            return;
        }
        currentSum += current.val;
        if (countMap.containsKey(currentSum - targetSum)) {
            target += countMap.get(currentSum - targetSum);
        }
        countMap.put(currentSum, countMap.getOrDefault(currentSum, 0) + 1);
        getPath(current.left, targetSum, currentSum, countMap);
        getPath(current.right, targetSum, currentSum, countMap);
        countMap.put(currentSum, countMap.getOrDefault(currentSum, 0) - 1);
    }
}

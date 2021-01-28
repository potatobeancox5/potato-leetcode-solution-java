package com.potato.study.leetcodecn.p00637.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

  

 示例 1：

 输入：
 3
 / \
 9  20
 /  \
 15   7
 输出：[3, 14.5, 11]
 解释：
 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
  

 提示：

 节点值的范围在32位有符号整数范围内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 题目要求 每层的均值 层序遍历的另一个应用
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 控制每层遍历
        while (!queue.isEmpty()) {
            // 每层的和是多少
            long layerSum = 0;
            // 每层多少个节点
            int layerLen = queue.size();
            for (int i = 0; i < layerLen; i++) {
                TreeNode node = queue.poll();
                layerSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 计算每层均值
            Double res = 1.0 * layerSum / layerLen;
            resultList.add(res);
        }
        return resultList;
    }


//    public static void main(String[] args) {
//
//        Solution solution = new Solution();
//
//        TreeNode root = solution.mergeTrees(null, null);
//
//
//    }
}

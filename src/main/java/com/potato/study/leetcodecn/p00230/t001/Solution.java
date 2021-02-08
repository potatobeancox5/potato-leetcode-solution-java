package com.potato.study.leetcodecn.p00230.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

  

 示例 1：


 输入：root = [3,1,4,null,2], k = 1
 输出：1
 示例 2：


 输入：root = [5,3,6,2,4,null,null,1], k = 3
 输出：3
  

  

 提示：

 树中的节点数为 n 。
 1 <= k <= n <= 104
 0 <= Node.val <= 104
  

 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // key 根所在树种对应的节点数量
    private Map<TreeNode, Integer> treeNodeCountMap = new HashMap<>();

    /**
     * get左孩子个数 n
     * 左孩子个数 + 1 等于target 返回当前节点
     * 否则 左孩子个数多 往左孩子里找
     * 个数少 往右孩子里找
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return -1;
        }
        int leftChildNum = getTreeNodeNum(root.left);
        if (leftChildNum + 1 == k) {
            return root.val;
        } else if (leftChildNum + 1 > k) {
            // 左孩子找
            return kthSmallest(root.left, k);
        } else {
            // leftChildNum + 1 < k
            return kthSmallest(root.right, k - leftChildNum - 1);
        }
    }

    /**
     * 获取 数量
     * @param root
     * @return
     */
    private int getTreeNodeNum(TreeNode root) {
        if (treeNodeCountMap.containsKey(root)) {
            return treeNodeCountMap.get(root);
        }
        if (null == root) {
            return 0;
        }
        int num = 1;
        num += getTreeNodeNum(root.left);
        num += getTreeNodeNum(root.right);
        treeNodeCountMap.put(root, num);
        return num;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.kthSmallest()
    }

}

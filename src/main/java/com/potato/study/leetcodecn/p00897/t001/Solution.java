package com.potato.study.leetcodecn.p00897.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

  

 示例 ：

 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

 5
 / \
 3    6
 / \    \
 2   4    8
  /        / \
 1        7   9

 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
   \
    2
     \
      3
       \
        4
         \
          5
           \
            6
             \
              7
               \
                8
                 \
 9
  

 提示：

 给定树中的结点数介于 1 和 100 之间。
 每个结点都有一个从 0 到 1000 范围内的唯一整数值。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 中序遍历 树 用list 记录遍历结果
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        // 中序遍历 得到遍历结果
        List<TreeNode> list = new ArrayList<>();
        this.inorderList(root, list);
        // 遍历list 进行 指针拼接
        for (int i = 1; i < list.size(); i++) {
            list.get(i-1).right = list.get(i);
            list.get(i-1).left = null;
        }
        // 最后节点处理
        list.get(list.size() -  1).left = null;
        list.get(list.size() -  1).right = null;
        return list.get(0);
    }

    /**
     * 中序遍历 使用 list 存储中序遍历结果
     * @param root
     * @param list
     */
    private void inorderList(TreeNode root, List<TreeNode> list) {
        if (null == root) {
            return;
        }
        inorderList(root.left, list);
        list.add(root);
        inorderList(root.right, list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = solution.increasingBST(root);
        TreePrintUtil.pirnt(node);
    }
}

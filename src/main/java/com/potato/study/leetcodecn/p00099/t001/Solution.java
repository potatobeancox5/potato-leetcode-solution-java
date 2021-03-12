package com.potato.study.leetcodecn.p00099.t001;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 *
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。

 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？

  

 示例 1：


 输入：root = [1,3,null,null,2]
 输出：[3,1,null,null,2]
 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 示例 2：


 输入：root = [3,1,4,null,null,2]
 输出：[2,1,4,null,null,3]
 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
  

 提示：

 树上节点的数目在范围 [2, 1000] 内
 -231 <= Node.val <= 231 - 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 直接 中序遍历 生成 字符串 然后对生成的字符串 进行比较 如果不满足 ai <= ai-1 那么 ai 是需要处理的？对
     * 12354 5 是要交换的
     *
     * 反向遍历 如果 ai-1 >= ai 那么 ai 就是 ai-1 就是target 2
     * 15342
     *  两种情况
     *  1. 如果是相邻两个点交互 那就没有 target2了
     *  2. 如果不相邻交换 那就有
     * @param root
     */
    public void recoverTree(TreeNode root) {
        // 中序 遍历 结果 放入 list
        List<TreeNode> aeslist = new ArrayList<>();
        // 中序遍历 将结果 放进list 中
        inorder(root, aeslist);
        // 遍历 aeslist 找到 两个不行的点 target1 和 target2
        int target1 = -1;
        int target2 = -1;
        for (int i = 0; i < aeslist.size() - 1; i++) {
            // 对应 两种情况
            if (aeslist.get(i).val > aeslist.get(i+1).val) {
                if (target1 == -1) {
                    target1 = i;
                } else if (target2 == -1) {
                    // target1 != -1
                    target2 = i + 1;
                }
            }
        }
        // 判断是不是有 target2
        if (target2 == -1) {
            TreeNode node1 = aeslist.get(target1);
            TreeNode node2 = aeslist.get(target1 + 1);
            swapVal(node1, node2);
        } else {
            TreeNode node1 = aeslist.get(target1);
            TreeNode node2 = aeslist.get(target2);
            swapVal(node1, node2);
        }
        return;
    }

    private void swapVal(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }


    /**
     * 中序遍历 结果放进 list 中
     * @param root
     * @param aeslist
     */
    private void inorder(TreeNode root, List<TreeNode> aeslist) {
        if (root.left != null) {
            inorder(root.left, aeslist);
        }
        // visit this node
        aeslist.add(root);
        if (root.right != null) {
            inorder(root.right, aeslist);
        }
    }
}

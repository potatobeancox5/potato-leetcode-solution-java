package com.potato.study.leetcodecn.p00783.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。

  

 示例：

 输入: root = [4,2,6,1,3,null,null]
 输出: 1
 解释:
 注意，root是树节点对象(TreeNode object)，而不是数组。

 给定的树 [4,2,6,1,3,null,null] 可表示为下图:

 4
 /   \
 2      6
 / \
 1   3

 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
  

 注意：

 二叉树的大小范围在 2 到 100。
 二叉树总是有效的，每个节点的值都是整数，且不重复。
 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 中序遍历 比较最终结果大小
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        generateTraverseResult(result, root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, Math.abs(result.get(i) - result.get(i-1)));
        }
        return min;
    }

    /**
     * 中序遍历 生成结果
     * @param result
     * @param root
     */
    private void generateTraverseResult(List<Integer> result, TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            generateTraverseResult(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            generateTraverseResult(result, root.right);
        }
    }
}

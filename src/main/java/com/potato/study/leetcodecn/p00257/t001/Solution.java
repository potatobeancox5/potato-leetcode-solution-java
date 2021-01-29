package com.potato.study.leetcodecn.p00257.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 输入:

 1
 /   \
 2     3
 \
 5

 输出: ["1->2->5", "1->3"]

 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-paths
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先根遍历 直到叶子节点
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        getAllPath(root, resultList, "");
        return resultList;
    }

    /**
     * 遍历每个节点 生成目前为止的path 并判定 叶子节点存储结果
     * @param node
     * @param resultList
     * @param currentPath
     */
    private void getAllPath(TreeNode node, List<String> resultList, String currentPath) {
        if (node == null) {
            return;
        }
        // generate path
        if (null == currentPath || "".equals(currentPath)) {
            currentPath = "" + node.val;
        } else {
            // -> val
            currentPath += ("->" + node.val);
        }
        // 叶子
        if (node.left == null && node.right == null) {
            resultList.add(currentPath);
            return;
        }
        // not leaves
        getAllPath(node.left, resultList, currentPath);
        getAllPath(node.right, resultList, currentPath);
    }


}

package com.potato.study.leetcode.p0652;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         652. Find Duplicate Subtrees
 * 
 *         Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

1
/ \
2   3
/   / \
4   2   4
/
4
The following are two duplicate subtrees:

2
/
4
and

4
Therefore, you need to return above trees' root in the form of a list.
 * 
 *         思路：
 *         652. Find Duplicate Subtrees

https://blog.csdn.net/zjucor/article/details/76383872

先根遍历 并返回遍历结果 放在set 中

resSet 存结果
containSet 存当前存在结果

if nil 返回null#

stringbuild append 当前结点#
append 左孩子 右孩子

set判重并加入 res
 *
 */
public class Solution {

    // 当前树节点的set
    private Set<String> treeNodeSet = new HashSet<>();
    // 结果集合set
    private Set<String> resultSet = new HashSet<>();
    // 结果集
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getSubtreeByPreorder(root, new StringBuilder());
        return result;
    }


    /**
     * 获取当前root 节点 的数的字符串标识
     * @param root
     * @param builder
     * @return
     */
    private String getSubtreeByPreorder(TreeNode root, StringBuilder builder) {
        // 1. 处理空节点
        if (null == root) {
            return "null#";
        }
        // 2. 处理当前节点 + 左右孩子
        builder.append(root.val).append("&");
        builder.append(getSubtreeByPreorder(root.left, new StringBuilder()));
        builder.append(getSubtreeByPreorder(root.right, new StringBuilder()));

        // 3. 修改缓存和结果
        String subtreeStr = builder.toString();
        if (treeNodeSet.contains(subtreeStr)) {
            if (!resultSet.contains(subtreeStr)) {
                resultSet.add(subtreeStr);
                result.add(root);
            }
        } else {
            treeNodeSet.add(subtreeStr);
        }
        // 4. 返回 当前字符串
        return subtreeStr;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = null;
        List<TreeNode> res = solution.findDuplicateSubtrees(root);
        System.out.println(res);
//		System.out.println(count);
//		Assert.assertEquals(3, count);
	}
}

package com.potato.study.leetcodecn.p00095.t001;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

  

 示例：

 输入：3
 输出：
 [
   [1,null,3,2],
   [3,2,null,1],
   [3,1,null,null,2],
   [2,1,3],
   [1,null,2,null,3]
 ]
 解释：
 以上的输出对应以下 5 种不同结构的二叉搜索树：

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
  

 提示：

 0 <= n <= 8

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 递归生成 子树
     * 每次从 1-n 那一个点 其他的 往孩子节点上丢
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return this.generateTrees(1, n);
    }

    /**
     * 开始结束节点
     * @param start
     * @param end
     */
    private List<TreeNode> generateTrees(int start, int end) {
        // 终止条件 只有一个节点时
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            return null;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        // 从 start end 中选一个位置 生成
        for (int i = start; i <= end; i++) {
            // 获取 node 孩子的组合数，组合起来
            List<TreeNode> leftChilds = generateTrees(start, i-1);
            List<TreeNode> rightChilds = generateTrees(i+1, end);
            // 利用当前点 num 和 leftChilds  rightChilds 组合成一颗颗 新树
            list.addAll(getAllTrees(i, leftChilds, rightChilds));
        }
        return list;
    }

    /**
     *
     * @param num           根的值
     * @param leftChilds    左孩子可能的形式
     * @param rightChilds   右孩子可能的形式
     * @return
     */
    private List<TreeNode> getAllTrees(int num, List<TreeNode> leftChilds,
                                                       List<TreeNode> rightChilds) {
        // 左右孩子都是空
        List<TreeNode> res = new ArrayList<>();
        if (leftChilds == null && rightChilds == null) {
            res.add(new TreeNode(num));
            return res;
        }
        if (leftChilds != null && rightChilds != null) {
            for (TreeNode leftChild :leftChilds) {
                for (TreeNode rightChild : rightChilds) {
                    TreeNode root = new TreeNode(num);
                    root.left = leftChild;
                    root.right = rightChild;

                    res.add(root);
                }
            }
            return res;
        }
        // 只有左孩子
        if (leftChilds != null) {
            for (TreeNode leftChild : leftChilds) {
                TreeNode root = new TreeNode(num);
                root.left = leftChild;
                res.add(root);
            }
            return res;
        }
        // 只有右孩子
        if (rightChilds != null) {
            for (TreeNode rightChild : rightChilds) {
                TreeNode root = new TreeNode(num);
                root.right = rightChild;
                res.add(root);
            }
            return res;
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int numTrees = solution.generateTrees(1);
//        System.out.println(numTrees);
//        Assert.assertSame(1, numTrees);
//
//        numTrees = solution.numTrees(3);
//        System.out.println(numTrees);
//        Assert.assertSame(5, numTrees);
//    }
}

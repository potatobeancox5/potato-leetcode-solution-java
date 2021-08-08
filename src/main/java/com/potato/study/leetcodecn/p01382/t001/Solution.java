package com.potato.study.leetcodecn.p01382.t001;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 1382. 将二叉搜索树变平衡
 *
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *  
 *
 * 提示：
 *
 * 树节点的数目在 1 到 10^4 之间。
 * 树节点的值互不相同，且在 1 到 10^5 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private List<Integer> rootVal;


    public TreeNode balanceBST(TreeNode root) {
        // 中序遍历 得到 一个 数组，
        this.rootVal = new ArrayList<>();
        getNodeList(root);
        // 递归生成 bst
        return buildBstTree(0, rootVal.size() - 1);
    }

    /**
     * 指定left 和 right 生成树 借助 rootVal
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildBstTree(int left, int right) {
        if (left >= rootVal.size() || right >= rootVal.size()) {
            return null;
        }
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(this.rootVal.get(left));
        }
        // 获取中间点 生成树
        int mid = (left + right) / 2;
        Integer value = rootVal.get(mid);
        TreeNode node = new TreeNode(value);
        node.left = buildBstTree(left, mid - 1);
        node.right = buildBstTree(mid + 1, right);
        return node;
    }

    // 中序遍历 生成结果
    private void getNodeList(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            getNodeList(node.left);
        }
        rootVal.add(node.val);
        if (node.right != null) {
            getNodeList(node.right);
        }
    }




    /**
     * [4,5,8]
     * [10,9,1,8]
     * @param args
     */
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr1 = new int[] {
//                4,5,8
//        };
//        int[] arr2 = new int[] {
//                10,9,1,8
//        };
//        int d = 2;
//        int res = solution.findTheDistanceValue(arr1, arr2, d);
//        System.out.println(res);
//        Assert.assertEquals(2, res);
//    }
}

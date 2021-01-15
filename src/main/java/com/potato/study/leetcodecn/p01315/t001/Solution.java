package com.potato.study.leetcodecn.p01315.t001;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 如果不存在祖父节点值为偶数的节点，那么返回 0 。

  

 示例：



 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 输出：18
 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
  

 提示：

 树中节点的数目在 1 到 10^4 之间。
 每个节点的值在 1 到 100 之间。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 如果当前节点 是偶数 获取孙子节点的和
     * 如果不是的话 递归获取 左孩子和右孩子的结果 加和返回
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        int sumOfGrandson = 0;
        if (root == null) {
            return sumOfGrandson;
        }
        if (root.val % 2 != 1) {
            sumOfGrandson = getSumOfGrandson(root);
        }
        sumOfGrandson += sumEvenGrandparent(root.left);
        sumOfGrandson += sumEvenGrandparent(root.right);
        return sumOfGrandson;
    }

    /**
     * 获取当前节点的 孙子的和
     * @param root
     * @return
     */
    private int getSumOfGrandson(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            if (root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left.right != null) {
                sum += root.left.right.val;
            }
        }
        if (root.right != null) {
            if (root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right.right != null) {
                sum += root.right.right.val;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{1,1,2,3};
//        int[] res = solution.decompressRLElist(nums);
//        // [1,3,3]
//        System.out.println(Arrays.toString(res));
    }
}

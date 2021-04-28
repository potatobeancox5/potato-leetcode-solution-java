package com.potato.study.leetcodecn.p01008.t001;

import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 1008. 前序遍历构造二叉搜索树
 *
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。

 (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）

 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。

  

 示例：

 输入：[8,5,1,7,10,12]
 输出：[8,5,10,1,7,null,12]

  

 提示：

 1 <= preorder.length <= 100
 1 <= preorder[i] <= 10^8
 preorder 中的值互不相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 第一个数组 作为 root 。
     * 根据root 将数组分成两个子数组 （小于root 和大于root）
     * 递归生成左右子树，并进行拼接
     * 返回root
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int[][] leftAndRightChild = getLeftAndRightChild(preorder);
        root.left = bstFromPreorder(leftAndRightChild[0]);
        root.right = bstFromPreorder(leftAndRightChild[1]);
        return root;
    }

    /**
     * 按照数组的第一个数字 将数字分成2部分 0 是小于的部分，1是大于的部分
     * @param preorder
     * @return
     */
    private int[][] getLeftAndRightChild(int[] preorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        int target = preorder[0];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] < target) {
                list1.add(preorder[i]);
            } else {
                list2.add(preorder[i]);
            }
        }
        int[][] result = new int[2][];
        result[0] = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            result[0][i] = list1.get(i);
        }
        result[1] = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            result[1][i] = list2.get(i);
        }
        return result;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int num = solution.bitwiseComplement(10);
//        System.out.println(num);
//        Assert.assertEquals(5, num);
//    }
}

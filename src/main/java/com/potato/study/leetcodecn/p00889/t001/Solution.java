package com.potato.study.leetcodecn.p00889.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 889. 根据前序和后序遍历构造二叉树
 *
 * 返回与给定的前序和后序遍历匹配的任何二叉树。

  pre 和 post 遍历中的值是不同的正整数。

  

 示例：

 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 输出：[1,2,3,4,5,6,7]
  

 提示：

 1 <= pre.length == post.length <= 30
 pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (null == pre || pre.length == 0) {
            return null;
        }
        // 第一个节点 pre 首节点
        int val = pre[0];
        TreeNode root = new TreeNode(val);
        // 第二个节点就是左孩子 根据左孩子 分隔 post ，并利用 post 长度分隔左孩子
        if (pre.length == 1) {
            return root;
        }
        int leftHead = pre[1];
        boolean hasFound = false;
        int index = 0;
        while (index < post.length) {
            if (post[index] == leftHead) {
                hasFound = true;
                break;
            }
            index++;
        }
        // 分隔子树节点 如果已经到头了 就直接返回 空数组吧
        int leftTreeLen = 0;
        if (hasFound) {
            leftTreeLen = index + 1;
        }
        if (leftTreeLen > 0) {
            int[] leftPre = Arrays.copyOfRange(pre, 1, leftTreeLen + 1);
            int[] leftPost = Arrays.copyOfRange(post, 0, leftTreeLen);
            root.left = constructFromPrePost(leftPre, leftPost);
        }

        if (leftTreeLen < pre.length) {
            int[] rightPre = Arrays.copyOfRange(pre, leftTreeLen + 1, pre.length);
            int[] rightPost = Arrays.copyOfRange(post, leftTreeLen, post.length - 1);
            // 递归生成 左右孩子 进行树 组装
            root.right = constructFromPrePost(rightPre, rightPost);
        }


        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pre = new int[]{
                1,2,4,5,3,6,7
        };
        int[] post = new int[]{
                4,5,2,6,7,3,1
        };
        TreeNode treeNode = solution.constructFromPrePost(pre, post);

    }
}

package com.potato.study.leetcodecn.p00894.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.List;

/**
 * 894. 所有可能的满二叉树
 *
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

 答案中每个树的每个结点都必须有 node.val=0。

 你可以按任何顺序返回树的最终列表。

  

 示例：

 输入：7
 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 解释：

  

 提示：

 1 <= N <= 20

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 所有可能的二叉树
     * 用一个 map Integer 存 所有 节点树为 n 的 TreeNode 的 List
     * 递归 生成树
     * 如果 当前 n 已经存在 在 map 中了 ，那么直接去 map 结果 copy 一下 返回
     *
     * 否则 将 n-1 均分成 分成2个部分，然后递归生成结果，
     *
     * 遍历结果 组成新的树 创建头结点 链接，放到map 中 并最终返回结果
     * @param n
     * @return
     */
    public List<TreeNode> allPossibleFBT(int n) {
        // 递归获取 孩子节点的可能性


        // 遍历孩子节点 生成一个新的当前节点，
        return null;
    }


    /**
     * 深拷贝 一个 树 head；
     * @param head
     * @return
     */
    private TreeNode copyTreeNode(TreeNode head) {
        return null;
    }


    private List<TreeNode> copyAllTree(List<TreeNode> trees) {
        return null;
    }

}

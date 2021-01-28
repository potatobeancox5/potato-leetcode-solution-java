package com.potato.study.leetcodecn.p00559.t001;


import com.potato.study.leetcode.domain.duplicate.name.Node;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。

 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

 N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

  

 示例 1：



 输入：root = [1,null,3,2,4,null,5,6]
 输出：3
 示例 2：



 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 输出：5
  

 提示：

 树的深度不会超过 1000 。
 树的节点数目位于 [0, 104] 之间。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 多叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        List<Node> children = root.children;
        if (null == children || children.size() == 0) {
            return 1;
        }
        for (Node child : children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s = solution.reverseWords("Let's take LeetCode contest");
//        System.out.println(s);
//        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", s);
    }

}
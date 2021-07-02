package com.potato.study.leetcodecn.p00894.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<Integer, List<TreeNode>> subTreeMap = new HashMap<>();


    /**
     * 每个节点要么有2个节点 要么没有节点
     * @param n
     * @return
     */
    public List<TreeNode> allPossibleFBT(int n) {
        // 节点必须满足 奇数
        List<TreeNode> list = new ArrayList<>();
        if (n % 2 == 0) {
            return list;
        }
        if (n == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        // 缓存
        if (subTreeMap.containsKey(n)) {
            return subTreeMap.get(n);
        }
        // 没有缓存的话 插入 遍历左边孩子个数
        for (int i = 0; i < n; i++) {
            // 左子树不可能偶数个
            if (i % 2 == 0) {
                continue;
            }
            // 右子树不可能偶数个
            List<TreeNode> leftChildList = allPossibleFBT(i);
            List<TreeNode> rightChildList = allPossibleFBT(n - i - 1);
            for (TreeNode left : leftChildList) {
                for (TreeNode right : rightChildList) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        subTreeMap.put(n, list);
        return list;
    }

}

package com.potato.study.leetcodecn.p01305.t001;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 *
 * 给你 root1 和 root2 这两棵二叉搜索树。

 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.

  

 示例 1：



 输入：root1 = [2,1,4], root2 = [1,0,3]
 输出：[0,1,1,2,3,4]
 示例 2：

 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 输出：[-10,0,0,1,2,5,7,10]
 示例 3：

 输入：root1 = [], root2 = [5,1,7,0,2]
 输出：[0,1,2,5,7]
 示例 4：

 输入：root1 = [0,-10,10], root2 = []
 输出：[-10,0,10]
 示例 5：



 输入：root1 = [1,null,8], root2 = [8,1]
 输出：[1,1,8,8]
  

 提示：

 每棵树最多有 5000 个节点。
 每个节点的值在 [-10^5, 10^5] 之间。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 中序 遍历
     * 2. 归并排序
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        inorderGetElement(root1, result1);
        List<Integer> result2 = new ArrayList<>();
        inorderGetElement(root2, result2);
        // 归并排序 生成结果
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < result1.size() && index2 < result2.size()) {
            if (result1.get(index1) <= result2.get(index2)) {
                result.add(result1.get(index1++));
            } else {
                result.add(result2.get(index2++));
            }
        }
        while (index1 < result1.size()) {
            result.add(result1.get(index1++));
        }
        while (index2 < result2.size()) {
            result.add(result2.get(index2++));
        }
        return result;
    }


    /**
     * 中序遍历 head 生成 一个list
     * @param head
     * @return
     */
    private void inorderGetElement(TreeNode head, List<Integer> result) {
        if (head == null) {
            return;
        }
        inorderGetElement(head.left, result);
        result.add(head.val);
        inorderGetElement(head.right, result);
    }
}

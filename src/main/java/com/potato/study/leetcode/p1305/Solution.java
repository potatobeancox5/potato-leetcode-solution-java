package com.potato.study.leetcode.p1305;



import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author liuzhao11
 * 
 * 	1305. All Elements in Two Binary Search Trees
 *  
 *
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.



Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]


Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
 *         
 *         思路：
 *          两个二叉树 排序节点遍历结果
 *          中序遍历 合并结果
 *
 *
 *
 *

 *
 */
public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = this.reverseInOrder(root1);
        List<Integer> list2 = this.reverseInOrder(root2);

        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        if (i < list1.size()) {
            res.addAll(list1.subList(i, list1.size()));
        } else if (j < list2.size()) {
            res.addAll(list2.subList(j, list2.size()));
        }
        return res;
    }

    private List<Integer> reverseInOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        res.addAll(reverseInOrder(root.left));
        res.add(root.val);
        res.addAll(reverseInOrder(root.right));
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = null;
        TreeNode root2 = null;
        List<Integer> res = solution.getAllElements(root1, root2);
        System.out.println(res); // -7,-1,1,3,4
    }
}

package com.potato.study.leetcode.p0572;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         572. Subtree of Another Tree
 * 
 *         Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

3
/ \
4   5
/ \
1   2
Given tree t:
4
/ \
1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

3
/ \
4   5
/ \
1   2
/
0
Given tree t:
4
/ \
1   2
Return false.
 * 
 * 
 *         思路：
 *
 *       
 *          
 */
public class Solution {

    /**
     * 先序 遍历树，确定shi否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = isSameTree(s, t);

        if (!result && s!= null) {
            result = (result || isSubtree(s.left, t));
        }

        if (!result && s!= null) {
            result = (result || isSubtree(s.right, t));
        }

        return result;
    }

    /**
     * 判断两个树是否same
     * @param s
     * @param t
     * @return
     */
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
    }
}

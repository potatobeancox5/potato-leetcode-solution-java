package com.potato.study.leetcode.p0331;

/**
 * 
 * @author liuzhao11
 * 
 *         331. Verify Preorder Serialization of a Binary Tree
 * 
 *         One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

_9_
/   \
3     2
/ \   / \
4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: "1,#"
Output: false
Example 3:

Input: "9,#,#,1"
Output: false
 * 
 *         思路：
 *         https://www.cnblogs.com/grandyang/p/5174738.html
 *         顺序遍历数字，通过检查 # 容忍个数是否减到0 进行判断
 *         if #  count-- 判断是不是0 是的话直接返回
 *         else count++
 *
 *
 * 
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        int count = 1;
        String[] nodes = preorder.split(",");
        boolean isZero = false;
        for (String node : nodes) {
            if (isZero) {
                return false;
            }
            if ("#".equals(node)) {
                count--;
                if (count == 0) {
                    isZero = true;
                }
            } else {
                count++;
            }
        }
        return count == 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        String preorder = "1,#";
        String preorder = "9,#,#,1";
        boolean res = solution.isValidSerialization(preorder);
        System.out.println(res
        );
	}
}

package com.potato.study.leetcodecn.p00331.t001;

import java.util.List;
import java.util.Stack;

import org.junit.Assert;

/**
 * 331. 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        // usa stack if preorder is
        String[] nodeVal = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        int index = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (index == nodeVal.length) {
                return false;
            }
            pop--;
            if (pop > 0) {
                stack.add(pop);
            }
            if (!"#".equals(nodeVal[index])) {
                stack.add(2);
            }
            index++;
        }
        // stack 完了 pre还没用户
        return index == nodeVal.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean validSerialization = solution.isValidSerialization(str);
        System.out.println(validSerialization);
        Assert.assertEquals(true, validSerialization);

        str = "1,#";
        validSerialization = solution.isValidSerialization(str);
        System.out.println(validSerialization);
        Assert.assertEquals(false, validSerialization);

    }
}

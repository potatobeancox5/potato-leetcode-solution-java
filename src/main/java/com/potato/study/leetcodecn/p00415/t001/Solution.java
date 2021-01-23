package com.potato.study.leetcodecn.p00415.t001;

/**
 * 415. 字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

  

 提示：

 num1 和num2 的长度都小于 5100
 num1 和num2 都只包含数字 0-9
 num1 和num2 都不包含任何前导零
 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-strings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 依次相加 记录进位
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        boolean isCarry = false;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            char ch1 = num1.charAt(index1);
            char ch2 = num2.charAt(index2);
            int tmp = ch1 - '0' + ch2 - '0';
            if (isCarry) {
                tmp++;
            }
            // 处理大于10
            if (tmp > 9) {
                isCarry = true;
                tmp %= 10;
            } else {
                isCarry = false;
            }
            builder.insert(0, tmp);
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            char ch1 = num1.charAt(index1);
            int tmp = ch1 - '0';
            if (isCarry) {
                tmp++;
            }
            // 处理大于10
            if (tmp > 9) {
                isCarry = true;
                tmp %= 10;
            } else {
                isCarry = false;
            }
            builder.insert(0, tmp);
            index1--;
        }
        while (index2 >= 0) {
            char ch2 = num2.charAt(index2);
            int tmp = ch2 - '0';
            if (isCarry) {
                tmp++;
            }
            // 处理大于10
            if (tmp > 9) {
                isCarry = true;
                tmp %= 10;
            } else {
                isCarry = false;
            }
            builder.insert(0, tmp);
            index2--;
        }
        if (isCarry) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }


//    public static void main(String[] args) {
//        TreeNode root = TreeNodeUtil.generateTreeByArrayString("[5,3,6,2,4,null,7]");
//
//        Solution solution = new Solution();
//        TreeNode node = solution.deleteNode(root, 3);
//        TreeNodeUtil.printBSTTreeNodeInArrayString(node, 3);
//    }
}

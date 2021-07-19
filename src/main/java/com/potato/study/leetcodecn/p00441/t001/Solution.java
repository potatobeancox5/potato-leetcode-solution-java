package com.potato.study.leetcodecn.p00441.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 441. 排列硬币
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 *
 * n = 8
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    public int arrangeCoins(int n) {
        long total = 0;
        for (long i = 1; i <= n; i++) {
            total += i;
            if (total < n) {
                continue;
            } else if (total == n) {
                return (int)i;
            } else {
                return (int) (i-1);
            }
        }
        return -1;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode l1 = ListNodeUtil.stringToListNode("7 -> 2 -> 4 -> 3");
//        ListNode l2 = ListNodeUtil.stringToListNode("5 -> 6 -> 4");
//        ListNode listNode = solution.addTwoNumbers(l1, l2);
//        ListNodeUtil.printListNode(listNode);
//    }
}

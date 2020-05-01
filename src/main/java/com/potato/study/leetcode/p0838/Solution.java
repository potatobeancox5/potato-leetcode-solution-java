package com.potato.study.leetcode.p0838;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	838. Push Dominoes
 *  
 *         There are N dominoes in a line, and we place each domino vertically upright.

In the beginning, we simultaneously push some of the dominoes either to the left or to the right.



After each second, each domino that is falling to the left pushes the adjacent domino on the left.

Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state.

Example 1:

Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
Example 2:

Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Note:

0 <= N <= 10^5
String dominoes contains only 'L', 'R' and '.'
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/push-dominoes/solution/tui-duo-mi-nuo-by-leetcode/
 *
 *         从左向右扫描，我们的力每轮迭代减少 1.重置为 N 当我们遇到一个 'R' 时，所以 force[i] 比 force[j] 大当且仅当 dominoes[i] 比 dominoes[j] 离最左边的 'R' 近。
 *
 * 
 */
public class Solution {

    public String pushDominoes(String dominoes) {
        // 每个位置的受力
        int[] force = new int[dominoes.length()];
        // left -> right
        int eachForce = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                eachForce = dominoes.length();
            } else if (c == 'L') {
                eachForce = 0;
            } else {
                eachForce = Math.max(eachForce - 1, 0);
            }
            force[i] += eachForce;

        }
        // right -> left
        eachForce = 0;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                eachForce = dominoes.length();
            } else if (c == 'R') {
                eachForce = 0;
            } else {
                eachForce = Math.max(eachForce - 1, 0);
            }
            force[i] -= eachForce;

        }
        // last roud
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            if (force[i] > 0) {
                builder.append("R");
            } else if (force[i] < 0) {
                builder.append("L");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String dominoes = ".L.R...LR..L..";
        String result = solution.pushDominoes(dominoes);
        System.out.println(result);
        Assert.assertEquals("LL.RR.LLRRLL..", result);


        dominoes = "RR.L";
        result = solution.pushDominoes(dominoes);
        System.out.println(result);
        Assert.assertEquals("RR.L", result);
    }
}

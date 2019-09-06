package com.potato.study.leetcode.p1111;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 *  
 *         A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
We can similarly define the nesting depth depth(S) of any VPS S as follows:

depth("") = 0
depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.



Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).

Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.

Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.



Example 1:

Input: seq = "(()())"
Output: [0,1,1,1,1,0]
Example 2:

Input: seq = "()(())()"
Output: [0,0,0,1,1,0,1,1]


Constraints:

1 <= seq.size <= 10000


            题目含义：
字符串是有效的括号字符串（表示为VPS），当且仅当它由“（”和“）”字符组成时，并且：

它是空字符串，或
它可以写成AB（A与B连接），其中A和B是VPS，或者
它可以写成（A），其中A是VPS。
我们可以类似地定义任何VPS S的嵌套深度深度（S），如下所示：

深度（“”）= 0
深度（A + B）=最大值（深度（A），深度（B）），其中A和B是VPS
深度（“（”+ A +“）”）= 1 +深度（A），其中A是VPS。
例如，“”，“（）（）”和“（）（（）（））”是VPS（嵌套深度为0,1和2），“”（“和”（（）“是不是VPS的。

 真正的题目的开始：
给定VPS seq，将其分成两个不相交的子序列A和B，使得A和B是VPS（和A.length + B.length = seq.length）。

现在选择任何这样的A和B使得max（深度（A），深度（B））是最小可能值。

返回一个答案数组（长度为seq.length），编码A和B的选择：如果seq [i]是A的一部分，则回答[i] = 0，否则回答[i] = 1.注意即使是多个答案可能存在，您可以退回其中任何一个。
 *         
 *         思路：
 *          首先需要知道怎们分才能使得 AB 最小，AB 最小的条件就是AB的差值最小， 找到这个分割点
 *          然后判断每个位置属于A或者属于B
 *           ()(())()
 *           https://www.acwing.com/solution/leetcode/content/2745/
 *
 *
 *
 *

 *
 */
public class Solution {

    /**
     * 这个题真的表述的很模糊
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        // 1. 判断 （ 深度
        int max = Integer.MIN_VALUE;
        int[] depth = new int[seq.length()];
        int current = 0;
        for (int i = 0; i < seq.length(); i++) {
            if ('(' == seq.charAt(i)) {
                depth[i] = ++current;
            } else {
                depth[i] = current--;
            }
            max = Math.max(current, max);
        }
        // 2. 按照深度一半分割
        max /= 2;
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (depth[i] <= max) {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String seq = "(()())";
//		String seq = "()(())()";
        int[] ints = solution.maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(ints));
    }
}

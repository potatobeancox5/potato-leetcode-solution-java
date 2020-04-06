package com.potato.study.leetcode.p0816;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	816. Ambiguous Coordinates
 *  
 *         We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.

Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

Example 1:
Input: "(123)"
Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
Example 2:
Input: "(00011)"
Output:  ["(0.001, 1)", "(0, 0.011)"]
Explanation:
0.0, 00, 0001 or 00.01 are not allowed.
Example 3:
Input: "(0123)"
Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
Example 4:
Input: "(100)"
Output: [(10, 0)]
Explanation:
1.0 is not allowed.


Note:

4 <= S.length <= 12.
S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
 *         
 *         思路：
 *          给出一个 模棱两可 的字符串 字符串代表 几个数字
 *          返回 可能代表的数字 坐标
 *
 *          https://blog.csdn.net/excellentlizhensbfhw/article/details/84946322
 *
 *
 *
 *
 */
public class Solution {

    public List<String> ambiguousCoordinates(String s) {
        List<String> resultList = new ArrayList<>();
        // 遍历 逗号位置 对于每个位置 将左右转换成合法数字，否则
        for (int i = 2; i < s.length() - 1; i++) {
            for (String left : parse(s, 1, i)) {
                for (String right: parse(s, i, s.length()-1)){
                    resultList.add("(" + left + ", " + right + ")");
                }
            }
        }
        return resultList;
    }

    /**
     * 将 s 中 i-j 的数字 转换成可能的数字
     * @param s
     * @param i     开始位置
     * @param j     结束位置
     * @return      可能的数字结果
     */
    private List<String> parse(String s, int i, int j) {
        List<String> list = new ArrayList<>();
        for (int k = 1; k <= j - i ; k++) {
            String left = s.substring(i, i + k);
            String right = s.substring(i + k, j);
            // add point
            if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                // 最后一个位置 不用加 .
                list.add(left + (k < j-i ? "." : "") + right);
            }
        }
        return list;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "";
        List<String> list = solution.ambiguousCoordinates(s);
        System.out.println(list);
    }
}

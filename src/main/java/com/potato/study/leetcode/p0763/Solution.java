package com.potato.study.leetcode.p0763;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	763. Partition Labels
 *  
 *         A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.


 *   题目大意：
 *
 *
 *   解题思路：
 *   https://blog.csdn.net/u012737193/article/details/79099153
    贪心算法
    从字符串最左边index开始，找到它最右边出现位置 last
    依次查找index + 1. — 直到last位置
    如果 index + k 位置 的最右边大于last 则更新last
    找到last位置时，可以将前last当作一个子序列
    依次类推接着找
 * 
 */
public class Solution {

    public List<Integer> partitionLabels(String str) {
        List<Integer> result = new ArrayList<>();
        // 遍历字符串str 获取当前index i 记录当前遍历到的位置
        int index = 0;
        while(index < str.length()) {

            char ch = str.charAt(index);
            // 查找当前index位置字符 在str中出现的最后位置last
            int last = index;
            for (int i = index + 1; i < str.length(); i++) {
                if (str.charAt(i) == ch) {
                    last = i;
                }
            }
            int start = index;
            if (last > index) {
                index++;
                // 之后的节点可以继续遍历
                while (index < last) {
                    char currentCh = str.charAt(index);
                    int currentLast = index;
                    for (int i = index + 1; i < str.length(); i++) {
                        if (str.charAt(i) == currentCh) {
                            currentLast = i;
                        }
                    }
                    if (currentLast > last) {
                        last = currentLast;
                    }
                    index++;
                }
                result.add(last - start + 1);
            } else {
                result.add(1);
            }
            index++;
        }
        return result;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String str = "caedbdedda";
		String str = "ababcbacadefegdehijhklij";
        List<Integer> list = solution.partitionLabels(str);
        System.out.println(list);
    }
}

package com.potato.study.leetcode.p0767;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	767. Reorganize String
 *  
 *         Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].

 *   题目大意：
 *      给一个字符串 问 能不能 对字符串重构 使得任意两个相同的字符 不能挨着
 *
 *
 *   解题思路：
 *
 *      1. 计数器计数 如果 查过 >（len + 1）/ 2 返回 ''
 *      2. 按照次数最大 大跟堆 放到对中
 *      3. 每次 选2个 最大的pop 减完 再将不为0 的放进去
 *      4. 最终一个 放进去
 *
 *
 * 
 */
public class Solution {

    public String reorganizeString(String s) {

        // 1. 计数器计数 如果 查过 >（len + 1）/ 2 返回 ''
        int[] count = new int[26];
        int limit = (s.length() + 1) / 2;
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            if (count[ch - 'a'] > limit) {
                return "";
            }
        }
        // 2. 按照次数最大 大跟堆 放到对中
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            priorityQueue.add(new int[]{i, count[i]});
        }
        // 3. 每次 选2个 最大的pop 减完 再将不为0 的放进去
        StringBuilder builder = new StringBuilder();
        while (priorityQueue.size() >= 2) {
            int[] pollBig = priorityQueue.poll();
            int[] pollSmall = priorityQueue.poll();
            builder.append((char)('a' + pollBig[0])).append((char)('a' + pollSmall[0]));
            pollBig[1]--;
            pollSmall[1]--;
            if (pollBig[1] > 0) {
                priorityQueue.add(pollBig);
            }
            if (pollSmall[1] > 0) {
                priorityQueue.add(pollSmall);
            }
        }
        // only you only 1
        if (priorityQueue.size() > 0) {
            builder.append((char)(priorityQueue.poll()[0] + 'a'));
        }
        return builder.toString();
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "aab";
        String str = solution.reorganizeString(s);
        System.out.println(str);
        Assert.assertEquals("aba", str);

        s = "aaab";
        str = solution.reorganizeString(s);
        System.out.println(str);
        Assert.assertEquals("", str);
    }
}

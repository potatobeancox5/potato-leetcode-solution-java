package com.potato.study.leetcode.p0854;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	854. K-Similar Strings
 *  
 *         Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:

Input: A = "ab", B = "ba"
Output: 1
Example 2:

Input: A = "abc", B = "bca"
Output: 2
Example 3:

Input: A = "abac", B = "baca"
Output: 2
Example 4:

Input: A = "aabc", B = "abca"
Output: 2
Note:

1 <= A.length == B.length <= 20
A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         854. K-Similar Strings

https://leetcode-cn.com/problems/k-similar-strings/solution/cu-su-yi-dong-di-gui-hui-su-si-lu-by-tuo-jiang-de-
 *
 *          从最左边的i=0位置开始，对比A和B的字符，如果当前位置i的字符不相等，就在B中后面字符i+1及后面位置中找和当前A中i位置相等的字符，找到后就进行交换位置，然后递归进去从i+1的位置开始直到最末尾位置时记录当前交换次数，具体看代码，非常直观
 *
 *
 *
 *
 */
public class Solution {

    private int min;

    public int kSimilarity(String a, String b) {
        this.min = Integer.MAX_VALUE;
        // 递归找 两个数组
        doSelect(a.toCharArray(), b.toCharArray(), a.length(), 0, 0);
        return min;
    }

    /**
     * 递归查找并交换获得 达到相同的最小步数
     * @param recordA
     * @param recordB
     * @param len
     * @param curCount      目前交换的次数
     * @param curIndex      目前比较的index
     */
    private void doSelect(char[] recordA, char[] recordB, int len, int curCount, int curIndex){
        // 当前找到 次数 已经大于了最小次数 返回吧
        if (curCount > min) {
            return;
        }
        // 终止条件 已经找到了 len - 1 位置
        if (curIndex == len - 1) {
            if (curCount < min) {
                min = curCount;
            }
            return;
        }

        int i;
        for (i = curIndex; i < len; i++) {
            // 当前两个位置的元素相当的话 比较下一个位置
            if (recordA[i] == recordB[i]) {
                continue;
            }
            // 不相等，进行从recordB后续的字符中找与当前A中相等的字符进行替换
            char aCurChar = recordA[i];
            int k = i + 1;
            for (; k < len; k++){
                if (aCurChar == recordB[k]){
                    // 找到其中一个与aCurChar相等的字符，则进行位置交换
                    swap(recordB, i, k);
                    // 递归进行替换
                    doSelect(recordA, recordB, len, curCount + 1, i + 1);
                    // 替换回来
                    swap(recordB, i, k);
                }
            }
            return;
        }

        if (i == len && curCount < min) {
            min = curCount;
        }
    }

    /**
     * 交换ch 数组中 位置为 index1 和index 2 的连个位置
     * @param ch
     * @param index1
     * @param index2
     */
    private void swap (char[] ch, int index1, int index2) {
        char cc = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = cc;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String a = "ab";
        String b = "ba";
        int result = solution.kSimilarity(a, b);
        System.out.println(result);
        Assert.assertEquals(1, result);


        a = "abc";
        b = "bca";
        result = solution.kSimilarity(a, b);
        System.out.println(result);
        Assert.assertEquals(2, result);
    }
}
